package com.siklu.netconf.binder.xpath;

import lombok.Getter;

public enum GetRadioCOMMON {

    COUNTERS_RX_OK("", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:counters/rb-tg-radio:rx-ok"),
    COUNTERS_RX_DROP_UNEXPECTED("", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:counters/rb-tg-radio:rx-drop-unexpected"),
    COUNTERS_RX_FAIL("", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:counters/rb-tg-radio:rx-fail"),
    AVAILABLE_OPERATION_MODE_OPERATION_MODE("", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:node-config/rb-tg-radio:available-operation-mode/rb-tg-radio:operation-mode"),
    RADIO_COMMON_NODE_CONFIG("", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:node-config"),
    RADIO_COMMON_LINKS("", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links"),
    ACTIVE_TX_POWER_INDEX("", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:tx-power-index"),
    ACTIVE_REMOTE_ASSIGNED_NAME("", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:remote-assigned-name"),
    RF_INDEX("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config/rb-tg-radio:sector/rb-tg-radio:state/rb-tg-radio:temperatures/rb-tg-radio:rf/rb-tg-radio:index"),
    NODE_CONFIG_DEFAULT_SSID_PROFILE("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:node-config/rb-tg-radio:default-ssid-profile"),
    NODE_CONFIG_AVAILABLE_OPERATION_MODE("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:node-config/rb-tg-radio:available-operation-mode"),
    ACTIVE_TX_PER("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:tx-per"),
    DEFAULT_SSID_PROFILE_SSID("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:node-config/rb-tg-radio:default-ssid-profile/rb-tg-radio:ssid"),
    RADIO_COMMON_SECTORS_CONFIG("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config"),
    SECTOR_ADMIN_STATUS("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config/rb-tg-radio:sector/rb-tg-radio:admin-status"),
    COUNTERS_TX_OK("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:counters/rb-tg-radio:tx-ok"),
    COUNTERS_TX_DROP_LIFETIME_EXP("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:counters/rb-tg-radio:tx-drop-lifetime-exp"),
    ACTIVE_SNR("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:snr"),
    COUNTERS_RX_DROP_RA_MISMATCH("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:counters/rb-tg-radio:rx-drop-ra-mismatch"),
    RF_RF_TEMPERATURE("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config/rb-tg-radio:sector/rb-tg-radio:state/rb-tg-radio:temperatures/rb-tg-radio:rf/rb-tg-radio:rf-temperature"),
    ACTIVE_COUNTERS("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:counters"),
    DEFAULT_SSID_PROFILE_PASSWORD("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:node-config/rb-tg-radio:default-ssid-profile/rb-tg-radio:password"),
    ACTIVE_SPEED_RX("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:speed-rx"),
    ACTIVE_ACTUAL_REMOTE_SECTOR_INDEX("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:actual-remote-sector-index"),
    STATE_MAC_ADDR("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config/rb-tg-radio:sector/rb-tg-radio:state/rb-tg-radio:mac-addr"),
    TEMPERATURES_RF("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config/rb-tg-radio:sector/rb-tg-radio:state/rb-tg-radio:temperatures/rb-tg-radio:rf"),
    ACTIVE_LOCAL_ROLE("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:local-role"),
    NODE_CONFIG_OPERATION_MODE("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:node-config/rb-tg-radio:operation-mode"),
    STATE_MODE("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config/rb-tg-radio:sector/rb-tg-radio:state/rb-tg-radio:mode"),
    ACTIVE_RSSI("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:rssi"),
    COUNTERS_RX_DROP_ENCRYPTION_FAIL("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:counters/rb-tg-radio:rx-drop-encryption-fail"),
    COUNTERS_RX_HCS_FAIL("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:counters/rb-tg-radio:rx-hcs-fail"),
    STATE_TEMPERATURES("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config/rb-tg-radio:sector/rb-tg-radio:state/rb-tg-radio:temperatures"),
    SECTOR_STATE("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config/rb-tg-radio:sector/rb-tg-radio:state"),
    ACTIVE_MCS_TX("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:mcs-tx"),
    COUNTERS_RX_DROP_BUF_SIZE("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:counters/rb-tg-radio:rx-drop-buf-size"),
    NODE_CONFIG_ENABLE_DYNAMIC_BANDWIDTH_ALLOCATION("clear-all-fw-counters", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:node-config/rb-tg-radio:enable-dynamic-bandwidth-allocation"),
    RADIO_COMMON("radio-common", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common"),
    LINKS_ACTIVE("radio-common", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active"),
    ACTIVE_REMOTE_MAC_ADDR("radio-common", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:remote-mac-addr"),
    RPCS("radio-common", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "rb-tg-radio:rpcs"),
    ACTIVE_SPEED_TX("radio-common", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:speed-tx"),
    ACTIVE_MCS_RX("radio-common", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:mcs-rx"),
    COUNTERS_TX_FAIL("radio-common", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:counters/rb-tg-radio:tx-fail"),
    SECTOR_INDEX("radio-common", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config/rb-tg-radio:sector/rb-tg-radio:index"),
    ACTIVE_ACTUAL_LOCAL_SECTOR_INDEX("radio-common", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:actual-local-sector-index"),
    SECTORS_CONFIG_SECTOR("radio-common", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config/rb-tg-radio:sector"),
    ACTIVE_RX_PER("radio-common", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:links/rb-tg-radio:active/rb-tg-radio:rx-per"),
    TEMPERATURES_MODEM_TEMPERATURE("radio-common", "xmlns:rb-tg-radio", "http://siklu.com/yang/tg/radio", "/rb-tg-radio:radio-common/rb-tg-radio:sectors-config/rb-tg-radio:sector/rb-tg-radio:state/rb-tg-radio:temperatures/rb-tg-radio:modem-temperature");

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
