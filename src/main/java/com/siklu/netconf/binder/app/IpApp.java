package com.siklu.netconf.binder.app;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import com.siklu.netconf.binder.core.JXBinder;
import com.siklu.netconf.binder.core.NetconfOperations;
import com.siklu.netconf.binder.gen.ip.generated.Ip;
import com.siklu.netconf.binder.gen.ip.generated.ObjectFactory;
import com.siklu.netconf.binder.xpath.GetTgIP;

import net.juniper.netconf.Device;

public class IpApp extends NetconfOperations {
	;
	private final JXBinder jxBinder;

	public IpApp(Device device, String name) throws JAXBException {
		super(device,name);
		jxBinder = new JXBinder();
	}

	public void editIpAddress(String ip, short prefixLength, Boolean commit) throws JAXBException, ParserConfigurationException
	{
		String rpcData = "";
		ObjectFactory objFactory = new ObjectFactory();
		String funcTitle = String.format("editIpAddress ip: %s, prefixLength: %d", ip, prefixLength);

		Ip.Ipv4.Address address = objFactory.createIpIpv4Address();
		address.setIp(ip);
		address.setPrefixLength(prefixLength);

		Ip.Ipv4 ipIpv4Obj = objFactory.createIpIpv4();
		ipIpv4Obj.getAddress().add(address);

		Ip ipObj = objFactory.createIp();
		ipObj.setIpv4(ipIpv4Obj);

		rpcData = jxBinder.marshalData(Ip.class, ipObj);

		editConfig(funcTitle, rpcData, commit);	// Send rpcData to device
	}
	
	public String getIpAddress() {
		String strAddressiP = xpathGet("getIpAddress", GetTgIP.ADDRESS_IP.getPrefix(), 
				GetTgIP.ADDRESS_IP.getNs(), 
				GetTgIP.ADDRESS_IP.getXpath(), "", -1); 				// get RPC XML reply
		Ip  objiP = jxBinder.unmarshalData(Ip.class, strAddressiP);		// Unmarshal XML to class object
		return objiP.getIpv4().getAddress().get(0).getIp();
	}
}
