package com.siklu.netconf.binder.xpath;

import lombok.Getter;

public enum GetUserBRIDGE {

    USER_BRIDGE_BRIDGE("", "xmlns:tg-u-bridge", "http://siklu.com/yang/tg/user-bridge", "/tg-u-bridge:user-bridge/tg-u-bridge:bridge"),
    BRIDGE_PORT_S_VLAN("", "xmlns:tg-u-bridge", "http://siklu.com/yang/tg/user-bridge", "/tg-u-bridge:user-bridge/tg-u-bridge:bridge/tg-u-bridge:bridge-port/tg-u-bridge:s-vlan"),
    BRIDGE_PORT_C_VLAN("", "xmlns:tg-u-bridge", "http://siklu.com/yang/tg/user-bridge", "/tg-u-bridge:user-bridge/tg-u-bridge:bridge/tg-u-bridge:bridge-port/tg-u-bridge:c-vlan"),
    BRIDGE_STATE("", "xmlns:tg-u-bridge", "http://siklu.com/yang/tg/user-bridge", "/tg-u-bridge:user-bridge/tg-u-bridge:bridge/tg-u-bridge:state"),
    BRIDGE_PORT_BRIDGE_PORT_ID("", "xmlns:tg-u-bridge", "http://siklu.com/yang/tg/user-bridge", "/tg-u-bridge:user-bridge/tg-u-bridge:bridge/tg-u-bridge:bridge-port/tg-u-bridge:bridge-port-id"),
    BRIDGE_PORT_INTERFACE("", "xmlns:tg-u-bridge", "http://siklu.com/yang/tg/user-bridge", "/tg-u-bridge:user-bridge/tg-u-bridge:bridge/tg-u-bridge:bridge-port/tg-u-bridge:interface"),
    BRIDGE_BRIDGE_PORT("", "xmlns:tg-u-bridge", "http://siklu.com/yang/tg/user-bridge", "/tg-u-bridge:user-bridge/tg-u-bridge:bridge/tg-u-bridge:bridge-port"),
    USER_BRIDGE("user-bridge", "xmlns:tg-u-bridge", "http://siklu.com/yang/tg/user-bridge", "/tg-u-bridge:user-bridge"),
    BRIDGE_PORT_BRIDGE_PORT_TYPE("user-bridge", "xmlns:tg-u-bridge", "http://siklu.com/yang/tg/user-bridge", "/tg-u-bridge:user-bridge/tg-u-bridge:bridge/tg-u-bridge:bridge-port/tg-u-bridge:bridge-port-type"),
    BRIDGE_BRIDGE_ID("user-bridge", "xmlns:tg-u-bridge", "http://siklu.com/yang/tg/user-bridge", "/tg-u-bridge:user-bridge/tg-u-bridge:bridge/tg-u-bridge:bridge-id");

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
