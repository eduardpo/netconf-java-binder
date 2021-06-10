//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.06.02 at 08:39:13 PM IDT 
//


package com.siklu.netconf.binder.gen.dn.generated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Java class for rpcReplyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rpcReplyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="ok" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;sequence>
 *           &lt;element ref="{urn:ietf:params:xml:ns:netconf:base:1.0}rpc-error" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element ref="{urn:ietf:params:xml:ns:netconf:base:1.0}rpcResponse" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *       &lt;attribute name="message-id" type="{urn:ietf:params:xml:ns:netconf:base:1.0}messageIdType" />
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rpcReplyType", propOrder = {
    "ok",
    "rpcError",
    "rpcResponse"
})
public class RpcReplyType {

    protected Object ok;
    @XmlElement(name = "rpc-error")
    protected List<RpcErrorType> rpcError;
    protected List<RpcResponseType> rpcResponse;
    @XmlAttribute(name = "message-id")
    protected String messageId;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the ok property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getOk() {
        return ok;
    }

    /**
     * Sets the value of the ok property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setOk(Object value) {
        this.ok = value;
    }

    /**
     * Gets the value of the rpcError property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rpcError property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRpcError().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RpcErrorType }
     * 
     * 
     */
    public List<RpcErrorType> getRpcError() {
        if (rpcError == null) {
            rpcError = new ArrayList<RpcErrorType>();
        }
        return this.rpcError;
    }

    /**
     * Gets the value of the rpcResponse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rpcResponse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRpcResponse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RpcResponseType }
     * 
     * 
     */
    public List<RpcResponseType> getRpcResponse() {
        if (rpcResponse == null) {
            rpcResponse = new ArrayList<RpcResponseType>();
        }
        return this.rpcResponse;
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
