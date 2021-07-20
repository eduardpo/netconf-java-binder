#!/bin/bash

echo #
echo '***** START *****'
echo #

if [[ "$EUID" -ne 0 ]]; then
	echo "This scirpt requires superuser privileges!"
	echo #
	echo "Usage: sudo ./main.sh"
	echo #
	exit 1
fi

if [ "$(which dos2unix)" == "" ]; then
	echo Installing dos2unix...
	echo '**********'
	sudo apt-get update
	sudo apt-get install dos2unix
fi
find . -type f -print0 | xargs -0 dos2unix

if [ -d "siklu@0.0.0" ]; then rm -rf "siklu@0.0.0"; fi
if [ -d "tg_yang_models" ]; then rm -rf "tg_yang_models"; fi
if [ -d "jaxb_out" ]; then rm -rf "jaxb_out"; fi
if [ -d "xsd_out" ]; then rm -rf "xsd_out"; fi
if [ -d "pyang_out" ]; then rm -rf "pyang_out"; fi

echo #
echo Downloading YANG models...
echo '**********'
YANG_DIR=$(./yang2java.py -c 2>&1 | tail -1)
if [ "$YANG_DIR" == "bad source" ]; then
	echo #
	echo "error: bad yang source, check default source in yang_source.ini"
	echo #
	exit 1
fi
if [ "$YANG_DIR" == "get failed" ]; then
	echo #
	echo "error: get yang models failed, check connectivity"
	echo #
	exit 1
fi
echo #
echo '##### DONE #####'
echo #

cd $YANG_DIR

mkdir -p pyang_out
mkdir -p pyang_out/js
mkdir -p pyang_out/xml
mkdir -p pyang_out/java
mkdir -p pyang_out/path
mkdir -p jaxb_out
mkdir -p xsd_out

chmod +x ../yang_to_xml/pyanggen

for filename in *.yang; do
	base_fname=$(basename $filename .yang)
	echo "Generate XSD file for $base_fname"
	echo '**********'
	../yang2java.py -x $base_fname
done

for filename in *.yang; do
	base_fname=$(basename $filename .yang)
	if [[ $base_fname == *"radio-dn"* || $base_fname == *"radio-common"* || $base_fname == *"system"* || $base_fname == *"user-bridge"* || $base_fname == *"ip"* ]]; then
		echo #
		echo "Create Java Enum file for $base_fname"
		echo '**********'
		echo #
		prefix=$(../yang2java.py -p $filename)
		pyang -f jstree -o pyang_out/js/$base_fname.html $filename
		grep -r $prefix pyang_out/js/$base_fname.html | sed -e 's/<[^>]*>//g' > pyang_out/path/"$base_fname"_xpath.txt
		../yang2java.py -j $base_fname
		echo #
		echo '##### DONE #####'
		echo #
		echo "Generate JAXB source for $base_fname"
		echo '**********'
		echo #
		../yang2java.py -b $base_fname
		echo #
		echo '##### DONE #####'
	fi
done


echo #
echo "Copy Final Product"
echo '**********'
cp -rf pyang_out/java/* ../../src/main/java/com/siklu/netconf/binder/xpath
cp -rf jaxb_out/* ../../src/main/java/com/siklu/netconf/binder/gen
chown -R ${SUDO_USER}:100 ../../src/main/java/com/siklu/netconf/binder/gen
chown -R $(logname):100 ../../src/main/java/com/siklu/netconf/binder/gen
rm -rf ../$YANG_DIR/

echo #
echo '#### DONE #####'
echo #

