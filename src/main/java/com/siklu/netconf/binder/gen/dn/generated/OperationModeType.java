//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.06.02 at 08:39:13 PM IDT 
//


package com.siklu.netconf.binder.gen.dn.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for operation-mode-type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="operation-mode-type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BU"/>
 *     &lt;enumeration value="TU"/>
 *     &lt;enumeration value="P2P"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "operation-mode-type", namespace = "http://siklu.com/yang/tg/radio")
@XmlEnum
public enum OperationModeType {

    BU("BU"),
    TU("TU"),
    @XmlEnumValue("P2P")
    P_2_P("P2P");
    private final String value;

    OperationModeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OperationModeType fromValue(String v) {
        for (OperationModeType c: OperationModeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
