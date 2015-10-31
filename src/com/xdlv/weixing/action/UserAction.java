package com.xdlv.weixing.action;

import com.xdlv.fw.action.BaseAction;
import com.xdlv.weixing.bean.UserCompany;
import com.xdlv.weixing.service.UserSerivce;

public class UserAction extends BaseAction {

	String phone;
	String validateCode;
	UserSerivce userSerivce;
	
	public String userBind(){
		
		return FINISH;
	}
	
	public String sendValidateCode(){
		//首先要判断是否为合法用户
		UserCompany userCompany = userSerivce.getUserCompanyByPhone(phone);
		if (userCompany == null){
			throw new RuntimeException("不是合法客商用户");
		}
		//userSerivce
		return FINISH;
	}
	
	public void setUserSerivce(UserSerivce userSerivce) {
		this.userSerivce = userSerivce;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
}
