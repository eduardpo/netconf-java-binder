package com.siklu.netconf.binder.xpath;

import lombok.Getter;

public enum GetRadioCOMMON {

    RADIO_COMMON_LINKS("", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links"),
    SECTOR_ADMIN_STATUS("", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config/rb-tg-radio:sector/rb-tg-radio:admin-status"),
    AVAILABLE_OPERATION_MODE_OPERATION_MODE("", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:node-config/rb-tg-radio:available-operation-mode/rb-tg-radio:operation-mode"),
    STATE_MAC_ADDR("", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config/rb-tg-radio:sector/rb-tg-radio:state/rb-tg-radio:mac-addr"),
    RF_RF_TEMPERATURE("", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config/rb-tg-radio:sector/rb-tg-radio:state/rb-tg-radio:temperatures/rb-tg-radio:rf/rb-tg-radio:rf-temperature"),
    NODE_CONFIG_TX_POWER_CONTROL("", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:node-config/rb-tg-radio:tx-power-control"),
    SECTOR_INDEX("", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config/rb-tg-radio:sector/rb-tg-radio:index"),
    ACTIVE_COUNTERS("", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:counters"),
    COUNTERS_RX_DROP_UNEXPECTED("", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:counters/rb-tg-radio:rx-drop-unexpected"),
    RADIO_COMMON("radio-common", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common"),
    ACTIVE_SNR("radio-common", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:snr"),
    ACTIVE_REMOTE_MAC_ADDR("radio-common", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:remote-mac-addr"),
    RADIO_COMMON_SECTORS_CONFIG("radio-common", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config"),
    COUNTERS_TX_DROP_LIFETIME_EXP("radio-common", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:counters/rb-tg-radio:tx-drop-lifetime-exp"),
    RF_INDEX("radio-common", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config/rb-tg-radio:sector/rb-tg-radio:state/rb-tg-radio:temperatures/rb-tg-radio:rf/rb-tg-radio:index"),
    LINKS_ACTIVE("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active"),
    NODE_CONFIG_DEFAULT_SSID_PROFILE("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:node-config/rb-tg-radio:default-ssid-profile"),
    DEFAULT_SSID_PROFILE_PASSWORD("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:node-config/rb-tg-radio:default-ssid-profile/rb-tg-radio:password"),
    DEFAULT_SSID_PROFILE_SSID("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:node-config/rb-tg-radio:default-ssid-profile/rb-tg-radio:ssid"),
    ACTIVE_REMOTE_ASSIGNED_NAME("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:remote-assigned-name"),
    RPCS("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "rb-tg-radio:rpcs"),
    ACTIVE_ACTUAL_LOCAL_SECTOR_INDEX("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:actual-local-sector-index"),
    COUNTERS_TX_FAIL("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:counters/rb-tg-radio:tx-fail"),
    COUNTERS_RX_HCS_FAIL("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:counters/rb-tg-radio:rx-hcs-fail"),
    COUNTERS_RX_DROP_BUF_SIZE("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:counters/rb-tg-radio:rx-drop-buf-size"),
    NODE_CONFIG_AVAILABLE_OPERATION_MODE("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:node-config/rb-tg-radio:available-operation-mode"),
    ACTIVE_MCS_TX("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:mcs-tx"),
    ACTIVE_TX_POWER_INDEX("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:tx-power-index"),
    STATE_MODE("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config/rb-tg-radio:sector/rb-tg-radio:state/rb-tg-radio:mode"),
    COUNTERS_RX_FAIL("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:counters/rb-tg-radio:rx-fail"),
    NODE_CONFIG_LINK_DISTANCE("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:node-config/rb-tg-radio:link-distance"),
    ACTIVE_SPEED_RX("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:speed-rx"),
    COUNTERS_TX_OK("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:counters/rb-tg-radio:tx-ok"),
    COUNTERS_RX_DROP_RA_MISMATCH("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:counters/rb-tg-radio:rx-drop-ra-mismatch"),
    NODE_CONFIG_ENABLE_DYNAMIC_BANDWIDTH_ALLOCATION("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:node-config/rb-tg-radio:enable-dynamic-bandwidth-allocation"),
    ACTIVE_ACTUAL_REMOTE_SECTOR_INDEX("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:actual-remote-sector-index"),
    RADIO_COMMON_NODE_CONFIG("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:node-config"),
    TEMPERATURES_MODEM_TEMPERATURE("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config/rb-tg-radio:sector/rb-tg-radio:state/rb-tg-radio:temperatures/rb-tg-radio:modem-temperature"),
    ACTIVE_MCS_RX("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:mcs-rx"),
    ACTIVE_RX_PER("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:rx-per"),
    SECTOR_STATE("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config/rb-tg-radio:sector/rb-tg-radio:state"),
    SECTORS_CONFIG_SECTOR("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config/rb-tg-radio:sector"),
    ACTIVE_LOCAL_ROLE("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:local-role"),
    COUNTERS_RX_DROP_ENCRYPTION_FAIL("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:counters/rb-tg-radio:rx-drop-encryption-fail"),
    ACTIVE_RSSI("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:rssi"),
    COUNTERS_RX_OK("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:counters/rb-tg-radio:rx-ok"),
    STATE_TEMPERATURES("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config/rb-tg-radio:sector/rb-tg-radio:state/rb-tg-radio:temperatures"),
    ACTIVE_TX_PER("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:tx-per"),
    NODE_CONFIG_OPERATION_MODE("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:node-config/rb-tg-radio:operation-mode"),
    TEMPERATURES_RF("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config/rb-tg-radio:sector/rb-tg-radio:state/rb-tg-radio:temperatures/rb-tg-radio:rf"),
    ACTIVE_SPEED_TX("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:speed-tx"),
    SECTOR_ALIAS("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config/rb-tg-radio:sector/rb-tg-radio:alias");

    @Getter
    String rootTag;
    @Getter
    String prefix;
    @Getter 
    String ns;
    @Getter
    String xpath;
        
    private GetRadioCOMMON(String rootTag, String prefix, String ns, String xpath) {
        this.rootTag = rootTag;
        this.prefix = prefix;
        this.ns = ns;
        this.xpath = xpath;
    }
}
