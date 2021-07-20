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
 * <p>Java class for polarity-type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="polarity-type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="unspecified"/>
 *     &lt;enumeration value="even"/>
 *     &lt;enumeration value="hybrid-even"/>
 *     &lt;enumeration value="odd"/>
 *     &lt;enumeration value="hybrid-odd"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "polarity-type", namespace = "http://siklu.com/yang/tg/radio")
@XmlEnum
public enum PolarityType {

    @XmlEnumValue("unspecified")
    UNSPECIFIED("unspecified"),
    @XmlEnumValue("even")
    EVEN("even"),
    @XmlEnumValue("hybrid-even")
    HYBRID_EVEN("hybrid-even"),
    @XmlEnumValue("odd")
    ODD("odd"),
    @XmlEnumValue("hybrid-odd")
    HYBRID_ODD("hybrid-odd");
    private final String value;

    PolarityType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PolarityType fromValue(String v) {
        for (PolarityType c: PolarityType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
