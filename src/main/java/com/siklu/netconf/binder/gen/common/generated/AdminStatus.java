//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.07.20 at 05:09:41 PM IDT 
//


package com.siklu.netconf.binder.gen.common.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for admin-status.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="admin-status">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="up"/>
 *     &lt;enumeration value="down"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "admin-status", namespace = "http://siklu.com/yang/tg/types")
@XmlEnum
public enum AdminStatus {

    @XmlEnumValue("up")
    UP("up"),
    @XmlEnumValue("down")
    DOWN("down");
    private final String value;

    AdminStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AdminStatus fromValue(String v) {
        for (AdminStatus c: AdminStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
