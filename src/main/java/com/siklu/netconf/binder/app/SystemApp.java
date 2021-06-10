package com.siklu.netconf.binder.app;

import javax.xml.bind.JAXBException;

import com.siklu.netconf.binder.core.JXBinder;
import com.siklu.netconf.binder.core.NetconfOperations;
import com.siklu.netconf.binder.gen.system.generated.System;
import com.siklu.netconf.binder.gen.system.generated.System.State.BanksInfo.Banks;
import com.siklu.netconf.binder.xpath.GetTgSYSTEM;

import net.juniper.netconf.Device;

public class SystemApp  extends NetconfOperations {

	private final JXBinder jxBinder;
	
	public SystemApp(Device device) throws JAXBException {
		super(device); 
		jxBinder = new JXBinder();
	}
	
	public Banks getStateBanksInfo(int bankIndex) {
		
		
		String strBanks = xpathGet(GetTgSYSTEM.BANKS_INFO_BANKS.getPrefix(), 
						GetTgSYSTEM.BANKS_INFO_BANKS.getNs(), 
						GetTgSYSTEM.BANKS_INFO_BANKS.getXpath(), "", -1); 			// get RPC XML reply
		System  objBanks = jxBinder.unmarshalData(System.class, strBanks);			// Unmarshal XML to class object

		Banks bank = (Banks)((System) objBanks).getState().getBanksInfo().getBanks().get(bankIndex);

		return bank;
	}
}
