package com.siklu.netconf.binder.app;

import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import com.siklu.netconf.binder.core.JXBinder;
import com.siklu.netconf.binder.core.NetconfOperations;
import com.siklu.netconf.binder.gen.system.generated.ActivateUpgradedSoftware;
import com.siklu.netconf.binder.gen.system.generated.CancelActivateUpgradedSoftware;
import com.siklu.netconf.binder.gen.system.generated.DownloadAndBurningStateType;
import com.siklu.netconf.binder.gen.system.generated.DownloadAndFlashSoftwareUpgradeFile;
import com.siklu.netconf.binder.gen.system.generated.ObjectFactory;
import com.siklu.netconf.binder.gen.system.generated.RpcType;
import com.siklu.netconf.binder.gen.system.generated.SchedulingType;
import com.siklu.netconf.binder.gen.system.generated.System;
import com.siklu.netconf.binder.gen.system.generated.System.State.BanksInfo.Banks;
import com.siklu.netconf.binder.gen.system.generated.System.State.SwUpgradeInfo;
import com.siklu.netconf.binder.xpath.GetTgSYSTEM;

import net.juniper.netconf.Device;

public class SystemApp  extends NetconfOperations {

	private final JXBinder jxBinder;

	public SystemApp(Device device, String name) throws JAXBException {
		super(device,name); 
		jxBinder = new JXBinder();
		setAssignedName(name);
	}

	public List<Banks> getSystemStateBanksInfo() {

		String strBanks = xpathGet("getSystemStateBanksInfo", GetTgSYSTEM.BANKS_INFO_BANKS.getPrefix(), 
				GetTgSYSTEM.BANKS_INFO_BANKS.getNs(), 
				GetTgSYSTEM.BANKS_INFO_BANKS.getXpath(), "", -1); 			// get RPC XML reply
		System  objBanks = jxBinder.unmarshalData(System.class, strBanks);	// Unmarshal XML to class object

		List<Banks> banks = objBanks.getState().getBanksInfo().getBanks();

		return banks;
	}

	public Banks getSystemStateBanksInfoBank(int bankIndex) {

		String strBanks = xpathGet("getSystemStateBanksInfoBank", GetTgSYSTEM.BANKS_INFO_BANKS.getPrefix(), 
				GetTgSYSTEM.BANKS_INFO_BANKS.getNs(), 
				GetTgSYSTEM.BANKS_INFO_BANKS.getXpath(), "", -1); 			// get RPC XML reply
		System  objBanks = jxBinder.unmarshalData(System.class, strBanks);	// Unmarshal XML to class object

		Banks bank = (Banks) objBanks.getState().getBanksInfo().getBanks().get(bankIndex);

		return bank;
	}

	public SwUpgradeInfo getSystemStateSwUpgradeInfo() {

		String strBanks = xpathGet("getSystemStateSwUpgradeInfo", GetTgSYSTEM.STATE_SW_UPGRADE_INFO.getPrefix(), 
				GetTgSYSTEM.STATE_SW_UPGRADE_INFO.getNs(), 
				GetTgSYSTEM.STATE_SW_UPGRADE_INFO.getXpath(), "", -1); 			// get RPC XML reply
		System  objBanks = jxBinder.unmarshalData(System.class, strBanks);			// Unmarshal XML to class object

		SwUpgradeInfo swinfo = objBanks.getState().getSwUpgradeInfo();

		return swinfo;
	}

	public String getSystemName() {
		String strSystemName = xpathGet("getSystemName", GetTgSYSTEM.SYSTEM_NAME.getPrefix(), 
				GetTgSYSTEM.SYSTEM_NAME.getNs(), 
				GetTgSYSTEM.SYSTEM_NAME.getXpath(), "", -1); 						// get RPC XML reply
		System  objBanks = jxBinder.unmarshalData(System.class, strSystemName);		// Unmarshal XML to class object
		return objBanks.getName();
	}

	public void editSystemName(String name, Boolean commit)
	{
		String rpcData = "";
		ObjectFactory objFactory = new ObjectFactory();
		String funcTitle = String.format("editSystemName name: %s", name);

		System systemObj = objFactory.createSystem();
		systemObj.setName(name);

		rpcData = jxBinder.marshalData(System.class, systemObj);

		editConfig(funcTitle, rpcData, commit);	// Send rpcData to device
	}

	public DownloadAndBurningStateType getDownloadAndBurningState() {

		String strState = xpathGet("getDownloadAndBurningState", GetTgSYSTEM.SW_UPGRADE_INFO_DOWNLOAD_AND_BURNING_STATE.getPrefix(), 
				GetTgSYSTEM.SW_UPGRADE_INFO_DOWNLOAD_AND_BURNING_STATE.getNs(), 
				GetTgSYSTEM.SW_UPGRADE_INFO_DOWNLOAD_AND_BURNING_STATE.getXpath(), "", -1); // get RPC XML reply
		System  objState = jxBinder.unmarshalData(System.class, strState);					// Unmarshal XML to class object

		DownloadAndBurningStateType state = objState.getState().getSwUpgradeInfo().getDownloadAndBurningState();
		return state;
	}

	public String softwareDownload(String url, boolean force)
	{
		String rpcData = "";
		ObjectFactory systemObj = new ObjectFactory();
		String funcTitle = String.format("softwareDownload url: %s, force: %s", url, Boolean.toString(force));

		DownloadAndFlashSoftwareUpgradeFile dFile = new DownloadAndFlashSoftwareUpgradeFile();
		dFile.setUrl(url);
		dFile.setForce(force);
		JAXBElement<DownloadAndFlashSoftwareUpgradeFile> dFileElement = systemObj.createDownloadAndFlashSoftwareUpgradeFile(dFile);

		RpcType rpcTypeObj = systemObj.createRpcType();
		rpcTypeObj.setRpcOperation(dFileElement);

		rpcData = jxBinder.marshalRpcData(DownloadAndFlashSoftwareUpgradeFile.class, rpcTypeObj.getRpcOperation());
		return sendCommand(funcTitle, rpcData, true);
	}

	public String softwareActivate(SchedulingType scheduleType)
	{
		String rpcData = "";
		ObjectFactory systemObj = new ObjectFactory();
		String funcTitle = String.format("softwareActivate scheduleType: %s", scheduleType.toString());

		ActivateUpgradedSoftware shceduling = new ActivateUpgradedSoftware();
		shceduling.setScheduling(scheduleType);
		JAXBElement<ActivateUpgradedSoftware> activateSoftware = systemObj.createActivateUpgradedSoftware(shceduling);

		RpcType rpcTypeObj = systemObj.createRpcType();
		rpcTypeObj.setRpcOperation(activateSoftware);

		rpcData = jxBinder.marshalRpcData(ActivateUpgradedSoftware.class, rpcTypeObj.getRpcOperation());
		return sendCommand(funcTitle, rpcData, true);
	}

	public String softwareCancelActivation()
	{
		String rpcData = "";
		ObjectFactory systemObj = new ObjectFactory();

		CancelActivateUpgradedSoftware cancelShceduling = new CancelActivateUpgradedSoftware();
		JAXBElement<CancelActivateUpgradedSoftware> cancelAactivateSoftware = 
				systemObj.createCancelActivateUpgradedSoftware(cancelShceduling);

		RpcType rpcTypeObj = systemObj.createRpcType();
		rpcTypeObj.setRpcOperation(cancelAactivateSoftware);

		rpcData = jxBinder.marshalRpcData(CancelActivateUpgradedSoftware.class, rpcTypeObj.getRpcOperation());
		return sendCommand("softwareCancelActivation", rpcData, true);
	}

	public boolean softwareUpgrade(String url, SchedulingType scheduleType, boolean force, boolean activate)
	{
		boolean retVal = false;

		DownloadAndBurningStateType currentState = getDownloadAndBurningState();

		if (currentState != DownloadAndBurningStateType.IN_PROGRESS) {

			softwareDownload(url, force);	// start the Download process

			currentState = getDownloadAndBurningState();

			if (currentState == DownloadAndBurningStateType.IN_PROGRESS) {	

				// monitor current status
				while (currentState != DownloadAndBurningStateType.FINISHED_SUCCESSFULLY &&
						currentState != DownloadAndBurningStateType.FAILED) {

					currentState = getDownloadAndBurningState();
				}

				if (currentState != DownloadAndBurningStateType.FAILED)
				{
					if (activate) 
					{
						softwareActivate(scheduleType);	// activate 
					}
					retVal = true;
				}
			}
		}

		return retVal;
	}

}
