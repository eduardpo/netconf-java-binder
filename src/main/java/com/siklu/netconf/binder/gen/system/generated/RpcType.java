//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.07.20 at 05:10:47 PM IDT 
//


package com.siklu.netconf.binder.gen.system.generated;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Java class for rpcType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rpcType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:ietf:params:xml:ns:netconf:base:1.0}rpcOperation"/>
 *       &lt;/sequence>
 *       &lt;attribute name="message-id" use="required" type="{urn:ietf:params:xml:ns:netconf:base:1.0}messageIdType" />
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rpcType", propOrder = {
    "rpcOperation"
})
public class RpcType {

    @XmlElementRef(name = "rpcOperation", namespace = "urn:ietf:params:xml:ns:netconf:base:1.0", type = JAXBElement.class)
    protected JAXBElement<? extends RpcOperationType> rpcOperation;
    @XmlAttribute(name = "message-id", required = true)
    protected String messageId;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the rpcOperation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FactoryReset }{@code >}
     *     {@link JAXBElement }{@code <}{@link ActivateUpgradedSoftware }{@code >}
     *     {@link JAXBElement }{@code <}{@link RpcOperationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link SetSystemDate }{@code >}
     *     {@link JAXBElement }{@code <}{@link CancelActivateUpgradedSoftware }{@code >}
     *     {@link JAXBElement }{@code <}{@link DownloadAndFlashSoftwareUpgradeFile }{@code >}
     *     {@link JAXBElement }{@code <}{@link Reset }{@code >}
     *     {@link JAXBElement }{@code <}{@link SetSystemTime }{@code >}
     *     {@link JAXBElement }{@code <}{@link AcceptUpgradedSoftware }{@code >}
     *     
     */
    public JAXBElement<? extends RpcOperationType> getRpcOperation() {
        return rpcOperation;
    }

    /**
     * Sets the value of the rpcOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FactoryReset }{@code >}
     *     {@link JAXBElement }{@code <}{@link ActivateUpgradedSoftware }{@code >}
     *     {@link JAXBElement }{@code <}{@link RpcOperationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link SetSystemDate }{@code >}
     *     {@link JAXBElement }{@code <}{@link CancelActivateUpgradedSoftware }{@code >}
     *     {@link JAXBElement }{@code <}{@link DownloadAndFlashSoftwareUpgradeFile }{@code >}
     *     {@link JAXBElement }{@code <}{@link Reset }{@code >}
     *     {@link JAXBElement }{@code <}{@link SetSystemTime }{@code >}
     *     {@link JAXBElement }{@code <}{@link AcceptUpgradedSoftware }{@code >}
     *     
     */
    public void setRpcOperation(JAXBElement<? extends RpcOperationType> value) {
        this.rpcOperation = value;
    }

    /**
     * Gets the value of the messageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Sets the value of the messageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageId(String value) {
        this.messageId = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
