//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.07.20 at 05:09:41 PM IDT 
//


package com.siklu.netconf.binder.gen.common.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Rpc_QNAME = new QName("urn:ietf:params:xml:ns:netconf:base:1.0", "rpc");
    private final static QName _RpcReply_QNAME = new QName("urn:ietf:params:xml:ns:netconf:base:1.0", "rpc-reply");
    private final static QName _RpcError_QNAME = new QName("urn:ietf:params:xml:ns:netconf:base:1.0", "rpc-error");
    private final static QName _RpcResponse_QNAME = new QName("urn:ietf:params:xml:ns:netconf:base:1.0", "rpcResponse");
    private final static QName _RpcOperation_QNAME = new QName("urn:ietf:params:xml:ns:netconf:base:1.0", "rpcOperation");
    private final static QName _ClearAllFwCounters_QNAME = new QName("http://siklu.com/yang/tg/radio", "clear-all-fw-counters");
    private final static QName _ErrorInfoTypeErrElement_QNAME = new QName("urn:ietf:params:xml:ns:netconf:base:1.0", "err-element");
    private final static QName _ErrorInfoTypeBadElement_QNAME = new QName("urn:ietf:params:xml:ns:netconf:base:1.0", "bad-element");
    private final static QName _ErrorInfoTypeOkElement_QNAME = new QName("urn:ietf:params:xml:ns:netconf:base:1.0", "ok-element");
    private final static QName _ErrorInfoTypeNoopElement_QNAME = new QName("urn:ietf:params:xml:ns:netconf:base:1.0", "noop-element");
    private final static QName _ErrorInfoTypeBadNamespace_QNAME = new QName("urn:ietf:params:xml:ns:netconf:base:1.0", "bad-namespace");
    private final static QName _ErrorInfoTypeBadAttribute_QNAME = new QName("urn:ietf:params:xml:ns:netconf:base:1.0", "bad-attribute");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RadioCommon }
     * 
     */
    public RadioCommon createRadioCommon() {
        return new RadioCommon();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link RpcErrorType }
     * 
     */
    public RpcErrorType createRpcErrorType() {
        return new RpcErrorType();
    }

    /**
     * Create an instance of {@link RadioCommon.Links }
     * 
     */
    public RadioCommon.Links createRadioCommonLinks() {
        return new RadioCommon.Links();
    }

    /**
     * Create an instance of {@link RadioCommon.Links.Active }
     * 
     */
    public RadioCommon.Links.Active createRadioCommonLinksActive() {
        return new RadioCommon.Links.Active();
    }

    /**
     * Create an instance of {@link RadioCommon.SectorsConfig }
     * 
     */
    public RadioCommon.SectorsConfig createRadioCommonSectorsConfig() {
        return new RadioCommon.SectorsConfig();
    }

    /**
     * Create an instance of {@link RadioCommon.SectorsConfig.Sector }
     * 
     */
    public RadioCommon.SectorsConfig.Sector createRadioCommonSectorsConfigSector() {
        return new RadioCommon.SectorsConfig.Sector();
    }

    /**
     * Create an instance of {@link RadioCommon.SectorsConfig.Sector.State }
     * 
     */
    public RadioCommon.SectorsConfig.Sector.State createRadioCommonSectorsConfigSectorState() {
        return new RadioCommon.SectorsConfig.Sector.State();
    }

    /**
     * Create an instance of {@link RadioCommon.SectorsConfig.Sector.State.Temperatures }
     * 
     */
    public RadioCommon.SectorsConfig.Sector.State.Temperatures createRadioCommonSectorsConfigSectorStateTemperatures() {
        return new RadioCommon.SectorsConfig.Sector.State.Temperatures();
    }

    /**
     * Create an instance of {@link RadioCommon.NodeConfig }
     * 
     */
    public RadioCommon.NodeConfig createRadioCommonNodeConfig() {
        return new RadioCommon.NodeConfig();
    }

    /**
     * Create an instance of {@link ClearAllFwCounters }
     * 
     */
    public ClearAllFwCounters createClearAllFwCounters() {
        return new ClearAllFwCounters();
    }

    /**
     * Create an instance of {@link RpcOperationType }
     * 
     */
    public RpcOperationType createRpcOperationType() {
        return new RpcOperationType();
    }

    /**
     * Create an instance of {@link RpcType }
     * 
     */
    public RpcType createRpcType() {
        return new RpcType();
    }

    /**
     * Create an instance of {@link RpcReplyType }
     * 
     */
    public RpcReplyType createRpcReplyType() {
        return new RpcReplyType();
    }

    /**
     * Create an instance of {@link RpcResponseType }
     * 
     */
    public RpcResponseType createRpcResponseType() {
        return new RpcResponseType();
    }

    /**
     * Create an instance of {@link Hello.Capabilities }
     * 
     */
    public Hello.Capabilities createHelloCapabilities() {
        return new Hello.Capabilities();
    }

    /**
     * Create an instance of {@link ErrorInfoType }
     * 
     */
    public ErrorInfoType createErrorInfoType() {
        return new ErrorInfoType();
    }

    /**
     * Create an instance of {@link RpcErrorType.ErrorMessage }
     * 
     */
    public RpcErrorType.ErrorMessage createRpcErrorTypeErrorMessage() {
        return new RpcErrorType.ErrorMessage();
    }

    /**
     * Create an instance of {@link RadioCommon.Links.Active.Counters }
     * 
     */
    public RadioCommon.Links.Active.Counters createRadioCommonLinksActiveCounters() {
        return new RadioCommon.Links.Active.Counters();
    }

    /**
     * Create an instance of {@link RadioCommon.SectorsConfig.Sector.State.Temperatures.Rf }
     * 
     */
    public RadioCommon.SectorsConfig.Sector.State.Temperatures.Rf createRadioCommonSectorsConfigSectorStateTemperaturesRf() {
        return new RadioCommon.SectorsConfig.Sector.State.Temperatures.Rf();
    }

    /**
     * Create an instance of {@link RadioCommon.NodeConfig.DefaultSsidProfile }
     * 
     */
    public RadioCommon.NodeConfig.DefaultSsidProfile createRadioCommonNodeConfigDefaultSsidProfile() {
        return new RadioCommon.NodeConfig.DefaultSsidProfile();
    }

    /**
     * Create an instance of {@link RadioCommon.NodeConfig.AvailableOperationMode }
     * 
     */
    public RadioCommon.NodeConfig.AvailableOperationMode createRadioCommonNodeConfigAvailableOperationMode() {
        return new RadioCommon.NodeConfig.AvailableOperationMode();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RpcType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:netconf:base:1.0", name = "rpc")
    public JAXBElement<RpcType> createRpc(RpcType value) {
        return new JAXBElement<RpcType>(_Rpc_QNAME, RpcType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RpcReplyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:netconf:base:1.0", name = "rpc-reply")
    public JAXBElement<RpcReplyType> createRpcReply(RpcReplyType value) {
        return new JAXBElement<RpcReplyType>(_RpcReply_QNAME, RpcReplyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RpcErrorType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:netconf:base:1.0", name = "rpc-error")
    public JAXBElement<RpcErrorType> createRpcError(RpcErrorType value) {
        return new JAXBElement<RpcErrorType>(_RpcError_QNAME, RpcErrorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RpcResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:netconf:base:1.0", name = "rpcResponse")
    public JAXBElement<RpcResponseType> createRpcResponse(RpcResponseType value) {
        return new JAXBElement<RpcResponseType>(_RpcResponse_QNAME, RpcResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RpcOperationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:netconf:base:1.0", name = "rpcOperation")
    public JAXBElement<RpcOperationType> createRpcOperation(RpcOperationType value) {
        return new JAXBElement<RpcOperationType>(_RpcOperation_QNAME, RpcOperationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearAllFwCounters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://siklu.com/yang/tg/radio", name = "clear-all-fw-counters", substitutionHeadNamespace = "urn:ietf:params:xml:ns:netconf:base:1.0", substitutionHeadName = "rpcOperation")
    public JAXBElement<ClearAllFwCounters> createClearAllFwCounters(ClearAllFwCounters value) {
        return new JAXBElement<ClearAllFwCounters>(_ClearAllFwCounters_QNAME, ClearAllFwCounters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:netconf:base:1.0", name = "err-element", scope = ErrorInfoType.class)
    public JAXBElement<QName> createErrorInfoTypeErrElement(QName value) {
        return new JAXBElement<QName>(_ErrorInfoTypeErrElement_QNAME, QName.class, ErrorInfoType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:netconf:base:1.0", name = "bad-element", scope = ErrorInfoType.class)
    public JAXBElement<QName> createErrorInfoTypeBadElement(QName value) {
        return new JAXBElement<QName>(_ErrorInfoTypeBadElement_QNAME, QName.class, ErrorInfoType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:netconf:base:1.0", name = "ok-element", scope = ErrorInfoType.class)
    public JAXBElement<QName> createErrorInfoTypeOkElement(QName value) {
        return new JAXBElement<QName>(_ErrorInfoTypeOkElement_QNAME, QName.class, ErrorInfoType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:netconf:base:1.0", name = "noop-element", scope = ErrorInfoType.class)
    public JAXBElement<QName> createErrorInfoTypeNoopElement(QName value) {
        return new JAXBElement<QName>(_ErrorInfoTypeNoopElement_QNAME, QName.class, ErrorInfoType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:netconf:base:1.0", name = "bad-namespace", scope = ErrorInfoType.class)
    public JAXBElement<String> createErrorInfoTypeBadNamespace(String value) {
        return new JAXBElement<String>(_ErrorInfoTypeBadNamespace_QNAME, String.class, ErrorInfoType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:ietf:params:xml:ns:netconf:base:1.0", name = "bad-attribute", scope = ErrorInfoType.class)
    public JAXBElement<QName> createErrorInfoTypeBadAttribute(QName value) {
        return new JAXBElement<QName>(_ErrorInfoTypeBadAttribute_QNAME, QName.class, ErrorInfoType.class, value);
    }

}
