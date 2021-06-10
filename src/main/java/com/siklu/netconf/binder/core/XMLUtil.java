package com.siklu.netconf.binder.core;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLUtil {
	Document outputDoc;
	
	public XMLUtil(String xml) throws Exception
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		StringBuilder xmlStringBuilder = new StringBuilder();
		xmlStringBuilder.append(xml);
		ByteArrayInputStream input =  new ByteArrayInputStream(xmlStringBuilder.toString().getBytes("UTF-8"));
		outputDoc = builder.parse(input);
	}
	
	protected Element getChildElement(Element element, String tagName, boolean create) throws Exception {
		Node node = null;
		NodeList nodeList = element.getChildNodes();
		Element childElm = null;
		for (int i = 0; i < nodeList.getLength(); i++) {
			node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE && tagName.equals(node.getNodeName())) {
				childElm = (Element) node;
				break;
			}
		}

		if ((childElm == null) && (create)) {
			childElm = createChildElement(element, tagName);
		}

		return childElm;
	}
	
	public Element getChildElement(Element element, String tagName) throws Exception {

		return getChildElement(element, tagName, true);

	}

	public Element createChildElement(Element parentElement, String childName) {
		Element child = null;
		if (parentElement != null && (!"".equals(childName))) {
			child = parentElement.getOwnerDocument().createElement(childName);
			parentElement.appendChild(child);
		}
		return child;
	}

	public List<Element> getChildElements(Element element, String tagName) throws Exception {
		Node node = null;
		List<Element> elementList = new ArrayList();
		NodeList nodeList = element.getChildNodes();
		Element childElm = null;
		for (int i = 0; i < nodeList.getLength(); i++) {
			node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE && tagName.equals(node.getNodeName())) {
				childElm = (Element) node;
				elementList.add(childElm);
			}
		}

		return elementList;
	}

	
	public Document getOutputDoc() {
		return outputDoc;
	}

	public void setOutputDoc(Document outputDoc) {
		this.outputDoc = outputDoc;
	}
}
