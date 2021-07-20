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
 * <p>Java class for link-distances-type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="link-distances-type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Normal"/>
 *     &lt;enumeration value="Long"/>
 *     &lt;enumeration value="Extra-long"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "link-distances-type", namespace = "http://siklu.com/yang/tg/radio")
@XmlEnum
public enum LinkDistancesType {

    @XmlEnumValue("Normal")
    NORMAL("Normal"),
    @XmlEnumValue("Long")
    LONG("Long"),
    @XmlEnumValue("Extra-long")
    EXTRA_LONG("Extra-long");
    private final String value;

    LinkDistancesType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LinkDistancesType fromValue(String v) {
        for (LinkDistancesType c: LinkDistancesType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
