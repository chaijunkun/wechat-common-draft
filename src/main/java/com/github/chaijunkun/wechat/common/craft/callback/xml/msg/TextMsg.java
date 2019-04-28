package com.github.chaijunkun.wechat.common.craft.callback.xml.msg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

/**
 * 文本消息
 * @author chaijunkun
 * @since 2016年8月29日
 */
@XmlRootElement(name="xml")
public class TextMsg extends BaseMsg {
	
	/** 文本消息内容 */
	@XmlElement(name="Content")
	@XmlCDATA
	private String content;

	/**
	 * 获取文本消息内容
	 * @return 文本消息内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置文本消息内容
	 * @param content 文本消息内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
}
