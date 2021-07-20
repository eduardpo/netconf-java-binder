package com.siklu.netconf.binder.app;

import javax.xml.bind.JAXBException;

import com.siklu.netconf.binder.core.JXBinder;
import com.siklu.netconf.binder.core.NetconfOperations;

import net.juniper.netconf.Device;

public class UserManagementApp  extends NetconfOperations {

	private final JXBinder jxBinder;

	public UserManagementApp(Device device, String name) throws JAXBException {
		super(device,name); 
		jxBinder = new JXBinder();
	}

}
