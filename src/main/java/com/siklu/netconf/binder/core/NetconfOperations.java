package com.siklu.netconf.binder.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.siklu.analyzers.NetConfAnalyzer;

import jsystem.framework.analyzer.AnalyzerException;
import jsystem.framework.report.Reporter;
import jsystem.framework.system.SystemObjectImpl;
import lombok.Getter;
import lombok.Setter;
import net.juniper.netconf.CommitException;
import net.juniper.netconf.Device;
import net.juniper.netconf.XML;

public class NetconfOperations extends SystemObjectImpl {

	Device device;
	@Getter @Setter
	protected String assignedName = "";
	public NetconfOperations(Device device, String name) {
		this.device = device;
		this.assignedName = name;
	}

	private XML execute(String rpcTitle, String command, boolean ignoreErrors) {
		XML reply = null;
		try {
			String[] operation = command.split("<")[1].split(">")[0].split(" ");
			reply = device.executeRPC(command);
			report.report(getAssignedName() + "-nc: " + 
					operation[0] + " -> " + rpcTitle, reply == null ? 
					"<plaintext>" + command + "\nNULL" : 
					"<plaintext>" + command +  "\n" + reply.toString(), true);
			setTestAgainstObject(reply);
			if (!ignoreErrors) analyze(new NetConfAnalyzer(),true);
		} catch (SAXException | IOException e) {
			report.report(e.toString(),e);
			e.printStackTrace();
		}
		return reply;
	}

	/**
	 * 
	 * @param command
	 * @param ignoreErrors
	 * @return
	 */
	public String sendCommand(String rpcTitle, String command, boolean ignoreErrors) {
		XML reply = execute(rpcTitle, command, ignoreErrors);
		return reply.toString();
	}

	/**
	 * 
	 * @param command
	 * @param ignoreErrors
	 * @return
	 */
	protected XML sendCommand(String rpcTitle, XML command, boolean ignoreErrors) {
		XML reply = execute(rpcTitle, command.toString(), ignoreErrors);
		return reply;
	}

	public XML get(String rpcTitle, XML command) {
		return sendCommand(rpcTitle, command, false);
	}

	public XML getConfig(XML command) {
		return sendCommand("getConfig", command, false);
	}

	public String sendCommand(String rpcTitle, String command) {
		return sendCommand(rpcTitle, command, false);
	}

	public String commit() {
		String reply = "";
		try {
			reply = sendCommand("", "<commit/>");
		} catch (AnalyzerException e) {
			report.report("commit failed. running discard", reply + "\nCcompare Candidate vs Running:\n<plaintext>" + compare("candidate","running"),Reporter.WARNING);
			discard();
		}
		return reply;
	}

	public void copyRunningStartup() {
		copyConfig("running","startup");
	}

	public void rebootSystem(String ns) {
		sendCommand("", "<reset xmlns=" + ns + "/>");
	}

	public void resetFactoryDefault() {
		sendCommand("", "<factory-reset/>");//String.format("reboot restore-factory-defaults"));
	}

	public String validate() {
		return sendCommand("", "<validate/>");
	}

	public String discard() {
		return sendCommand("", "<discard-changes/>");
	}

	public String copyConfig(String src, String dst) {
		String buffer = "<copy-config>\n" + 
				"<target>\n" + 
				String.format("<%s/>\n",src) + 
				"</target>\n" + 
				"<source>\n" + 
				String.format("<%s/>\n",dst) + 
				"</source>\n" + 
				"</copy-config>";

		return sendCommand("", buffer);
	}

	/**
	 * show compare src db to dst db
	 * will return the difference between src and dst
	 * @param src
	 * @param dst
	 * @return
	 */
	public String compare(String src, String dst) {
		String srcDB = sendCommand("", String.format("<get-config><source><%s/></source></get-config>",src));
		String dstDB = sendCommand("", String.format("<get-config><source><%s/></source></get-config>",dst));
		String difference = StringUtils.difference(srcDB, dstDB);
		return difference;
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
	public String editConfig(String rpcTitle, String xml, Boolean commit) {
		String reply = "";
		String buffer = String
				.format("<edit-config><target><candidate/></target><default-operation>merge</default-operation>");
		buffer += String.format("%s</edit-config>", xml);
		reply = sendCommand(rpcTitle, buffer);
		if (commit)
			commit();
		return reply;
	}

	public String deleteConfigOld(String xml, Boolean commit) throws CommitException, IOException, SAXException {
		String reply = "";
		String buffer = String
				.format("<edit-config><target><candidate/></target><default-operation>none</default-operation>");
		buffer += String.format("%s</edit-config>", xml);
		reply = sendCommand("", buffer);
		if (commit)
			commit();
		return reply;
	}

	public String deleteConfig(String xml, Boolean commit) throws CommitException, IOException, SAXException {
		String reply = "";
		String buffer = String
				.format("<edit-config><target><candidate/></target><default-operation>replace</default-operation>");
		buffer += String.format("%s</edit-config>", xml);
		reply = sendCommand("", buffer);
		if (commit)
			commit();
		return reply;
	}

	public String xpathGet(String rpcTitle, String prefix, String ns, String xpath, String indexName, int index) {
		NetconfXMLBuilder builder;
		XML xml;
		String xpathIndex = "", reply = "";

		if (index > 0) // list element case e.g. sector number
		{
			xpathIndex = xpathIndex
					.concat("[" + prefix.replace("xmlns:", "") + ":" + indexName + "=" + Integer.toString(index) + "]");
		}

		try {
			builder = new NetconfXMLBuilder("get"); // opening tag;
			xml = builder.getXml();

			xml = xml.append("filter");
			xml.setAttribute(prefix, ns);
			xml.setAttribute("type", "xpath");
			xml.setAttribute("select", xpath.concat(xpathIndex));

			reply = trimReply(get(rpcTitle, xml));

			if (reply.equals("")) {
				report.report("NETCONF GET REPLY IS EMPTY!", Reporter.WARNING);
			}

		} catch (ParserConfigurationException e) {
			report.report(e.toString(),e);
			e.printStackTrace();
		}
		return reply;
	}

	public String trimReply(XML reply) {
		String strElement = "";

		try {
			XMLUtil xmlutil = new XMLUtil(reply.toString());
			Document outputDoc = xmlutil.getOutputDoc();
			Element rpcreplyElm = outputDoc.getDocumentElement();

			Element dataElm = xmlutil.getChildElement(rpcreplyElm, "data");
			// Element radioElm = xmlutil.getChildElement(dataElm,"radio-common");

			NodeList nl = dataElm.getChildNodes();

			for (int i = 0; i < nl.getLength(); i++) {
				Node node = nl.item(i);
				if (node instanceof Element) {
					ByteArrayOutputStream buffer = new ByteArrayOutputStream();
					StreamResult result = new StreamResult(buffer);
					DOMSource source = new DOMSource(node);
					TransformerFactory tFactory = TransformerFactory.newInstance();
					Transformer transformer = tFactory.newTransformer();
					transformer.setOutputProperty(javax.xml.transform.OutputKeys.OMIT_XML_DECLARATION, "yes");
					transformer.transform(source, result);

					strElement = result.getOutputStream().toString();
				}
			}

		} catch (DOMException e) {
			report.report(e.toString(),e);
			e.printStackTrace();
		} catch (Exception e) {
			report.report(e.toString(),e);
			e.printStackTrace();
		}

		return strElement;
	}

}
