package com.github.chaijunkun.wechat.common.craft.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.Writer;
import java.util.Collections;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.jaxb.JAXBContextFactory;

public class XMLFactory {

	private static final String DEFAULT_ENCODING= "utf-8";

	private static <T> JAXBContext getContext(Class<T> clazz) throws JAXBException{
		return JAXBContextFactory.createContext(new Class[]{clazz},Collections.<String,Object>emptyMap());
	}

	/**
	 * 将对象转换为xml
	 * @param obj 待转换对象
	 * @param encoding xml编码制式
	 * @param out 输出流
	 * @throws JAXBException
	 */
	public static <T> void toXML(Object obj, String encoding, OutputStream out) throws JAXBException{
		if (obj== null){
			return;
		}
		JAXBContext context= XMLFactory.getContext(obj.getClass());
		Marshaller marshaller= context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(obj, out);
	}

	/**
	 * 将对象使用默认编码转换为xml
	 * @param obj 待转换对象
	 * @param out 输出流
	 * @throws JAXBException
	 */
	public static <T> void toXML(Object obj, OutputStream out) throws JAXBException{
		XMLFactory.toXML(obj, DEFAULT_ENCODING, out);
	}
	
	/**
	 * 将对象转换为xml
	 * @param obj 待转换对象
	 * @param encoding xml编码制式
	 * @param writer 输出
	 * @throws JAXBException
	 */
	public static <T> void toXML(Object obj, String encoding, Writer writer) throws JAXBException{
		if (obj== null){
			return;
		}
		JAXBContext context= XMLFactory.getContext(obj.getClass());
		Marshaller marshaller= context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(obj, writer);
	}
	
	/**
	 * 将对象转换为xml
	 * @param obj 待转换对象
	 * @param writer 输出
	 * @throws JAXBException
	 */
	public static <T> void toXML(Object obj, Writer writer) throws JAXBException{
		XMLFactory.toXML(obj, DEFAULT_ENCODING, writer);
	}

	/**
	 * 将xml转换为指定对象的实例
	 * @param in 输入流
	 * @param clazz 待转换类型
	 * @return 转换后的实例
	 * @throws JAXBException xml转换时发生的异常
	 * @throws ClassCastException 类型转换时发生的异常
	 */
	public static <T> T fromXML(InputStream in, Class<T> clazz) throws JAXBException{
		JAXBContext context= XMLFactory.getContext(clazz);
		Unmarshaller unmarshaller= context.createUnmarshaller();
		JAXBElement<T> unmarshal = unmarshaller.unmarshal(new StreamSource(in), clazz);
		return unmarshal.getValue();
	}
	
	/**
	 * 将xml转换为指定对象的实例  add by huofei 2014-7-21
	 * @param xmlStr xml字符串
	 * @param clazz 待转换类型
	 * @return
	 * @throws JAXBException
	 * @throws ClassCastException
	 */
	public static <T> T fromXML(String xml, Class<T> clazz) throws JAXBException {
		JAXBContext context= XMLFactory.getContext(clazz);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		JAXBElement<T> unmarshal = unmarshaller.unmarshal(new StreamSource(new StringReader(xml)), clazz);
		return unmarshal.getValue();
	}
}