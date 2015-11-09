package com.xdlv.weixing.action;

import java.util.HashMap;
import java.util.Map;

import com.xdlv.fw.FwUtil;
import com.xdlv.weixing.action.handler.SubscribeHandler;
import com.xdlv.weixing.action.handler.UnSubscribeHandler;

public class EventHandler{

	static Map<String, IHandler> handlerMap = new HashMap<String, IHandler>();
	
	static{
		handlerMap.put("subscribe", (IHandler)FwUtil.getBean("subscribeHandler"));
		handlerMap.put("unsubscribe",(IHandler)FwUtil.getBean("unSubscribeHandler"));

	}
	
	public static IHandler getEventHandler(String event){
		return handlerMap.get(event);
	}
	
}
