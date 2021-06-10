//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.06.02 at 08:38:40 PM IDT 
//


package com.siklu.netconf.binder.gen.common.generated;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * <p>Java class for errorInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="errorInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="session-id" type="{urn:ietf:params:xml:ns:netconf:base:1.0}SessionIdOrZero"/>
 *           &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *             &lt;sequence>
 *               &lt;element name="bad-attribute" type="{http://www.w3.org/2001/XMLSchema}QName" minOccurs="0"/>
 *               &lt;element name="bad-element" type="{http://www.w3.org/2001/XMLSchema}QName" minOccurs="0"/>
 *               &lt;element name="ok-element" type="{http://www.w3.org/2001/XMLSchema}QName" minOccurs="0"/>
 *               &lt;element name="err-element" type="{http://www.w3.org/2001/XMLSchema}QName" minOccurs="0"/>
 *               &lt;element name="noop-element" type="{http://www.w3.org/2001/XMLSchema}QName" minOccurs="0"/>
 *               &lt;element name="bad-namespace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *             &lt;/sequence>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "errorInfoType", propOrder = {
    "sessionId",
    "badAttributeAndBadElementAndOkElement",
    "any"
})
public class ErrorInfoType {

    @XmlElement(name = "session-id")
    @XmlSchemaType(name = "unsignedInt")
    protected Long sessionId;
    @XmlElementRefs({
        @XmlElementRef(name = "noop-element", namespace = "urn:ietf:params:xml:ns:netconf:base:1.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bad-element", namespace = "urn:ietf:params:xml:ns:netconf:base:1.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ok-element", namespace = "urn:ietf:params:xml:ns:netconf:base:1.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bad-namespace", namespace = "urn:ietf:params:xml:ns:netconf:base:1.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "bad-attribute", namespace = "urn:ietf:params:xml:ns:netconf:base:1.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "err-element", namespace = "urn:ietf:params:xml:ns:netconf:base:1.0", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<? extends Serializable>> badAttributeAndBadElementAndOkElement;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the sessionId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSessionId() {
        return sessionId;
    }

    /**
     * Sets the value of the sessionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSessionId(Long value) {
        this.sessionId = value;
    }

    /**
     * Gets the value of the badAttributeAndBadElementAndOkElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the badAttributeAndBadElementAndOkElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBadAttributeAndBadElementAndOkElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link QName }{@code >}
     * {@link JAXBElement }{@code <}{@link QName }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link QName }{@code >}
     * {@link JAXBElement }{@code <}{@link QName }{@code >}
     * {@link JAXBElement }{@code <}{@link QName }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends Serializable>> getBadAttributeAndBadElementAndOkElement() {
        if (badAttributeAndBadElementAndOkElement == null) {
            badAttributeAndBadElementAndOkElement = new ArrayList<JAXBElement<? extends Serializable>>();
        }
        return this.badAttributeAndBadElementAndOkElement;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

}
