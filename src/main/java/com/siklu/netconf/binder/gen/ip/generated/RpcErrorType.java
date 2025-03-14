//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.07.20 at 05:09:08 PM IDT 
//


package com.siklu.netconf.binder.gen.ip.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for rpcErrorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rpcErrorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="error-type" type="{urn:ietf:params:xml:ns:netconf:base:1.0}ErrorType"/>
 *         &lt;element name="error-tag" type="{urn:ietf:params:xml:ns:netconf:base:1.0}ErrorTag"/>
 *         &lt;element name="error-severity" type="{urn:ietf:params:xml:ns:netconf:base:1.0}ErrorSeverity"/>
 *         &lt;element name="error-app-tag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="error-path" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="error-message" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/>
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="error-info" type="{urn:ietf:params:xml:ns:netconf:base:1.0}errorInfoType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rpcErrorType", propOrder = {
    "errorType",
    "errorTag",
    "errorSeverity",
    "errorAppTag",
    "errorPath",
    "errorMessage",
    "errorInfo"
})
public class RpcErrorType {

    @XmlElement(name = "error-type", required = true)
    @XmlSchemaType(name = "string")
    protected ErrorType errorType;
    @XmlElement(name = "error-tag", required = true)
    @XmlSchemaType(name = "string")
    protected ErrorTag errorTag;
    @XmlElement(name = "error-severity", required = true)
    @XmlSchemaType(name = "string")
    protected ErrorSeverity errorSeverity;
    @XmlElement(name = "error-app-tag")
    protected String errorAppTag;
    @XmlElement(name = "error-path")
    protected String errorPath;
    @XmlElement(name = "error-message")
    protected RpcErrorType.ErrorMessage errorMessage;
    @XmlElement(name = "error-info")
    protected ErrorInfoType errorInfo;

    /**
     * Gets the value of the errorType property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorType }
     *     
     */
    public ErrorType getErrorType() {
        return errorType;
    }

    /**
     * Sets the value of the errorType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorType }
     *     
     */
    public void setErrorType(ErrorType value) {
        this.errorType = value;
    }

    /**
     * Gets the value of the errorTag property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorTag }
     *     
     */
    public ErrorTag getErrorTag() {
        return errorTag;
    }

    /**
     * Sets the value of the errorTag property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorTag }
     *     
     */
    public void setErrorTag(ErrorTag value) {
        this.errorTag = value;
    }

    /**
     * Gets the value of the errorSeverity property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorSeverity }
     *     
     */
    public ErrorSeverity getErrorSeverity() {
        return errorSeverity;
    }

    /**
     * Sets the value of the errorSeverity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorSeverity }
     *     
     */
    public void setErrorSeverity(ErrorSeverity value) {
        this.errorSeverity = value;
    }

    /**
     * Gets the value of the errorAppTag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorAppTag() {
        return errorAppTag;
    }

    /**
     * Sets the value of the errorAppTag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorAppTag(String value) {
        this.errorAppTag = value;
    }

    /**
     * Gets the value of the errorPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorPath() {
        return errorPath;
    }

    /**
     * Sets the value of the errorPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorPath(String value) {
        this.errorPath = value;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link RpcErrorType.ErrorMessage }
     *     
     */
    public RpcErrorType.ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link RpcErrorType.ErrorMessage }
     *     
     */
    public void setErrorMessage(RpcErrorType.ErrorMessage value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the errorInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorInfoType }
     *     
     */
    public ErrorInfoType getErrorInfo() {
        return errorInfo;
    }

    /**
     * Sets the value of the errorInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorInfoType }
     *     
     */
    public void setErrorInfo(ErrorInfoType value) {
        this.errorInfo = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/>
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class ErrorMessage {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace")
        protected String lang;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the lang property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLang() {
            return lang;
        }

        /**
         * Sets the value of the lang property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLang(String value) {
            this.lang = value;
        }

    }

}
