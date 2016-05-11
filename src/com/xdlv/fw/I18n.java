package com.xdlv.fw;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

public class I18n {

	static Logger logger = Logger.getLogger(I18n.class);
	static Properties properties;
	//static Map<String, String> i18nMap = new HashMap<String, String>();
	static {
		properties = new Properties();
		InputStreamReader reader = null;
		try {
			reader = new InputStreamReader(I18n.class.getResourceAsStream(
					"/i18n.properties"),FwUtil.UTF8);
			properties.load(reader);
		} catch (IOException e) {
			logger.error("can not load i18n files" , e);
		} finally {
			try {
				if (reader != null){
					reader.close();
				}
			} catch (IOException e) {
			}
		}
		
	}
	public static String getI18n(String key){
		return properties.getProperty(key, key);
	}

	public static void main(String[] args){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("touser", "");//placeHold
        jsonObject.put("template_id", I18n.getI18n("notify_msg_tpl"));
        jsonObject.put("url", "");//placeHold

        int year = 2016;
        int month = 4;
        int day = FwUtil.getLastDayInMonth(year,
                month);

        String first = String.format(I18n.getI18n("template_first"), year,month,day);
        String keyword1 = "*";
        String keyword2 = String.format(I18n.getI18n("template_keyword2"),year,month,day);
        String remark = I18n.getI18n("template_remark");

        JSONObject dataJson = new JSONObject();
        String format = "{\"value\":\"%s\",\"color\": \"%s\"}";
        dataJson.put("first",JSONObject.fromObject(String.format(format,first,"#bebebe")));
        dataJson.put("keyword1",JSONObject.fromObject(String.format(format,keyword1,"#bebebe")));
        dataJson.put("keyword2",JSONObject.fromObject(String.format(format,keyword2,"#bebebe")));
        dataJson.put("remark",JSONObject.fromObject(String.format(format,remark,"#173177")));

        jsonObject.put("data", dataJson);

        System.out.println(jsonObject);
	}
}
