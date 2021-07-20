package com.siklu.netconf.binder.core;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.math3.geometry.spherical.oned.ArcsSet.Split;

import com.siklu.netconf.binder.gen.common.generated.RpcOperationType;

public class JXBinder {

	@SuppressWarnings({ "hiding", "unchecked" })
	public <T> T unmarshalData(Class<? extends T> nameSpace, String data)
	{
		T  tgData = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(nameSpace);    
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();     
			tgData = (T)jaxbUnmarshaller.unmarshal(new StringReader(data));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tgData;
	}

	public <T> String marshalData(Class<? extends T> nameSpace, T nameSpaceobj)
	{
		String configData = marshalGenericData(nameSpace, nameSpaceobj);
		configData = "<config>\n".concat(configData);
		configData = configData.concat("</config>");
		return configData;
	}
	
	public <T> String marshalRpcData(Class<? extends T> nameSpace, T nameSpaceobj)
	{
		String rpcData = marshalGenericData(nameSpace, nameSpaceobj);
		return rpcData;
	}
	
	public <T> String marshalGenericData(Class<? extends T> nameSpace, T nameSpaceobj)
	{
		String genericData = "";
		Marshaller marshallerObj;
		StringWriter xmlWriter = new StringWriter();

		try {
			JAXBContext contextObj = JAXBContext.newInstance(nameSpace); 
			marshallerObj = contextObj.createMarshaller();  
			marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshallerObj.marshal(nameSpaceobj, xmlWriter);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		genericData = xmlWriter.toString();
		genericData = genericData.substring(genericData.indexOf('\n')+1);	// strip off first line
		
		return genericData;
	}
}
