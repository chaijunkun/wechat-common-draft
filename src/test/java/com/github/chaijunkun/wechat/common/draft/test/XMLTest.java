package com.github.chaijunkun.wechat.common.draft.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.xml.bind.JAXBException;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.github.chaijunkun.wechat.common.craft.callback.xml.msg.TextMsg;
import com.github.chaijunkun.wechat.common.craft.util.XMLFactory;

public class XMLTest extends BaseTest {
	
	@Test
	public void doTest() throws JAXBException{
		TextMsg msg = new TextMsg();
		msg.setToUserName("jackson");
		msg.setFromUserName("hawaii");
		msg.setContent("jack<xml val='Json'>]]>");
		
		ByteArrayOutputStream xmlOut = null;
		ByteArrayInputStream xmlIn = null;
		try{
			xmlOut = new ByteArrayOutputStream();
			XMLFactory.toXML(msg, xmlOut);
			String xml = new String(xmlOut.toByteArray());
			logger.info("生成xml:{}", xml);
			xmlIn = new ByteArrayInputStream(xml.getBytes());
			TextMsg msgFromXml = XMLFactory.fromXML(xmlIn, TextMsg.class);
			logger.info("反序列化结果:发送方:{}, 接收方:{}, 内容:{}", msgFromXml.getFromUserName(), msgFromXml.getToUserName(), msgFromXml.getContent());
		}finally{
			IOUtils.closeQuietly(xmlIn);
			IOUtils.closeQuietly(xmlOut);
		}
	}
}
