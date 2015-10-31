package com.xdlv.weixing.job;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.xdlv.fw.I18n;
import com.xdlv.weixing.bean.UserValidate;
import com.xdlv.weixing.service.UserSerivce;

public class SendSmsMessage {
	UserSerivce userSerivce;
	Logger logger = Logger.getLogger(SendSmsMessage.class);
	static String smsTpl = I18n.getI18n("sms_tpl");
	
	static final String WAIT = "W", SENDED = "S", ERROR= "E";
	
	public void execute(){
		UserValidate[] userValidates = userSerivce.getUserValidateForNotSend();
		if (userValidates == null || userValidates.length < 1){
			logger.info("there is no validate sms to send.");
			return;
		}
		logger.info("start to send sms :");
		String status = null;
		for (UserValidate userValidate : userValidates){
			if (StringUtils.isEmpty(userValidate.getPhone())){
				logger.error("phone number is empty.");
				continue;
			}
			if (StringUtils.isEmpty(userValidate.getValidateCode())){
				logger.error("validate code is empty.");
				continue;
			}
			try {
				String ret = HttpDemo.sendTextSms(userValidate.getPhone()
						, String.format(smsTpl, userValidate.getValidateCode()));
				if (ret == null || ret.indexOf("<status>0</status>") == -1){
					logger.error("return sms error:" + ret);
				} else {
					status = SENDED;
				}
			} catch (Exception e) {
				logger.error("send sms error", e);
				status = ERROR;
			} finally {
				userSerivce.updateUserValidateStatus(userValidate.getPhone(),status);
			}
		}
	}
	public void setUserSerivce(UserSerivce userSerivce) {
		this.userSerivce = userSerivce;
	}
}
