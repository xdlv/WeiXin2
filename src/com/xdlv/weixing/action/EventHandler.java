package com.xdlv.weixing.action;

import java.util.HashMap;
import java.util.Map;

import com.xdlv.weixing.action.handler.SubscribeHandler;
import com.xdlv.weixing.action.handler.UnSubscribeHandler;

public class EventHandler{

	static Map<String, IHandler> handlerMap = new HashMap<String, IHandler>();
	
	static{
		handlerMap.put("subscribe", new SubscribeHandler());
		handlerMap.put("unsubscribe", new UnSubscribeHandler());

	}
	
	public static IHandler getEventHandler(String event){
		return handlerMap.get(event);
	}
	
}
