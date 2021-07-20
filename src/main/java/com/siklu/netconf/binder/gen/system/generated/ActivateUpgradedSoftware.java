//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.07.20 at 05:10:47 PM IDT 
//


package com.siklu.netconf.binder.gen.system.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{urn:ietf:params:xml:ns:netconf:base:1.0}rpcOperationType">
 *       &lt;sequence>
 *         &lt;element name="scheduling" type="{http://siklu.com/yang/tg/software-upgrade}scheduling-type" minOccurs="0"/>
 *         &lt;element name="scheduling-date" type="{http://siklu.com/yang/tg/types}date" minOccurs="0"/>
 *         &lt;element name="scheduling-time" type="{http://siklu.com/yang/tg/types}time" minOccurs="0"/>
 *         &lt;element name="accept-timeout" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "scheduling",
    "schedulingDate",
    "schedulingTime",
    "acceptTimeout",
    "any"
})
public class ActivateUpgradedSoftware
    extends RpcOperationType
{

    @XmlElement(namespace = "http://siklu.com/yang/tg/software-upgrade")
    @XmlSchemaType(name = "string")
    protected SchedulingType scheduling;
    @XmlElement(name = "scheduling-date", namespace = "http://siklu.com/yang/tg/software-upgrade")
    protected String schedulingDate;
    @XmlElement(name = "scheduling-time", namespace = "http://siklu.com/yang/tg/software-upgrade")
    protected String schedulingTime;
    @XmlElement(name = "accept-timeout", namespace = "http://siklu.com/yang/tg/software-upgrade")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer acceptTimeout;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the scheduling property.
     * 
     * @return
     *     possible object is
     *     {@link SchedulingType }
     *     
     */
    public SchedulingType getScheduling() {
        return scheduling;
    }

    /**
     * Sets the value of the scheduling property.
     * 
     * @param value
     *     allowed object is
     *     {@link SchedulingType }
     *     
     */
    public void setScheduling(SchedulingType value) {
        this.scheduling = value;
    }

    /**
     * Gets the value of the schedulingDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchedulingDate() {
        return schedulingDate;
    }

    /**
     * Sets the value of the schedulingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchedulingDate(String value) {
        this.schedulingDate = value;
    }

    /**
     * Gets the value of the schedulingTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchedulingTime() {
        return schedulingTime;
    }

    /**
     * Sets the value of the schedulingTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchedulingTime(String value) {
        this.schedulingTime = value;
    }

    /**
     * Gets the value of the acceptTimeout property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAcceptTimeout() {
        return acceptTimeout;
    }

    /**
     * Sets the value of the acceptTimeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAcceptTimeout(Integer value) {
        this.acceptTimeout = value;
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
