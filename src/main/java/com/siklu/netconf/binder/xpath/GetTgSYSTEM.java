package com.siklu.netconf.binder.xpath;

import lombok.Getter;

public enum GetTgSYSTEM {

    FACTORY_RESET("factory-reset", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:factory-reset"),
    RPCS("factory-reset", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "rb-tg-sys:rpcs"),
    SYSTEM("system", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system"),
    STATE_UPTIME("system", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:uptime"),
    SW_UPGRADE_INFO_DOWNLOAD_FILE_PROGRESS("system", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:sw-upgrade-info/rb-tg-sys:download-file-progress"),
    STATE_DATE_AND_TIME("system", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:date-and-time"),
    SW_UPGRADE_INFO_URL("system", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:sw-upgrade-info/rb-tg-sys:url"),
    BANKS_STATUS("system", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:banks-info/rb-tg-sys:banks/rb-tg-sys:status"),
    SW_UPGRADE_INFO_DOWNLOAD_FILE_ERROR("system", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:sw-upgrade-info/rb-tg-sys:download-file-error"),
    STATE_SW_UPGRADE_INFO("system", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:sw-upgrade-info"),
    STATE_GPS("system", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:gps"),
    SYSTEM_NAME("system", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:name"),
    STATE_PRODUCT("system", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:product"),
    BANKS_INFO_BANKS("system", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:banks-info/rb-tg-sys:banks"),
    SET_SYSTEM_TIME_TIME("system", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:set-system-time/rb-tg-sys:time"),
    BANKS_SOFTWARE_VERSION("system", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:banks-info/rb-tg-sys:banks/rb-tg-sys:software-version"),
    GPS_FIX_SATELLITES_NUMBER("system", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:gps/rb-tg-sys:fix-satellites-number"),
    BANKS_NUMBER("system", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:banks-info/rb-tg-sys:banks/rb-tg-sys:number"),
    STATE_BANKS_INFO("system", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:banks-info"),
    BANKS_SCHEDULED_TO_SWITCH("system", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:banks-info/rb-tg-sys:banks/rb-tg-sys:scheduled-to-switch"),
    SET_SYSTEM_DATE("set-system-date", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:set-system-date"),
    RESET("reset", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:reset"),
    SYSTEM_STATE("reset", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state"),
    SET_SYSTEM_DATE_DATE("reset", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:set-system-date/rb-tg-sys:date"),
    SET_SYSTEM_TIME("set-system-time", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:set-system-time"),
    SW_UPGRADE_INFO_DOWNLOAD_AND_BURNING_STATE("set-system-time", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:sw-upgrade-info/rb-tg-sys:download-and-burning-state"),
    GPS_FIX_MODE("set-system-time", "xmlns:rb-tg-sys", "http://siklu.com/yang/tg/system", "/rb-tg-sys:system/rb-tg-sys:state/rb-tg-sys:gps/rb-tg-sys:fix-mode");

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
