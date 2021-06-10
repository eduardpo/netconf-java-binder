package com.siklu.netconf.binder.xpath;

import lombok.Getter;

public enum GetRadioDN {

    RADIO_DN("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn"),
    RADIO_PROFILE_FREQUENCY("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:sectors-config/rb-tg-radio-dn:sector/rb-tg-radio-dn:radio-profile/rb-tg-radio-dn:frequency"),
    CONFIGURED_RESPONDER_NODE_TYPE("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:links/rb-tg-radio-dn:configured/rb-tg-radio-dn:responder-node-type"),
    DEFAULT_RADIO_PROFILE_FREQUENCY("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:node-config/rb-tg-radio-dn:default-radio-profile/rb-tg-radio-dn:frequency"),
    CONFIGURED_ADMIN_STATUS("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:links/rb-tg-radio-dn:configured/rb-tg-radio-dn:admin-status"),
    DEFAULT_RADIO_PROFILE_RX_GOLAY_INDEX("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:node-config/rb-tg-radio-dn:default-radio-profile/rb-tg-radio-dn:rx-golay-index"),
    RADIO_PROFILE_RX_GOLAY_INDEX("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:sectors-config/rb-tg-radio-dn:sector/rb-tg-radio-dn:radio-profile/rb-tg-radio-dn:rx-golay-index"),
    NODE_CONFIG_DEFAULT_RADIO_PROFILE("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:node-config/rb-tg-radio-dn:default-radio-profile"),
    SECTOR_RADIO_PROFILE("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:sectors-config/rb-tg-radio-dn:sector/rb-tg-radio-dn:radio-profile"),
    CONFIGURED_LOCAL_SECTOR("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:links/rb-tg-radio-dn:configured/rb-tg-radio-dn:local-sector"),
    REMOTE_SECTOR_INDEX("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:links/rb-tg-radio-dn:configured/rb-tg-radio-dn:remote-sector/rb-tg-radio-dn:index"),
    CONFIGURED_REMOTE_ASSIGNED_NAME("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:links/rb-tg-radio-dn:configured/rb-tg-radio-dn:remote-assigned-name"),
    NODE_CONFIG_IGNORE_GPS("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:node-config/rb-tg-radio-dn:ignore-gps"),
    RADIO_DN_SECTORS_CONFIG("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:sectors-config"),
    SECTOR_INDEX("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:sectors-config/rb-tg-radio-dn:sector/rb-tg-radio-dn:index"),
    LOCAL_SECTOR_INDEX("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:links/rb-tg-radio-dn:configured/rb-tg-radio-dn:local-sector/rb-tg-radio-dn:index"),
    CONFIGURED_REMOTE_SECTOR("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:links/rb-tg-radio-dn:configured/rb-tg-radio-dn:remote-sector"),
    RADIO_PROFILE_TX_GOLAY_INDEX("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:sectors-config/rb-tg-radio-dn:sector/rb-tg-radio-dn:radio-profile/rb-tg-radio-dn:tx-golay-index"),
    RADIO_DN_NODE_CONFIG("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:node-config"),
    CONFIGURED_CONTROL_SUPERFRAME("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:links/rb-tg-radio-dn:configured/rb-tg-radio-dn:control-superframe"),
    RADIO_DN_LINKS("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:links"),
    RADIO_PROFILE_POLARITY("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:sectors-config/rb-tg-radio-dn:sector/rb-tg-radio-dn:radio-profile/rb-tg-radio-dn:polarity"),
    LINKS_CONFIGURED("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:links/rb-tg-radio-dn:configured"),
    DEFAULT_RADIO_PROFILE_POLARITY("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:node-config/rb-tg-radio-dn:default-radio-profile/rb-tg-radio-dn:polarity"),
    NODE_CONFIG_IS_POP_DN("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:node-config/rb-tg-radio-dn:is-pop-dn"),
    SECTORS_CONFIG_SECTOR("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:sectors-config/rb-tg-radio-dn:sector"),
    DEFAULT_RADIO_PROFILE_TX_GOLAY_INDEX("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:node-config/rb-tg-radio-dn:default-radio-profile/rb-tg-radio-dn:tx-golay-index");

    @Getter
    String rootTag;
    @Getter
    String prefix;
    @Getter 
    String ns;
    @Getter
    String xpath;
        
    private GetRadioDN(String rootTag, String prefix, String ns, String xpath) {
        this.rootTag = rootTag;
        this.prefix = prefix;
        this.ns = ns;
        this.xpath = xpath;
    }
}
