package com.xdlv.weixing.action;

import java.util.HashMap;
import java.util.Map;

import com.xdlv.weixing.action.handler.SubscribeHandler;

public class EventHandler{

	static Map<String, IHandler> handlerMap = new HashMap<String, IHandler>();
	
	static{
		handlerMap.put("subscribe", new SubscribeHandler());
	}
	
	public static IHandler getEventHandler(String event){
		return handlerMap.get(event);
	}
	
}
