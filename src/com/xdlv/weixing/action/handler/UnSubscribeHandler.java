package com.xdlv.weixing.action.handler;

import com.xdlv.fw.I18n;
import com.xdlv.weixing.action.BaseHandler;
import com.xdlv.weixing.action.IHandler;
import com.xdlv.weixing.bean.ReceiveXmlEntity;
import com.xdlv.weixing.service.UserSerivce;
import org.apache.log4j.Logger;


public class UnSubscribeHandler extends BaseHandler implements IHandler {

	Logger logger = Logger.getLogger(UnSubscribeHandler.class);
	UserSerivce userSerivce;
	@Override
	public String process(ReceiveXmlEntity msg) {
		logger.info("unsubscript: " + msg.getFromUserName());
		userSerivce.deleteUserdzByOpenId(msg.getFromUserName());
		return "";
	}

	public void setUserSerivce(UserSerivce userSerivce) {
		this.userSerivce = userSerivce;
	}
}
