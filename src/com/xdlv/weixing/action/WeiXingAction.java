package com.xdlv.weixing.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.xdlv.fw.action.BaseAction;
import com.xdlv.weixing.bean.ReceiveXmlEntity;

public class WeiXingAction extends BaseAction {

	private String echostr;

	public String entry() {
		if (StringUtils.isNotBlank(echostr)) {
			log.info("entry:" + echostr);
			returnXml(echostr);
			return XML;
		}
		ReceiveXmlEntity msg = getMsgEntity();
		log.info("process:" + msg);
		
		String result;

		if (StringUtils.isNotBlank(msg.getEvent())) {
			result = processEvent(msg);
		} else {
			//common message process
			result = proceeMessage(msg);
		}
		
		returnXml(result);
		return XML;
	}

	private String proceeMessage(ReceiveXmlEntity msg) {
		IHandler handler = MessageHandler.getMessageHandler(msg.getMsgType());
		if (handler != null){
			return handler.process(msg);
		}
		log.info("miss message handler :" + msg.getCreateTime());
		return null;
	}

	private String processEvent(ReceiveXmlEntity msg) {
		IHandler handler = EventHandler.getEventHandler(msg.getEvent());
		if (handler != null) {
			return handler.process(msg);
		}
		log.info("miss event handler :" + msg.getCreateTime());
		return null;
	}

	private void returnXml(String xml) {
		ServletActionContext.getRequest().setAttribute("xml", xml);
	}

	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}

	public String getEchostr() {
		return echostr;
	}

}
