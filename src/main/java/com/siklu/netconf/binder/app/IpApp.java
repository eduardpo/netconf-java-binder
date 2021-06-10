package com.siklu.netconf.binder.app;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.siklu.netconf.binder.core.JXBinder;
import com.siklu.netconf.binder.core.NetconfOperations;
import com.siklu.netconf.binder.gen.ip.generated.Ip;
import com.siklu.netconf.binder.gen.ip.generated.ObjectFactory;

import net.juniper.netconf.CommitException;
import net.juniper.netconf.Device;

public class IpApp extends NetconfOperations {
	;
	private final JXBinder jxBinder;

	public IpApp(Device device) throws JAXBException {
		super(device); 
		jxBinder = new JXBinder();
	}

	public void editIp(String ip, short prefixLength, Boolean commit) throws JAXBException, ParserConfigurationException
	{
		String rpcData = "";
		ObjectFactory objFactory = new ObjectFactory();

		Ip.Ipv4.Address address = objFactory.createIpIpv4Address();
		address.setIp(ip);
		address.setPrefixLength(prefixLength);

		Ip.Ipv4 ipIpv4Obj = objFactory.createIpIpv4();
		ipIpv4Obj.getAddress().add(address);

		Ip ipObj = objFactory.createIp();
		ipObj.setIpv4(ipIpv4Obj);

		rpcData = jxBinder.marshalData(Ip.class, ipObj);

		try {

			editConfig(rpcData, commit);	// Send rpcData to device

		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
