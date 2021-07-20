package com.siklu.netconf.binder.xpath;

import lombok.Getter;

public enum GetTgSYSTEM {

    BANKS_SOFTWARE_VERSION("", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:banks-info/rb-tg-sys:banks/rb-tg-sys:software-version"),
    GPS_FIX_MODE("", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:gps/rb-tg-sys:fix-mode"),
    SYSTEM_REBOOT_NEEDED("", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:reboot-needed"),
    RPCS("", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "rb-tg-sys:rpcs"),
    STATE_DATE_AND_TIME("", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:date-and-time"),
    SYSTEM_STATE("", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state"),
    SET_SYSTEM_DATE("set-system-date", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:set-system-date"),
    BANKS_STATUS("set-system-date", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:banks-info/rb-tg-sys:banks/rb-tg-sys:status"),
    STATE_GPS("set-system-date", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:gps"),
    SET_SYSTEM_DATE_DATE("set-system-date", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:set-system-date/rb-tg-sys:date"),
    RESET("reset", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:reset"),
    SET_SYSTEM_TIME("set-system-time", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:set-system-time"),
    BANKS_ACCEPT_COUNTDOWN("set-system-time", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:banks-info/rb-tg-sys:banks/rb-tg-sys:accept-countdown"),
    STATE_SW_UPGRADE_INFO("set-system-time", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:sw-upgrade-info"),
    GPS_FIX_SATELLITES_NUMBER("set-system-time", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:gps/rb-tg-sys:fix-satellites-number"),
    STATE_UPTIME("set-system-time", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:uptime"),
    FACTORY_RESET("factory-reset", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:factory-reset"),
    SYSTEM_LOCATION("factory-reset", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:location"),
    SYSTEM_NAME("factory-reset", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:name"),
    BANKS_SCHEDULED_ACCEPT_TIMEOUT("factory-reset", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:banks-info/rb-tg-sys:banks/rb-tg-sys:scheduled-accept-timeout"),
    BANKS_INFO_BANKS("factory-reset", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:banks-info/rb-tg-sys:banks"),
    SW_UPGRADE_INFO_DOWNLOAD_FILE_ERROR("factory-reset", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:sw-upgrade-info/rb-tg-sys:download-file-error"),
    STATE_PRODUCT("factory-reset", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:product"),
    SW_UPGRADE_INFO_URL("factory-reset", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:sw-upgrade-info/rb-tg-sys:url"),
    BANKS_SCHEDULED_TO_SWITCH("factory-reset", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:banks-info/rb-tg-sys:banks/rb-tg-sys:scheduled-to-switch"),
    SET_SYSTEM_TIME_TIME("factory-reset", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:set-system-time/rb-tg-sys:time"),
    SW_UPGRADE_INFO_DOWNLOAD_FILE_PROGRESS("factory-reset", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:sw-upgrade-info/rb-tg-sys:download-file-progress"),
    SW_UPGRADE_INFO_DOWNLOAD_AND_BURNING_STATE("factory-reset", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:sw-upgrade-info/rb-tg-sys:download-and-burning-state"),
    BANKS_NUMBER("factory-reset", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:banks-info/rb-tg-sys:banks/rb-tg-sys:number"),
    SYSTEM("system", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system"),
    STATE_BANKS_INFO("system", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:banks-info");

    @Getter
    String rootTag;
    @Getter
    String prefix;
    @Getter 
    String ns;
    @Getter
    String xpath;
        
    private GetTgSYSTEM(String rootTag, String prefix, String ns, String xpath) {
        this.rootTag = rootTag;
        this.prefix = prefix;
        this.ns = ns;
        this.xpath = xpath;
    }
}
