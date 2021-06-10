package com.siklu.netconf.binder.core;

import javax.xml.bind.JAXBException;

import com.siklu.netconf.binder.app.InterfacesApp;
import com.siklu.netconf.binder.app.InventoryApp;
import com.siklu.netconf.binder.app.IpApp;
import com.siklu.netconf.binder.app.RadioCommonApp;
import com.siklu.netconf.binder.app.RadioDnApp;
import com.siklu.netconf.binder.app.SystemApp;
import com.siklu.netconf.binder.app.UserBridgeApp;
import com.siklu.netconf.binder.app.UserManagementApp;

import net.juniper.netconf.Device;
import net.juniper.netconf.NetconfException;

public class NetconfBinderConnector {

	protected JXBinder jxBinder;

	Device device;
	String host;
	int port;
	String user;
	String password;

	public RadioCommonApp radioCommon;
	public RadioDnApp radioDn;
	public InterfacesApp interfaces;
	public IpApp ip;
	public SystemApp system;
	public InventoryApp inventory;
	public UserBridgeApp userBridge;
	public UserManagementApp userManagement;

	public NetconfBinderConnector(String host, int port, String user, String password) {

		this.host = host;
		this.port = port;
		this.user = user;
		this.password = password;
	}

	public void InitNetconfObjects() throws JAXBException {

		radioCommon = new RadioCommonApp(device);
		radioDn = new RadioDnApp(device);
		interfaces = new InterfacesApp(device);
		ip = new IpApp(device);
		system = new SystemApp(device);
		inventory = new InventoryApp(device);
		userBridge = new UserBridgeApp(device);
		userManagement = new UserManagementApp(device);
	}

	/**
	 * Create a new Device using username and password authentication.
	 *
	 * @return an unconnected Device object.
	 * @throws NetconfException if there are issues creating the Device.
	 */
	private Device createDevice() throws NetconfException {
		return Device.builder().hostName(this.host).userName(this.user).password(this.password)
				.strictHostKeyChecking(false).port(this.port).build();
	}

	public void connect() throws NetconfException {
		device = createDevice();
		device.connect();
		setConnected(device.isConnected());
		try {
			InitNetconfObjects();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void disconnect() {
		device.close();
	}

	/**
	 * check if device is connected
	 * 
	 * @return
	 */
	public boolean isConnected() {
		return device.isConnected();
	}

	/**
	 * does nothing
	 * 
	 * @param connected
	 */
	public void setConnected(boolean connected) {
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
