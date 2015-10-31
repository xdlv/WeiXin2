package com.xdlv.weixing.action;

import com.xdlv.weixing.bean.ReceiveXmlEntity;

public interface IHandler {

	String process(ReceiveXmlEntity msg);

}