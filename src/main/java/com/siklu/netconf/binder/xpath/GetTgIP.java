package com.siklu.netconf.binder.xpath;

import lombok.Getter;

public enum GetTgIP {

    RPCS("", "xmlns:rb-tg-ip", "http://siklu.com/yang/tg/ip", "rb-tg-ip:rpcs"),
    GET_DEVICE_IPV6_ADDRESS_IPV6("", "xmlns:rb-tg-ip", "http://siklu.com/yang/tg/ip", "/rb-tg-ip:get-device-ipv6-address/rb-tg-ip:ipv6"),
    IP("ip", "xmlns:rb-tg-ip", "http://siklu.com/yang/tg/ip", "/rb-tg-ip:ip"),
    ADDRESS_PREFIX_LENGTH("ip", "xmlns:rb-tg-ip", "http://siklu.com/yang/tg/ip", "/rb-tg-ip:ip/rb-tg-ip:ipv4/rb-tg-ip:address/rb-tg-ip:prefix-length"),
    GET_DEVICE_IPV6_ADDRESS_ASSIGNED_NAME("ip", "xmlns:rb-tg-ip", "http://siklu.com/yang/tg/ip", "/rb-tg-ip:get-device-ipv6-address/rb-tg-ip:assigned-name"),
    IPV4_ADDRESS("ip", "xmlns:rb-tg-ip", "http://siklu.com/yang/tg/ip", "/rb-tg-ip:ip/rb-tg-ip:ipv4/rb-tg-ip:address"),
    IPV4_DEFAULT_GATEWAY("ip", "xmlns:rb-tg-ip", "http://siklu.com/yang/tg/ip", "/rb-tg-ip:ip/rb-tg-ip:ipv4/rb-tg-ip:default-gateway"),
    IP_IPV4("ip", "xmlns:rb-tg-ip", "http://siklu.com/yang/tg/ip", "/rb-tg-ip:ip/rb-tg-ip:ipv4"),
    IP_IPV6("ip", "xmlns:rb-tg-ip", "http://siklu.com/yang/tg/ip", "/rb-tg-ip:ip/rb-tg-ip:ipv6"),
    ADDRESS_IP("ip", "xmlns:rb-tg-ip", "http://siklu.com/yang/tg/ip", "/rb-tg-ip:ip/rb-tg-ip:ipv4/rb-tg-ip:address/rb-tg-ip:ip"),
    GET_DEVICE_IPV6_ADDRESS("get-device-ipv6-address", "xmlns:rb-tg-ip", "http://siklu.com/yang/tg/ip", "/rb-tg-ip:get-device-ipv6-address"),
    IPV6_LINK_LOCAL("get-device-ipv6-address", "xmlns:rb-tg-ip", "http://siklu.com/yang/tg/ip", "/rb-tg-ip:ip/rb-tg-ip:ipv6/rb-tg-ip:link-local");

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
