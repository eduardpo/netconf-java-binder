//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.07.20 at 05:10:14 PM IDT 
//


package com.siklu.netconf.binder.gen.dn.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for link-role.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="link-role">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="initiator"/>
 *     &lt;enumeration value="responder"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "link-role", namespace = "http://siklu.com/yang/tg/radio")
@XmlEnum
public enum LinkRole {

    @XmlEnumValue("initiator")
    INITIATOR("initiator"),
    @XmlEnumValue("responder")
    RESPONDER("responder");
    private final String value;

    LinkRole(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LinkRole fromValue(String v) {
        for (LinkRole c: LinkRole.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
