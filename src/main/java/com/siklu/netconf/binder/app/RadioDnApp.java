package com.siklu.netconf.binder.app;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.siklu.netconf.binder.core.JXBinder;
import com.siklu.netconf.binder.core.NetconfOperations;
import com.siklu.netconf.binder.gen.dn.generated.ObjectFactory;
import com.siklu.netconf.binder.gen.dn.generated.RadioDn;
import com.siklu.netconf.binder.gen.dn.generated.AdminStatus;

import net.juniper.netconf.CommitException;
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

		RadioDn.NodeConfig.DefaultRadioProfile dfProfileObj = objFactory.createRadioDnNodeConfigDefaultRadioProfile();
		dfProfileObj.setFrequency(Integer.toString(frequency));

		RadioDn.NodeConfig nodeConfigObj = objFactory.createRadioDnNodeConfig();
		nodeConfigObj.setDefaultRadioProfile(dfProfileObj);

		RadioDn radioDnObj = objFactory.createRadioDn();
		radioDnObj.setNodeConfig(nodeConfigObj);

		rpcData = jxBinder.marshalData(RadioDn.class, radioDnObj);

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

	public void editSectorFrequency(int frequency, short sectorIndex, Boolean commit) throws JAXBException
	{
		String rpcData = "";
		ObjectFactory objFactory = new ObjectFactory();

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
		};
	}

	public void editConfiguredAdminStatus(String remoteAssignedName, Boolean adminStatus, Boolean commit) throws JAXBException
	{	
		String rpcData = "";
		ObjectFactory objFactory = new ObjectFactory();

		RadioDn.Links.Configured linksConfigured = objFactory.createRadioDnLinksConfigured();
		linksConfigured.setRemoteAssignedName(remoteAssignedName);
		linksConfigured.setAdminStatus(adminStatus?AdminStatus.UP:AdminStatus.DOWN);
		
		RadioDn.Links links = objFactory.createRadioDnLinks();
		links.getConfigured().add(linksConfigured);

		RadioDn radioDnObj = objFactory.createRadioDn();
		radioDnObj.setLinks(links);

		rpcData = jxBinder.marshalData(RadioDn.class, radioDnObj);

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
		};
	}
}
