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

	public Bridge getBridge(int bridgeIndex) {
		String strUserBridge = xpathGet(GetUserBRIDGE.USER_BRIDGE.getPrefix(), 
						GetUserBRIDGE.USER_BRIDGE.getNs(), 
						GetUserBRIDGE.USER_BRIDGE.getXpath(), "", -1); 									// get RPC XML reply
		UserBridge  objUserBridge = jxBinder.unmarshalData(UserBridge.class, strUserBridge);			// Unmarshal XML to class object

		Bridge bridge = objUserBridge.getBridge().get(bridgeIndex);

		return bridge;
	}
	
	public BridgePort getBridgePort(int bridgeIndex, int portIndex) {
		
		String bridgeIdXPath = GetUserBRIDGE.BRIDGE_BRIDGE_ID.getXpath();
		
		String bridgeIndexName = bridgeIdXPath.split(":")[bridgeIdXPath.split(":").length-1];
		
		String strBridge = xpathGet(GetUserBRIDGE.USER_BRIDGE_BRIDGE.getPrefix(), 
						GetUserBRIDGE.USER_BRIDGE_BRIDGE.getNs(), 
						GetUserBRIDGE.USER_BRIDGE_BRIDGE.getXpath(), bridgeIndexName, bridgeIndex); 		// get RPC XML reply
		UserBridge  objBridge = jxBinder.unmarshalData(UserBridge.class, strBridge);						// Unmarshal XML to class object

		BridgePort bridgePort = (BridgePort) objBridge.getBridge().get(0).getBridgePort().get(portIndex);

		return bridgePort;
	}
	
	public void editBridgePort(int bridgeIndex, int portIndex) {
		
	}
	
	public void deleteBridgePort(int bridgeIndex, int portIndex) {
	
	}
	
	public void deleteBridge(int bridgeIndex) {
		
	}
}
