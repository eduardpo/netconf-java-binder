# README #

### What is this repository for? ###
1. Automatic translation of YANG models to XML/RPC request messages sent to device. 
2. Automatic deserialization (unmarshaling) of RPC reply messages received from device.


### How do I get set up? ###
This project depends on yang_to_xml, therefore in order to clone:

git clone --recurse-submodules https://github.com/eduardpo/netconf-java-binder.git

If you already cloned the project and forgot --recurse-submodules:

git submodule update --init --recursive


### Configuration guidelines: script\yang_source.ini ###
[DEFAULT]
source = device

[github.source]
repo = git@github.com:siklu/tg_yang_models.git

[device.source]
path = root@192.168.0.1:/usr/share/siklu@0.0.0


### How do I run it? ###
1. cd script
2. sudo ./main
