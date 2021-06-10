package com.siklu.netconf.binder.xpath;

import lombok.Getter;

public enum GetTgIP {

    ADDRESS_IP("", "xmlns:rb-tg-ip", "http://siklu.com/yang/tg/ip", "/rb-tg-ip:ip/rb-tg-ip:ipv4/rb-tg-ip:address/rb-tg-ip:ip"),
    IP_IPV4("", "xmlns:rb-tg-ip", "http://siklu.com/yang/tg/ip", "/rb-tg-ip:ip/rb-tg-ip:ipv4"),
    IPV4_ADDRESS("", "xmlns:rb-tg-ip", "http://siklu.com/yang/tg/ip", "/rb-tg-ip:ip/rb-tg-ip:ipv4/rb-tg-ip:address"),
    ADDRESS_PREFIX_LENGTH("", "xmlns:rb-tg-ip", "http://siklu.com/yang/tg/ip", "/rb-tg-ip:ip/rb-tg-ip:ipv4/rb-tg-ip:address/rb-tg-ip:prefix-length"),
    IP("ip", "xmlns:rb-tg-ip", "http://siklu.com/yang/tg/ip", "/rb-tg-ip:ip"),
    IPV4_DEFAULT_GATEWAY("ip", "xmlns:rb-tg-ip", "http://siklu.com/yang/tg/ip", "/rb-tg-ip:ip/rb-tg-ip:ipv4/rb-tg-ip:default-gateway");

    @Getter
    String rootTag;
    @Getter
    String prefix;
    @Getter 
    String ns;
    @Getter
    String xpath;
        
    private GetTgIP(String rootTag, String prefix, String ns, String xpath) {
        this.rootTag = rootTag;
        this.prefix = prefix;
        this.ns = ns;
        this.xpath = xpath;
    }
}
