//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.06.02 at 08:39:46 PM IDT 
//


package com.siklu.netconf.binder.gen.system.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for oper-status.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="oper-status">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="up"/>
 *     &lt;enumeration value="down"/>
 *     &lt;enumeration value="testing"/>
 *     &lt;enumeration value="unknown"/>
 *     &lt;enumeration value="dormant"/>
 *     &lt;enumeration value="not-present"/>
 *     &lt;enumeration value="lower-layer-down"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "oper-status", namespace = "http://siklu.com/yang/tg/types")
@XmlEnum
public enum OperStatus {

    @XmlEnumValue("up")
    UP("up"),
    @XmlEnumValue("down")
    DOWN("down"),
    @XmlEnumValue("testing")
    TESTING("testing"),
    @XmlEnumValue("unknown")
    UNKNOWN("unknown"),
    @XmlEnumValue("dormant")
    DORMANT("dormant"),
    @XmlEnumValue("not-present")
    NOT_PRESENT("not-present"),
    @XmlEnumValue("lower-layer-down")
    LOWER_LAYER_DOWN("lower-layer-down");
    private final String value;

    OperStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OperStatus fromValue(String v) {
        for (OperStatus c: OperStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
