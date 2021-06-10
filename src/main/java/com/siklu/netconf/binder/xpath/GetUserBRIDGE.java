package com.siklu.netconf.binder.xpath;

import lombok.Getter;

public enum GetUserBRIDGE {

    BRIDGE_BRIDGE_PORT("", "xmlns:tg-u-bridge", "http://siklu.com/yang/tg/user-bridge", "/tg-u-bridge:user-bridge/tg-u-bridge:bridge/tg-u-bridge:bridge-port"),
    BRIDGE_STATE("", "xmlns:tg-u-bridge", "http://siklu.com/yang/tg/user-bridge", "/tg-u-bridge:user-bridge/tg-u-bridge:bridge/tg-u-bridge:state"),
    USER_BRIDGE("user-bridge", "xmlns:tg-u-bridge", "http://siklu.com/yang/tg/user-bridge", "/tg-u-bridge:user-bridge"),
    BRIDGE_BRIDGE_ID("user-bridge", "xmlns:tg-u-bridge", "http://siklu.com/yang/tg/user-bridge", "/tg-u-bridge:user-bridge/tg-u-bridge:bridge/tg-u-bridge:bridge-id"),
    USER_BRIDGE_BRIDGE("user-bridge", "xmlns:tg-u-bridge", "http://siklu.com/yang/tg/user-bridge", "/tg-u-bridge:user-bridge/tg-u-bridge:bridge"),
    BRIDGE_PORT_BRIDGE_PORT_TYPE("user-bridge", "xmlns:tg-u-bridge", "http://siklu.com/yang/tg/user-bridge", "/tg-u-bridge:user-bridge/tg-u-bridge:bridge/tg-u-bridge:bridge-port/tg-u-bridge:bridge-port-type"),
    BRIDGE_PORT_BRIDGE_PORT_ID("user-bridge", "xmlns:tg-u-bridge", "http://siklu.com/yang/tg/user-bridge", "/tg-u-bridge:user-bridge/tg-u-bridge:bridge/tg-u-bridge:bridge-port/tg-u-bridge:bridge-port-id"),
    BRIDGE_PORT_INTERFACE("user-bridge", "xmlns:tg-u-bridge", "http://siklu.com/yang/tg/user-bridge", "/tg-u-bridge:user-bridge/tg-u-bridge:bridge/tg-u-bridge:bridge-port/tg-u-bridge:interface"),
    BRIDGE_PORT_C_VLAN("user-bridge", "xmlns:tg-u-bridge", "http://siklu.com/yang/tg/user-bridge", "/tg-u-bridge:user-bridge/tg-u-bridge:bridge/tg-u-bridge:bridge-port/tg-u-bridge:c-vlan"),
    BRIDGE_PORT_S_VLAN("user-bridge", "xmlns:tg-u-bridge", "http://siklu.com/yang/tg/user-bridge", "/tg-u-bridge:user-bridge/tg-u-bridge:bridge/tg-u-bridge:bridge-port/tg-u-bridge:s-vlan");

    @Getter
    String rootTag;
    @Getter
    String prefix;
    @Getter 
    String ns;
    @Getter
    String xpath;
        
    private GetUserBRIDGE(String rootTag, String prefix, String ns, String xpath) {
        this.rootTag = rootTag;
        this.prefix = prefix;
        this.ns = ns;
        this.xpath = xpath;
    }
}
