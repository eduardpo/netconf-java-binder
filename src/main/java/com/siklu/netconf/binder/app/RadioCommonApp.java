package com.siklu.netconf.binder.app;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.siklu.netconf.binder.core.JXBinder;
import com.siklu.netconf.binder.core.NetconfOperations;
import com.siklu.netconf.binder.gen.common.generated.AdminStatus;
import com.siklu.netconf.binder.gen.common.generated.ObjectFactory;
import com.siklu.netconf.binder.gen.common.generated.RadioCommon;
import com.siklu.netconf.binder.gen.common.generated.RadioCommon.Links;
import com.siklu.netconf.binder.gen.common.generated.RadioCommon.Links.Active;
import com.siklu.netconf.binder.gen.common.generated.RadioCommon.SectorsConfig;
import com.siklu.netconf.binder.gen.common.generated.RadioCommon.SectorsConfig.Sector;
import com.siklu.netconf.binder.xpath.GetRadioCOMMON;

import net.juniper.netconf.Device;


public class RadioCommonApp extends NetconfOperations {

	private final JXBinder jxBinder;

	public RadioCommonApp(Device device,String name) throws JAXBException 
	{	
		super(device,name); 
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

		String strLinks = xpathGet("getLinksActive", GetRadioCOMMON.RADIO_COMMON_LINKS.getPrefix(), 
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

			if (i == links.getActive().size()) {
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
	
	/**
	 * get sector info 
	 * @param index - sector index 1 based
	 * @return
	 */
	public Sector getSectorsConfigSector(int index) 
	{
		int sectorIndex = index - 1; // '0' based

		String strSectors = xpathGet("getSectorsConfigSector", GetRadioCOMMON.RADIO_COMMON_SECTORS_CONFIG.getPrefix(), 
				GetRadioCOMMON.RADIO_COMMON_SECTORS_CONFIG.getNs(), 
				GetRadioCOMMON.RADIO_COMMON_SECTORS_CONFIG.getXpath(), "", -1); 		// get RPC XML reply
		RadioCommon  objSectors = jxBinder.unmarshalData(RadioCommon.class, strSectors);		// Unmarshal XML to class object

		return objSectors.getSectorsConfig().getSector().get(sectorIndex);
	}
	
	/**
	 * get SectorsConfig info 
	 * @return
	 */
	public SectorsConfig getSectorsConfig() 
	{

		String strSectors = xpathGet("getSectorsConfig", GetRadioCOMMON.RADIO_COMMON_SECTORS_CONFIG.getPrefix(), 
				GetRadioCOMMON.RADIO_COMMON_SECTORS_CONFIG.getNs(), 
				GetRadioCOMMON.RADIO_COMMON_SECTORS_CONFIG.getXpath(), "", -1); 		// get RPC XML reply
		RadioCommon  objSectors = jxBinder.unmarshalData(RadioCommon.class, strSectors);		// Unmarshal XML to class object

		return objSectors.getSectorsConfig();
	}
	
	/**
	 * get modem temperature.
	 * @param sector
	 * @return
	 */
	public int getSectorModemTemperature(int sector)
	{
		Sector data = getSectorsConfigSector(sector);
		short modemTemp = data.getState().getTemperatures().getModemTemperature();
		return modemTemp;
	}

	/**
	 * get RF temperatures in sector. each sector can host up to 4 RF's
	 * @param sector
	 * @return list of RF temperatures (0 based)
	 */
	public ArrayList<Short> getSectorRFTemperatures(int sector)
	{
		ArrayList<Short> reply = new ArrayList<Short>();
		Sector data = getSectorsConfigSector(sector);
		for (int idx=0; idx<4; idx++) {
			reply.add(data.getState().getTemperatures().getRf().get(idx).getRfTemperature());
		}
		return reply;	
	}

	/**
	 * 
	 * @param sector
	 * @return
	 * @throws Exception 
	 */
	public String getSectorMacAddress(int sector) throws Exception {
		
		int sectorIndex = sector - 1; // '0' based
		String sectorMacAddress = "";
		
		SectorsConfig sectorsConfigData = getSectorsConfig();
		
		if (sectorIndex >= sectorsConfigData.getSector().size()) {
			throw new Exception ("Sector index: " + sectorIndex + " is out of range!");
		}
		
		for(int i = 0; i <= sectorsConfigData.getSector().size(); i++) {
			sectorMacAddress = sectorsConfigData.getSector().get(sectorIndex).getState().getMacAddr();
			if (i == sectorIndex) {
				break;
			}
		}
		return sectorMacAddress;
	}
	
	public String getProfileSsid() 
	{		
		String strDefaultSsidProfile = xpathGet("getProfileSsid", GetRadioCOMMON.DEFAULT_SSID_PROFILE_SSID.getPrefix(), 
				GetRadioCOMMON.DEFAULT_SSID_PROFILE_SSID.getNs(), 
				GetRadioCOMMON.DEFAULT_SSID_PROFILE_SSID.getXpath(), "", -1); 							// get RPC XML reply
		RadioCommon  ssidProfileObject = jxBinder.unmarshalData(RadioCommon.class, strDefaultSsidProfile);		// Unmarshal XML to class object

		return ssidProfileObject.getNodeConfig().getDefaultSsidProfile().getSsid();

	}

	public void editSectorAdminStatus(short sectorIndex, Boolean adminStatus, Boolean commit) throws JAXBException
	{	
		String rpcData = "";
		ObjectFactory objFactory = new ObjectFactory();
		String funcTitle = String.format("editSectorAdminStatus sectorIndex: %d, adminStatus: %s", 
				sectorIndex, adminStatus.toString());

		RadioCommon.SectorsConfig.Sector sector = objFactory.createRadioCommonSectorsConfigSector();
		sector.setIndex(sectorIndex);
		sector.setAdminStatus(adminStatus?AdminStatus.UP:AdminStatus.DOWN);

		RadioCommon.SectorsConfig sectorsConfigObj = objFactory.createRadioCommonSectorsConfig();
		sectorsConfigObj.getSector().add(sector);


		RadioCommon radioCommonObj = objFactory.createRadioCommon();
		radioCommonObj.setSectorsConfig(sectorsConfigObj);

		rpcData = jxBinder.marshalData(RadioCommon.class, radioCommonObj);

		editConfig(funcTitle, rpcData, commit);	// Send rpcData to device
	}

	public void editProfileSsid(String ssid, Boolean commit) throws JAXBException
	{	
		String rpcData = "";
		ObjectFactory objFactory = new ObjectFactory();
		String funcTitle = String.format("editProfileSsid ssid: %s", ssid);

		RadioCommon.NodeConfig.DefaultSsidProfile defaultSsidProfile = objFactory.createRadioCommonNodeConfigDefaultSsidProfile();
		defaultSsidProfile.setSsid(ssid);

		RadioCommon.NodeConfig nodeConfigObj = objFactory.createRadioCommonNodeConfig();
		nodeConfigObj.setDefaultSsidProfile(defaultSsidProfile);

		RadioCommon radioCommonObj = objFactory.createRadioCommon();
		radioCommonObj.setNodeConfig(nodeConfigObj);

		rpcData = jxBinder.marshalData(RadioCommon.class, radioCommonObj);

		editConfig(funcTitle, rpcData, commit);	// Send rpcData to device
	}

	/**
	 * set Node Tx power (for all links and all sectors)
	 * @param txPowerIndex 0-31
	 * @param commit
	 */
	public void editNodeTxPowerControl(int txPowerIndex, boolean commit) {
		String rpcData = "";
		ObjectFactory objFactory = new ObjectFactory();
		String funcTitle = String.format("editNodeTxPowerControl txPowerIndex: %d", txPowerIndex);

		RadioCommon.NodeConfig nodeConfig = objFactory.createRadioCommonNodeConfig();
		List<String> txPowerControl = nodeConfig.getTxPowerControl();
		txPowerControl.add(txPowerIndex+"");
		
		RadioCommon radioCommonObj = objFactory.createRadioCommon();
		radioCommonObj.setNodeConfig(nodeConfig);

		rpcData = jxBinder.marshalData(RadioCommon.class, radioCommonObj);

		editConfig(funcTitle, rpcData, commit);	// Send rpcData to device
	}
	
	public String linkToString(Active link)
	{
		//String ret = String.format("Stats for %s: RSSI: %.1f SNR:%.1f MCS Tx/Rx: %.1f/%.1f PER Tx/Rx: %.2f/%.2f TxPower: %d",
		String ret = String.format("Link stats for AN: %s, RSSI: %s, SNR: %s, MCS Tx/Rx: %s/%s, PER Tx/Rx: %s/%s, TxPower: %s",
				link.getRemoteAssignedName(),link.getRssi(), link.getSnr(), link.getMcsTx(), link.getMcsRx(), link.getTxPer(), link.getRxPer(), link.getTxPowerIndex());
		return ret;
	}
}
