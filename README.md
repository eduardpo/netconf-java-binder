# README #

## Features
1. Automatic generation of Java code through Netconf YANG modules.
2. Serialization of Java objects to RPC request messages to be sent to device.
3. Deserialization of RPC reply messages received from device and unmarshalling them to Java objects.


## Setup ##
This project depends on yang_to_xml, therefore in order to clone:

git clone --recurse-submodules git@github.com:eduardpo/netconf-java-binder.git

If you already cloned the project and forgot --recurse-submodules:

git submodule update --init --recursive


## Configuration ##

### script\yang_source.ini: ###

[DEFAULT]
source = device

[github.source]
repo = git@github.com:siklu/tg_yang_models.git

[device.source]
path = root@192.168.0.1:/usr/share/siklu@0.0.0


## Usage ##
1. cd script
2. sudo ./main
