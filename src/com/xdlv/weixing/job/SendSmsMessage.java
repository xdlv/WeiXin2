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

	public void execute(){
        int count = userSerivce.deleteUserValidateForUnuse();
        if (count > 0){
            logger.debug("delete " + count + " items from uservalidate.");
        }
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
				String ret = HttpDemo.sendTextSms2(userValidate.getPhone()
						, String.format("@1@=%s", userValidate.getValidateCode()));
				if (ret == null || ret.indexOf("<status>0</status>") == -1){
					logger.error("return sms error:" + ret);
				} else {
					status = UserValidate.SENDED;
				}
			} catch (Exception e) {
				logger.error("send sms error", e);
				status = UserValidate.ERROR;
			} finally {
				userSerivce.updateUserValidateStatus(userValidate.getPhone(),status);
			}
		}
	}
	public void setUserSerivce(UserSerivce userSerivce) {
		this.userSerivce = userSerivce;
	}
}
