package com.siklu.netconf.binder.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import net.juniper.netconf.CommitException;
import net.juniper.netconf.Device;
import net.juniper.netconf.XML;

public class NetconfOperations {

	Device device;

	public NetconfOperations(Device device) {
		this.device = device;
	}

	public String sendCommand(String command, boolean ignoreErrors) {
		XML reply = null;
		try {
			reply = device.executeRPC(command);
		} catch (SAXException | IOException e) {
			//report.report(e.toString(),e);
			e.printStackTrace();
		}
		return reply.toString();

	}

	protected XML sendXmlCommand(XML command) {
		XML reply = null;
		try {
			reply = device.executeRPC(command);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
		return reply;
	}

	public XML get(XML command) {
		return sendXmlCommand(command);
	}

	public XML getConfig(XML command) {
		return sendXmlCommand(command);
	}

	public String sendCommand(String command) {
		return sendCommand(command, false);
	}

	public String commit()
	{
		String reply = "";
		reply = sendCommand("<commit/>");
		if (!reply.contains("<ok/>"))
		{
			sendCommand("show compare running-candidate");
			discard();
		}
		return reply;
	}

	public void copyRunningStartup()
	{
		sendCommand(String.format("copy running startup"));
	}

	public void resetSystem()
	{
		sendCommand(String.format("<reboot system/>"));
	}

	public void resetFactoryDefault()
	{
		sendCommand(String.format("reboot restore-factory-defaults"));
	}

	public String validate()
	{
		return sendCommand("<validate/>");
	}

	public String discard()
	{
		return sendCommand("<discard-changes/>");
	}

	public String copyConfig(String src, String dst)
	{
		String buffer = "<copy-config>\n" + 
				"<target>\n" + 
				String.format("<%s/>\n",src) + 
				"</target>\n" + 
				"<source>\n" + 
				String.format("<%s/>\n",dst) + 
				"</source>\n" + 
				"</copy-config>";

		return sendCommand(buffer);
	}

	/**
	 * xml should be a payload for edit-config in format:<br/>
	 * <top xmlns="http://example.com/schema/1.2/config">
	 *   <ip>
	 *   	<ipv4>
	 *     		<address>192.168.0.2</address>
	 *     		<prefix-len>23</prefix-len>
	 *   	</ipv4>
	 *   </ip>
	 * </top>
	 * @param xml
	 * @return
	 * @throws SAXException 
	 * @throws IOException 
	 * @throws CommitException 
	 */
	public String editConfig(String xml , Boolean commit) throws CommitException, IOException, SAXException
	{
		String reply = "";
		String buffer = String.format("<edit-config><target><candidate/></target><default-operation>merge</default-operation>");
		buffer += String.format("%s</edit-config>", xml);
		reply = sendCommand(buffer);
		if (commit) {
			commit();
			//device.commit();
		}
		return reply;
	}

	public String deleteConfig(String xml) throws CommitException, IOException, SAXException
	{
		String reply = "";
		String buffer = String.format("<edit-config><target><candidate/></target><default-operation>none</default-operation>");
		buffer += String.format("%s</edit-config>", xml);
		reply = sendCommand(buffer);
		//device.commit();
		commit();
		return reply;
	}

	public String xpathGet(String prefix, String ns, String xpath, String indexName, int index)
	{
		NetconfXMLBuilder builder;
		XML xml;
		String xpathIndex = "", reply = "";

		if(index > 0)	// list element case e.g. sector number
		{
			xpathIndex = xpathIndex.concat("[" + prefix.replace("xmlns:", "") + ":" + indexName + "=" + Integer.toString(index) + "]");
		}

		try {
			builder = new NetconfXMLBuilder("get");	// opening tag;
			xml = builder.getXml();

			xml=xml.append("filter");
			xml.setAttribute(prefix, ns);
			xml.setAttribute("type", "xpath");
			xml.setAttribute("select", xpath.concat(xpathIndex));

			reply = trimReply(get(xml));

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} 
		return reply;
	}

	public String trimReply(XML reply)
	{
		String strElement = "";

		try {
			XMLUtil xmlutil = new XMLUtil(reply.toString());
			Document outputDoc = xmlutil.getOutputDoc();
			Element rpcreplyElm = outputDoc.getDocumentElement();

			Element dataElm = xmlutil.getChildElement(rpcreplyElm,"data");
			//Element radioElm = xmlutil.getChildElement(dataElm,"radio-common");

			NodeList nl = dataElm.getChildNodes();

			for(int i = 0; i < nl.getLength(); i++)
			{
				Node node = nl.item(i);
				if(node instanceof Element)
				{
					ByteArrayOutputStream buffer = new ByteArrayOutputStream();
					StreamResult result = new StreamResult(buffer);
					DOMSource source = new DOMSource(node);
					TransformerFactory tFactory = TransformerFactory.newInstance();
					Transformer transformer = tFactory.newTransformer();
					transformer.setOutputProperty(javax.xml.transform.OutputKeys.OMIT_XML_DECLARATION, "yes");
					transformer.transform(source, result);

					strElement =  result.getOutputStream().toString();
				}
			}

		} catch (DOMException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return strElement;
	}

}
