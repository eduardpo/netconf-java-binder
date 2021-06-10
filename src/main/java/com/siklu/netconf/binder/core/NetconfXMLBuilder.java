package com.siklu.netconf.binder.core;

import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;

import lombok.Getter;
import net.juniper.netconf.XML;
import net.juniper.netconf.XMLBuilder;

public class NetconfXMLBuilder {

	private final XMLBuilder builder;

	@Getter
	private XML xml;

	public NetconfXMLBuilder(String root) throws ParserConfigurationException
	{
		builder = new XMLBuilder();
		xml = builder.createNewXML(root);
	}

	public NetconfXMLBuilder(String root, String tag, String namespace) throws ParserConfigurationException
	{
		builder = new XMLBuilder();
		xml = builder.createNewXML(root,tag);
		xml.setAttribute("xmlns", namespace);
	}

	public NetconfXMLBuilder(String root, String namespace) throws ParserConfigurationException
	{
		builder = new XMLBuilder();
		xml = builder.createNewXML(root);
		xml.setAttribute("xmlns", namespace);
	}

	public void append(String tag)
	{
		this.xml = this.xml.append(tag);
	}

	public void append(String tag,String text)
	{
		this.xml = this.xml.append(tag);
		this.xml.setText(text);
	}

	public void append(List<String> list)
	{
		for (String tag:list)
			this.xml = this.xml.append(tag);
	}
	public void append(Map<String,String> data)
	{
		for (String key: data.keySet())
		{
			this.xml = this.xml.append(key,data.get(key));
		}
	}

	public void append(String element, Map<String,String> data)
	{
		xml.append(element, data);
		//		for (String key: data.keySet())
		//		{
		//			this.xml = this.xml.append(data.get(key));
		//		}
	}

	public void addSibling(Map<String,String> data)
	{
		for (String key: data.keySet())
		{
			this.xml.addSibling(key,data.get(key));
		}
	}

	public Element createNewElement(String element) {
		return this.xml.createNewElement(element);
	}

}
