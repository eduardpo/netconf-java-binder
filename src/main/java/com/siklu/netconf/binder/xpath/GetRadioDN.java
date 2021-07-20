package com.siklu.netconf.binder.xpath;

import lombok.Getter;

public enum GetRadioDN {

    DEFAULT_RADIO_PROFILE_POLARITY("", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:node-config/rb-tg-radio-dn:default-radio-profile/rb-tg-radio-dn:polarity"),
    RADIO_DN_SECTORS_CONFIG("", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:sectors-config"),
    LINKS_CONFIGURED("", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:links/rb-tg-radio-dn:configured"),
    NODE_CONFIG_IS_POP_DN("", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:node-config/rb-tg-radio-dn:is-pop-dn"),
    CONFIGURED_RESPONDER_NODE_TYPE("", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:links/rb-tg-radio-dn:configured/rb-tg-radio-dn:responder-node-type"),
    RADIO_DN("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn"),
    DEFAULT_RADIO_PROFILE_TX_GOLAY_INDEX("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:node-config/rb-tg-radio-dn:default-radio-profile/rb-tg-radio-dn:tx-golay-index"),
    CONFIGURED_REMOTE_ASSIGNED_NAME("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:links/rb-tg-radio-dn:configured/rb-tg-radio-dn:remote-assigned-name"),
    CONFIGURED_REMOTE_SECTOR("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:links/rb-tg-radio-dn:configured/rb-tg-radio-dn:remote-sector"),
    CONFIGURED_LOCAL_SECTOR("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:links/rb-tg-radio-dn:configured/rb-tg-radio-dn:local-sector"),
    SECTOR_INDEX("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:sectors-config/rb-tg-radio-dn:sector/rb-tg-radio-dn:index"),
    SECTOR_RADIO_PROFILE("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:sectors-config/rb-tg-radio-dn:sector/rb-tg-radio-dn:radio-profile"),
    REMOTE_SECTOR_INDEX("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:links/rb-tg-radio-dn:configured/rb-tg-radio-dn:remote-sector/rb-tg-radio-dn:index"),
    CONFIGURED_TX_POWER_CONTROL("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:links/rb-tg-radio-dn:configured/rb-tg-radio-dn:tx-power-control"),
    DEFAULT_RADIO_PROFILE_RX_GOLAY_INDEX("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:node-config/rb-tg-radio-dn:default-radio-profile/rb-tg-radio-dn:rx-golay-index"),
    CONFIGURED_CONTROL_SUPERFRAME("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:links/rb-tg-radio-dn:configured/rb-tg-radio-dn:control-superframe"),
    CONFIGURED_ADMIN_STATUS("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:links/rb-tg-radio-dn:configured/rb-tg-radio-dn:admin-status"),
    RADIO_PROFILE_TX_GOLAY_INDEX("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:sectors-config/rb-tg-radio-dn:sector/rb-tg-radio-dn:radio-profile/rb-tg-radio-dn:tx-golay-index"),
    RADIO_DN_NODE_CONFIG("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:node-config"),
    NODE_CONFIG_DEFAULT_RADIO_PROFILE("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:node-config/rb-tg-radio-dn:default-radio-profile"),
    SECTORS_CONFIG_SECTOR("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:sectors-config/rb-tg-radio-dn:sector"),
    NODE_CONFIG_IGNORE_GPS("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:node-config/rb-tg-radio-dn:ignore-gps"),
    DEFAULT_RADIO_PROFILE_FREQUENCY("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:node-config/rb-tg-radio-dn:default-radio-profile/rb-tg-radio-dn:frequency"),
    RADIO_PROFILE_FREQUENCY("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:sectors-config/rb-tg-radio-dn:sector/rb-tg-radio-dn:radio-profile/rb-tg-radio-dn:frequency"),
    RADIO_DN_LINKS("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:links"),
    LOCAL_SECTOR_INDEX("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:links/rb-tg-radio-dn:configured/rb-tg-radio-dn:local-sector/rb-tg-radio-dn:index"),
    RADIO_PROFILE_RX_GOLAY_INDEX("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:sectors-config/rb-tg-radio-dn:sector/rb-tg-radio-dn:radio-profile/rb-tg-radio-dn:rx-golay-index"),
    RADIO_PROFILE_POLARITY("radio-dn", "xmlns:rb-tg-radio-dn", "http://siklu.com/yang/tg/radio/dn", "/rb-tg-radio-dn:radio-dn/rb-tg-radio-dn:sectors-config/rb-tg-radio-dn:sector/rb-tg-radio-dn:radio-profile/rb-tg-radio-dn:polarity");

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
