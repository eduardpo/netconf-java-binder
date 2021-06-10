package com.siklu.netconf.binder.app;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

import com.siklu.netconf.binder.core.JXBinder;
import com.siklu.netconf.binder.core.NetconfOperations;
import com.siklu.netconf.binder.gen.common.generated.ObjectFactory;
import com.siklu.netconf.binder.gen.common.generated.RadioCommon;
import com.siklu.netconf.binder.gen.common.generated.RadioCommon.Links;
import com.siklu.netconf.binder.gen.common.generated.RadioCommon.Links.Active;
import com.siklu.netconf.binder.gen.common.generated.RadioCommon.SectorsConfig.Sector;
import com.siklu.netconf.binder.gen.common.generated.AdminStatus;
import com.siklu.netconf.binder.xpath.GetRadioCOMMON;

import net.juniper.netconf.CommitException;
import net.juniper.netconf.Device;


public class RadioCommonApp extends NetconfOperations {

	private final JXBinder jxBinder;

	public RadioCommonApp(Device device) throws JAXBException 
	{	
		super(device); 
		jxBinder = new JXBinder();
	}

	/*
		links {
		    active {
		        remote-assigned-name golden;
		        actual-remote-sector-index 3;
		        actual-local-sector-index 2;
		        remote-mac-addr 02:01:2f:f9:82:fe;
		        local-role responder;
		        rssi -62;
		        snr 11;
		        mcs-rx 9;
		        mcs-tx 9;
		        tx-per 0.00;
		        rx-per 0.00;
		        tx-power-index 8;
		        speed-rx 2050;
		        speed-tx 2050;
		        counters {
		            rx-ok 55;
		            tx-ok 7;
		            tx-fail 0;
		            rx-fail 3;
		            rx-hcs-fail 0;
		            tx-drop-lifetime-exp 0;
		            rx-drop-buf-size 0;
		            rx-drop-encryption-fail 0;
		            rx-drop-ra-mismatch 0;
		            rx-drop-unexpected 0;
		    }
	    }
	*/

	public Active getLinksActive(String remoteAssignedName) throws Exception 
	{
		Active activeLink = new Active();

		int i; // link index

		String strLinks = xpathGet(GetRadioCOMMON.RADIO_COMMON_LINKS.getPrefix(), 
				GetRadioCOMMON.RADIO_COMMON_LINKS.getNs(), 
				GetRadioCOMMON.RADIO_COMMON_LINKS.getXpath(), "", -1); 					// get RPC XML reply

		if (!strLinks.equals("")) {

			RadioCommon  objLinks = jxBinder.unmarshalData(RadioCommon.class, strLinks); 	// Unmarshal XML to class object

			Links links = objLinks.getLinks();

			for(i = 0; i < links.getActive().size(); i++) {
				if (links.getActive().get(i).getRemoteAssignedName().equals(remoteAssignedName)) {
					break;
				}
			}

			if (!links.getActive().get(i).getRemoteAssignedName().equals(remoteAssignedName)) {
				throw new Exception ("Link Down");
			}

			activeLink = links.getActive().get(i);

		} else {

			activeLink.setRemoteAssignedName("");		// prevent null pointer and report no link
		}

		return activeLink;
	}

	/* 
	sector {
	    index 3;
	    admin-status up;
	    state {
	        mac-addr 02:01:2f:f9:82:fe;
	        temperatures {
	            modem-temperature 76;
	            rf {
	                index 1;
	                rf-temperature 30;
	            }
	            rf {
	                index 2;
	                rf-temperature 0;
	            }
	            rf {
	                index 3;
	                rf-temperature 0;
	            }
	            rf {
	                index 4;
	                rf-temperature 0;
	            }
	        }
	    }
	}
	 */
	public Sector getSectorsConfigSector(int index) 
	{
		int sectorIndex = index - 1; // '0' based

		String strSectors = xpathGet(GetRadioCOMMON.RADIO_COMMON_SECTORS_CONFIG.getPrefix(), 
				GetRadioCOMMON.RADIO_COMMON_SECTORS_CONFIG.getNs(), 
				GetRadioCOMMON.RADIO_COMMON_SECTORS_CONFIG.getXpath(), "", -1); 		// get RPC XML reply
		RadioCommon  objSectors = jxBinder.unmarshalData(RadioCommon.class, strSectors);		// Unmarshal XML to class object

		return objSectors.getSectorsConfig().getSector().get(sectorIndex);
	}

	public String getSsid() 
	{		
		String strDefaultSsidProfile = xpathGet(GetRadioCOMMON.DEFAULT_SSID_PROFILE_SSID.getPrefix(), 
				GetRadioCOMMON.DEFAULT_SSID_PROFILE_SSID.getNs(), 
				GetRadioCOMMON.DEFAULT_SSID_PROFILE_SSID.getXpath(), "", -1); 							// get RPC XML reply
		RadioCommon  ssidProfileObject = jxBinder.unmarshalData(RadioCommon.class, strDefaultSsidProfile);		// Unmarshal XML to class object

		return ssidProfileObject.getNodeConfig().getDefaultSsidProfile().getSsid();

	}

	public void editSectorAdminStatus(short sectorIndex, Boolean adminStatus, Boolean commit) throws JAXBException
	{	
		String rpcData = "";
		ObjectFactory objFactory = new ObjectFactory();

		RadioCommon.SectorsConfig.Sector sector = objFactory.createRadioCommonSectorsConfigSector();
		sector.setIndex(sectorIndex);
		sector.setAdminStatus(adminStatus?AdminStatus.UP:AdminStatus.DOWN);

		RadioCommon.SectorsConfig sectorsConfigObj = objFactory.createRadioCommonSectorsConfig();
		sectorsConfigObj.getSector().add(sector);


		RadioCommon radioCommonObj = objFactory.createRadioCommon();
		radioCommonObj.setSectorsConfig(sectorsConfigObj);

		rpcData = jxBinder.marshalData(RadioCommon.class, radioCommonObj);

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

	public void editSsid(String ssid, Boolean commit) throws JAXBException
	{	
		String rpcData = "";
		ObjectFactory objFactory = new ObjectFactory();

		RadioCommon.NodeConfig.DefaultSsidProfile defaultSsidProfile = objFactory.createRadioCommonNodeConfigDefaultSsidProfile();
		defaultSsidProfile.setSsid(ssid);

		RadioCommon.NodeConfig nodeConfigObj = objFactory.createRadioCommonNodeConfig();
		nodeConfigObj.setDefaultSsidProfile(defaultSsidProfile);

		RadioCommon radioCommonObj = objFactory.createRadioCommon();
		radioCommonObj.setNodeConfig(nodeConfigObj);

		rpcData = jxBinder.marshalData(RadioCommon.class, radioCommonObj);

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

	public String linkToString(Active link)
	{
		//String ret = String.format("Stats for %s: RSSI: %.1f SNR:%.1f MCS Tx/Rx: %.1f/%.1f PER Tx/Rx: %.2f/%.2f TxPower: %d",
		String ret = String.format("Link stats for AN: %s, RSSI: %s, SNR: %s, MCS Tx/Rx: %s/%s, PER Tx/Rx: %s/%s, TxPower: %s",
				link.getRemoteAssignedName(),link.getRssi(), link.getSnr(), link.getMcsTx(), link.getMcsRx(), link.getTxPer(), link.getRxPer(), link.getTxPowerIndex());
		return ret;
	}
}
