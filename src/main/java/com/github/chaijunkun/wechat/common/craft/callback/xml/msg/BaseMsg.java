package com.github.chaijunkun.wechat.common.craft.callback.xml.msg;

import javax.xml.bind.annotation.XmlElement;

import com.github.chaijunkun.wechat.common.craft.callback.xml.CommonXML;

/**
 * 基础消息定义
 * @author chaijunkun
 * @since 2016年8月29日
 */
public class BaseMsg extends CommonXML {
	
	/** 消息id */
	@XmlElement(name="MsgId")
	private Long msgId;

	/**
	 * 获取消息id
	 * @return 消息id
	 */
	public Long getMsgId() {
		return msgId;
	}

	/**
	 * 设置消息id
	 * @param msgId 消息id
	 */
	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}
	
}
