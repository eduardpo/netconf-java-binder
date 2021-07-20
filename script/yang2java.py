#!/usr/bin/python3

import getopt, sys, os
import subprocess
from enum import Enum
import configparser
from ntpath import basename

ROOT_OUT = 'jaxb_out'
XSD_OUT = 'xsd_out'
PACKAGE_PREF = 'com.siklu.netconf.binder.gen'
YANG_SOURCE_INI = 'yang_source.ini'

class FileAction(Enum):
	CREATE = 1
	EDIT = 2
	FINALIZE = 3

get_enum_header = """package com.siklu.netconf.binder.xpath;

import lombok.Getter;

public enum SIKLUNETCONF {

"""
get_enum_footer="""
    @Getter
    String rootTag;
    @Getter
    String prefix;
    @Getter 
    String ns;
    @Getter
    String xpath;
        
    private SIKLUNETCONF(String rootTag, String prefix, String ns, String xpath) {
        this.rootTag = rootTag;
        this.prefix = prefix;
        this.ns = ns;
        this.xpath = xpath;
    }
}
"""

edit_enum_header = """package com.siklu.netconf.binder.xpath;

import lombok.Getter;

public enum  SIKLUNETCONF {

"""
edit_enum_footer="""
    @Getter
    String xmlTemplate;
    @Getter
    String leaf;
        
    private SIKLUNETCONF(String xmlTemplate, String leaf) {
        this.xmlTemplate = xmlTemplate;
        this.leaf = leaf; 
    }
}
"""

def get_path(): 
    with open("pyang_out/xpath/radio_common_noprefix.txt") as fp: 
        for line in fp: 
            if line.split('/')[-1] == 'active\n': 
                return line.strip()

def get_xpath(base_fname, leaf): 
    with open(base_fname +"_xpath.txt") as fp: 
        for line in fp: 
            if line.split('/')[-1].split(':')[-1] == leaf + '\n': 
                return line.strip()

def get_prefix(yang):
    with open(yang) as fp:
        for line in fp:
            if 'prefix' in line:
                prefix = line.split()[-1].strip().replace(';', ':')
                for p in ['sys', 'ip', 'bridge']:# UGLY WORKOROUND _ REOPEN BUG ON DIMA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                    if p in prefix: 
                        prefix = line.split()[-1].strip().replace('"', '')
                        prefix = prefix.replace(';', ':')
                print(prefix) # must be here
                return prefix

def get_namespace(yang):
    with open(yang) as fp:
        for line in fp:
            lline = line.split()
            if len(lline) == 2 and lline[0] == 'namespace':
                namespace = lline[1][:-1]
    #print namespace  # uncommment to call from batch
    return namespace


def render_java_get(base_fname):
    xpath_file_name = "pyang_out/path/" + base_fname + "_xpath.txt"
    #java_file_name = "pyang_out/java/Get" + base_fname.split('-')[-2][0].upper() + base_fname.split('-')[-2][1:] + base_fname.split('-')[-1].upper() + "SikluNetconfXpath.java"
    java_file_name = "pyang_out/java/Get" + base_fname.split('-')[-2][0].upper() + base_fname.split('-')[-2][1:] + base_fname.split('-')[-1].upper() + ".java"
    root = ""
    prefix = get_prefix(base_fname + '.yang')
    with open(xpath_file_name) as src, open(java_file_name, 'w') as java:
        lines = set(src.readlines())
        java.write(get_enum_header)
        i = 0
        new_line = ',\n'
        for line in lines: 
            if len(line.split('/')) > 2:
                parent = line.split('/')[-2].split(':')[-1].strip()
            elif len(line.split('/')) == 2:
                root = line.split('/')[1].split(':')[-1].strip()
                #print root
                parent = ""
            else:
                parent = ""
            leaf = line.split('/')[-1].split(':')[-1].strip() 
            #print("********************")
            #print("PARENT: " + parent)
            #print("LEAF: " + leaf)
            #print(line)
            if parent != "":
                parent = parent + '_'

            if i == len(lines) - 1:
                new_line = ';\n'
            #java.write("    GET_" + parent.upper().replace('-', '_') + leaf.upper().replace('-', '_') + '(\"' + root.strip() + '\", \"xmlns:' + prefix[:-1] + '\", ' + get_namespace(base_fname + '.yang') + ', \"' + line.strip() + '\")' + new_line)
            java.write("    " + parent.upper().replace('-', '_') + leaf.upper().replace('-', '_') + '(\"' + root.strip() + '\", \"xmlns:' + prefix[:-1] + '\", ' + get_namespace(base_fname + '.yang') + ', \"' + line.strip() + '\")' + new_line)
            i += 1
        java.write(get_enum_footer)

    normalize(java_file_name)

def generate_xsd(ns):
    os.system('../yang_to_xml/pyanggen -f xsd ' + ns + '.yang > '  + XSD_OUT + '/' + ns + '.xsd')


def generate_jaxb(ns):
    dir_out = get_output_dir(ns)
    os.system('/usr/lib/jvm/java-8-openjdk-amd64/bin/xjc -d ' + dir_out + ' -p generated ' + XSD_OUT + '/' + ns + '.xsd')
    fix_package_name(dir_out + '/generated')


def fix_package_name(dir_out):
    for filename in os.listdir(dir_out):
        if filename.endswith(".java"):
            file_path = os.path.join(dir_out, filename)
            with open(file_path, 'r+') as f:
                lines = f.readlines() 
                f.seek(0)
                for line in lines:
                    if 'package generated;' in line:
                        f.write('package ' + PACKAGE_PREF + '.' + dir_out.split('/')[-2] + '.generated;\n')
                    else:
                        f.write(line)
                f.truncate()


def get_output_dir(ns):
    dir_out = ROOT_OUT + '/' + ns.split('-')[-1]
    if not os.path.isdir(dir_out):
        os.system('mkdir ' + dir_out)
    return dir_out


def normalize(java_fname):
    base_fname = os.path.basename(os.path.splitext(java_fname)[0])
    #print("NORMALIZE BASE NAME: " + base_fname)
    if 'Get' in base_fname or 'Edit' in base_fname:
    	with open(java_fname, 'r+') as fp:
            lines = fp.readlines()
            fp.seek(0)
            for line in lines:
                if 'SIKLUNETCONF' in line:
                    fp.write(line.replace('SIKLUNETCONF', base_fname))
                elif 'CLEAR_ALL_FW_COUNTERS' in line and line[-2] != ',':
                    #print("LINE: " + line)
                    #print("LAST CH: " +  line[-2])
                    fp.write(line)
                elif 'CLEAR_ALL_FW_COUNTERS' not in line:
                    fp.write(line)
            fp.truncate()
    else:
        print("WRONG JAVA FILE NAME!")
        exit(2)


def get_yang_model():
    src = ''; yang_dir = ''
    config = configparser.ConfigParser()
    if os.path.isfile(YANG_SOURCE_INI):
        config.read(YANG_SOURCE_INI)
    else:
        print('\nyang_source.ini soes not exist')
        exit(1)
    #os.system('scp -r root@' + device + ':/usr/share/siklu@0.0.0 .')
    print('\nCurrent Yang source: ' + config['DEFAULT']['source'])
    if  config['DEFAULT']['source'] == 'github':
        src = config['github.source']['repo']
        os.system('git clone ' + src)
        yang_dir = basename(src).split('.')[0]
    elif config['DEFAULT']['source'] == 'device':
        src = config['device.source']['path']
        os.system('scp -r ' + src + ' .')
        yang_dir = basename(src)
    else:
        yang_dir = 'bad source'
    if yang_dir != 'bad source' and not os.path.isdir(yang_dir):
        return 'get failed' 
    return yang_dir


if __name__ == "__main__":
    try:
        opts, args = getopt.getopt(sys.argv[1:], "hcp:x:b:j:", ["help", "getp", "xsd=",  "jaxb=", "java=", "copy="])
    except getopt.GetoptError as err:
        print(err)
        sys.exit(2) 
    for o, a in opts:
        if o in ("-p", "--getp"):
            get_prefix(a)
        elif o in ("-x", "--xsd"):
            generate_xsd(a)
        elif o in ("-b", "--jaxb"):
            generate_jaxb(a)
        elif o in ("-j", "--java"):
            yang_dir = render_java_get(a)
        elif o in ("-c", "--copy"):
            exit(get_yang_model())
        else:
            assert False, "unhandled option"

