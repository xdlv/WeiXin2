package com.xdlv.weixing.action;

import com.xdlv.fw.I18n;
import com.xdlv.weixing.bean.ReceiveXmlEntity;

public class BaseHandler {
	static String TEXT_XML = I18n.getI18n("text_xml");

	protected String fillTextTpl(String content, ReceiveXmlEntity msg) {
		return String.format(TEXT_XML, msg.getFromUserName(), msg.getToUserName(),
				System.currentTimeMillis(), "text", content);
	}
}
