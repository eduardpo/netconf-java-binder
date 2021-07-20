package com.siklu.netconf.binder.app;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import com.siklu.netconf.binder.core.JXBinder;
import com.siklu.netconf.binder.core.NetconfOperations;
import com.siklu.netconf.binder.gen.dn.generated.AdminStatus;
import com.siklu.netconf.binder.gen.dn.generated.NodeType;
import com.siklu.netconf.binder.gen.dn.generated.ObjectFactory;
import com.siklu.netconf.binder.gen.dn.generated.RadioDn;
import com.siklu.netconf.binder.gen.dn.generated.RadioDn.Links.Configured;
import com.siklu.netconf.binder.gen.dn.generated.YesNo;
import com.siklu.netconf.binder.xpath.GetRadioDN;

import net.juniper.netconf.Device;

public class RadioDnApp  extends NetconfOperations {

	private final JXBinder jxBinder;

	public RadioDnApp(Device device) throws JAXBException {
		super(device); 
		jxBinder = new JXBinder();
	}

	public void editDefaultRadioProfileFrequency(int frequency, Boolean commit) throws JAXBException, ParserConfigurationException
	{
		String rpcData = "";
		ObjectFactory objFactory = new ObjectFactory();
		String funcTitle = String.format("editDefaultRadioProfileFrequency frequency: %d", frequency);

		RadioDn.NodeConfig.DefaultRadioProfile dfProfileObj = objFactory.createRadioDnNodeConfigDefaultRadioProfile();
		dfProfileObj.setFrequency(Integer.toString(frequency));

		RadioDn.NodeConfig nodeConfigObj = objFactory.createRadioDnNodeConfig();
		nodeConfigObj.setDefaultRadioProfile(dfProfileObj);

		RadioDn radioDnObj = objFactory.createRadioDn();
		radioDnObj.setNodeConfig(nodeConfigObj);

		rpcData = jxBinder.marshalData(RadioDn.class, radioDnObj);

		editConfig(funcTitle, rpcData, commit);	// Send rpcData to device
	}

	public void editSectorFrequency(int frequency, short sectorIndex, Boolean commit)
	{
		String rpcData = "";
		ObjectFactory objFactory = new ObjectFactory();
		String funcTitle = String.format("editSectorFrequency frequency: %d, sectorIndex: %d", 
				frequency, sectorIndex);

		RadioDn.SectorsConfig.Sector.RadioProfile radioProfile = objFactory.createRadioDnSectorsConfigSectorRadioProfile();
		radioProfile.setFrequency(Integer.toString(frequency));

		RadioDn.SectorsConfig.Sector sector = objFactory.createRadioDnSectorsConfigSector();
		sector.setIndex(sectorIndex);
		sector.setRadioProfile(radioProfile);

		RadioDn.SectorsConfig sectorsConfigObj = objFactory.createRadioDnSectorsConfig();
		sectorsConfigObj.getSector().add(sector);

		RadioDn radioDnObj = objFactory.createRadioDn();
		radioDnObj.setSectorsConfig(sectorsConfigObj);

		rpcData = jxBinder.marshalData(RadioDn.class, radioDnObj);

		editConfig(funcTitle, rpcData, commit);	// Send rpcData to device;
	}

	public void editConfiguredAdminStatus(String remoteAssignedName, Boolean adminStatus, Boolean commit) throws JAXBException
	{	
		String rpcData = "";
		ObjectFactory objFactory = new ObjectFactory();
		String funcTitle = String.format("editConfiguredAdminStatus remoteAssignedName: %s, adminStatus: %s", 
				remoteAssignedName, adminStatus.toString());

		RadioDn.Links.Configured linksConfigured = objFactory.createRadioDnLinksConfigured();
		linksConfigured.setRemoteAssignedName(remoteAssignedName);
		linksConfigured.setAdminStatus(adminStatus?AdminStatus.UP:AdminStatus.DOWN);

		RadioDn.Links links = objFactory.createRadioDnLinks();
		links.getConfigured().add(linksConfigured);

		RadioDn radioDnObj = objFactory.createRadioDn();
		radioDnObj.setLinks(links);

		rpcData = jxBinder.marshalData(RadioDn.class, radioDnObj);

		editConfig(funcTitle, rpcData, commit);	// Send rpcData to device;
	}

	public void configurePtPLink(String remoteAssignedName, boolean commit) {
		String rpcData = "";
		ObjectFactory objFactory = new ObjectFactory();
		String funcTitle = String.format("configurePtPLink remoteAssignedName: %s", remoteAssignedName);

		RadioDn.Links.Configured linksConfigured = objFactory.createRadioDnLinksConfigured();
		linksConfigured.setRemoteAssignedName(remoteAssignedName);
		linksConfigured.setAdminStatus(AdminStatus.UP);

		RadioDn.Links links = objFactory.createRadioDnLinks();
		links.getConfigured().add(linksConfigured);

		RadioDn radioDnObj = objFactory.createRadioDn();
		radioDnObj.setLinks(links);

		rpcData = jxBinder.marshalData(RadioDn.class, radioDnObj);

		editConfig(funcTitle, rpcData, commit);	// Send rpcData to device

	}

	public void deletePtPLink(String remoteAssignedName,boolean commit) {
		String rpcData = "";

		String strRadioDnLinks = xpathGet("deletePtPLink", GetRadioDN.RADIO_DN.getPrefix(), 
				GetRadioDN.RADIO_DN.getNs(), 
				GetRadioDN.RADIO_DN.getXpath(), "", -1); 			// get RPC XML reply
		RadioDn radioDnObj = jxBinder.unmarshalData(RadioDn.class, strRadioDnLinks);			// Unmarshal XML to class object

		ObjectFactory objFactory = new ObjectFactory();
		RadioDn.Links l = objFactory.createRadioDnLinks();

		List<Configured> links = radioDnObj.getLinks().getConfigured();
		for (RadioDn.Links.Configured link:links) {
			if (!link.getRemoteAssignedName().equals(remoteAssignedName)) l.getConfigured().add(link);
			else  l.getConfigured().add(new Configured());
		}

		radioDnObj.setLinks(l);
		rpcData = jxBinder.marshalData(Configured.class, radioDnObj);

		editConfig("deletePtPLink", rpcData, commit);	// Send rpcData to device

	}

	public void deletePtPLinkOld(String remoteAssignedName,boolean commit) {
		String rpcData = "";
		String funcTitle = String.format("deletePtPLinkOld remoteAssignedName: %s", remoteAssignedName);

		String strRadioDnLinks = xpathGet("deletePtPLinkOld", GetRadioDN.RADIO_DN.getPrefix(), 
				GetRadioDN.RADIO_DN.getNs(), 
				GetRadioDN.RADIO_DN.getXpath(), "", -1); 			// get RPC XML reply
		RadioDn radioDnObj = jxBinder.unmarshalData(RadioDn.class, strRadioDnLinks);			// Unmarshal XML to class object

		ObjectFactory objFactory = new ObjectFactory();
		RadioDn.Links l = objFactory.createRadioDnLinks();

		List<Configured> links = radioDnObj.getLinks().getConfigured();
		List<Configured> Newlinks = new ArrayList<Configured>();
		for (RadioDn.Links.Configured link:links) {
			if (!link.getRemoteAssignedName().equals(remoteAssignedName)) l.getConfigured().add(link);
		}

		radioDnObj.setLinks(l);
		rpcData = jxBinder.marshalData(Configured.class, Newlinks);

		editConfig(funcTitle, rpcData, commit);	// Send rpcData to device

	}

	
	public void editRadioLinksConfigured(String remoteAssignedName,short localSector, short remoteSector, boolean respoder_dn, boolean commit) {
		String rpcData = "";
		ObjectFactory objFactory = new ObjectFactory();
		String funcTitle = String.format("editRadioLinksConfigured remoteAssignedName: %s, localSector: %d, remoteSector: %d, respoder_dn: %s", 
				remoteAssignedName, localSector, remoteSector, Boolean.toString(respoder_dn));

		RadioDn.Links.Configured linksConfigured = objFactory.createRadioDnLinksConfigured();
		linksConfigured.setRemoteAssignedName(remoteAssignedName);

		if (respoder_dn) {
			linksConfigured.setResponderNodeType(respoder_dn ? NodeType.DN : NodeType.CN);
			linksConfigured.setControlSuperframe("0");
		} 

		RadioDn.Links.Configured.LocalSector local = objFactory.createRadioDnLinksConfiguredLocalSector();
		local.setIndex(localSector);
		linksConfigured.getLocalSector().add(local);

		RadioDn.Links.Configured.RemoteSector remote = objFactory.createRadioDnLinksConfiguredRemoteSector();
		remote.setIndex(remoteSector);
		linksConfigured.getRemoteSector().add(remote);

		linksConfigured.setAdminStatus(AdminStatus.UP);


		RadioDn.Links links = objFactory.createRadioDnLinks();
		links.getConfigured().add(linksConfigured);

		RadioDn radioDnObj = objFactory.createRadioDn();
		radioDnObj.setLinks(links);

		rpcData = jxBinder.marshalData(RadioDn.class, radioDnObj);

		editConfig(funcTitle, rpcData, commit);	// Send rpcData to device
	}

	
	public void editIsPopDn(Boolean isPopDn, Boolean commit) throws JAXBException, ParserConfigurationException
	{
		String rpcData = "";
		ObjectFactory objFactory = new ObjectFactory();
		String funcTitle = String.format("editIsPopDn isPopDn: %s", Boolean.toString(isPopDn));

		RadioDn.NodeConfig nodeConfigObj = objFactory.createRadioDnNodeConfig();
		nodeConfigObj.setIsPopDn(isPopDn);

		RadioDn radioDnObj = objFactory.createRadioDn();
		radioDnObj.setNodeConfig(nodeConfigObj);

		rpcData = jxBinder.marshalData(RadioDn.class, radioDnObj);

		editConfig(funcTitle, rpcData, commit);	// Send rpcData to device
	}
	
	public void editIgnoreGPS(YesNo yesNo, Boolean commit) throws JAXBException, ParserConfigurationException
	{
		String rpcData = "";
		ObjectFactory objFactory = new ObjectFactory();
		String funcTitle = String.format("editIgnoreGPS isPopDn: %s", yesNo.toString());

		RadioDn.NodeConfig nodeConfigObj = objFactory.createRadioDnNodeConfig();
		nodeConfigObj.setIgnoreGps(yesNo);

		RadioDn radioDnObj = objFactory.createRadioDn();
		radioDnObj.setNodeConfig(nodeConfigObj);

		rpcData = jxBinder.marshalData(RadioDn.class, radioDnObj);

		editConfig(funcTitle, rpcData, commit);	// Send rpcData to device
	}
}
