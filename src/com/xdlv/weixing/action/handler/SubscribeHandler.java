package com.xdlv.weixing.action.handler;

import com.xdlv.fw.I18n;
import com.xdlv.weixing.action.BaseHandler;
import com.xdlv.weixing.action.IHandler;
import com.xdlv.weixing.bean.ReceiveXmlEntity;

public class SubscribeHandler extends BaseHandler implements IHandler {

	static String welcome = I18n.getI18n("welcome_msg");
	@Override
	public String process(ReceiveXmlEntity msg) {
		return fillTextTpl(welcome,msg);
	}

}
