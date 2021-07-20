package com.siklu.netconf.binder.app;

import javax.xml.bind.JAXBException;

import com.siklu.netconf.binder.core.JXBinder;
import com.siklu.netconf.binder.core.NetconfOperations;
import com.siklu.netconf.binder.gen.bridge.generated.UserBridge;
import com.siklu.netconf.binder.gen.bridge.generated.UserBridge.Bridge;
import com.siklu.netconf.binder.gen.bridge.generated.UserBridge.Bridge.BridgePort;
import com.siklu.netconf.binder.xpath.GetUserBRIDGE;

import net.juniper.netconf.Device;


public class UserBridgeApp  extends NetconfOperations {

	private final JXBinder jxBinder;

	public UserBridgeApp(Device device) throws JAXBException {
		super(device); 
		jxBinder = new JXBinder();
	}

	/**
	 * return port info from bridge
	 * @param int bridgeIndex
	 * '0' based in Netconf and '1' base in CLI representation 
	 */
	public Bridge getUserBridge(int bridgeIndex) {

		bridgeIndex = bridgeIndex -1;	//zero base convert
		
		String strUserBridge = xpathGet("getUserBridge", GetUserBRIDGE.USER_BRIDGE.getPrefix(), 
				GetUserBRIDGE.USER_BRIDGE.getNs(), 
				GetUserBRIDGE.USER_BRIDGE.getXpath(), "", -1); 									// get RPC XML reply
		UserBridge  objUserBridge = jxBinder.unmarshalData(UserBridge.class, strUserBridge);	// Unmarshal XML to class object

		Bridge bridge = objUserBridge.getBridge().get(bridgeIndex);

		return bridge;
	}

	/**
	 * return port info from bridge
	 * @param int bridgeIndex, int portIndex
	 * '0' based in Netconf and '1' base in CLI representation 
	 */
	public BridgePort getUserBridgePort(int bridgeIndex, int portIndex) {

		bridgeIndex = bridgeIndex -1;	//zero base convert
		portIndex = portIndex -1;		//zero base convert

		String bridgeIdXPath = GetUserBRIDGE.BRIDGE_BRIDGE_ID.getXpath();

		String bridgeIndexName = bridgeIdXPath.split(":")[bridgeIdXPath.split(":").length-1];

		String strBridge = xpathGet("getUserBridgePort", GetUserBRIDGE.USER_BRIDGE_BRIDGE.getPrefix(), 
				GetUserBRIDGE.USER_BRIDGE_BRIDGE.getNs(), 
				GetUserBRIDGE.USER_BRIDGE_BRIDGE.getXpath(), bridgeIndexName, bridgeIndex); 		// get RPC XML reply
		UserBridge  objBridge = jxBinder.unmarshalData(UserBridge.class, strBridge);				// Unmarshal XML to class object

		BridgePort bridgePort = (BridgePort) objBridge.getBridge().get(bridgeIndex).getBridgePort().get(portIndex);

		return bridgePort;
	}

	public void editUserBridge(int bridgeIndex) {

	}

	public void editUserBridgePort(int bridgeIndex, int portIndex) {

	}

	public void deleteUserBridge(int bridgeIndex) {

	}
	
	public void deleteUserBridgePort(int bridgeIndex, int portIndex) {

	}
}
