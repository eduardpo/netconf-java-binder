package com.siklu.netconf.binder.app;

import javax.xml.bind.JAXBException;

import com.siklu.netconf.binder.core.JXBinder;
import com.siklu.netconf.binder.core.NetconfOperations;

import net.juniper.netconf.Device;

public class InventoryApp extends NetconfOperations {

	private final JXBinder jxBinder;
	
	public InventoryApp(Device device) throws JAXBException {
		super(device); 
		jxBinder = new JXBinder();
	}

}
