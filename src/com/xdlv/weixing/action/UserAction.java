package com.xdlv.weixing.action;

import com.xdlv.fw.FwException;
import com.xdlv.fw.FwUtil;
import com.xdlv.fw.I18n;
import com.xdlv.fw.action.BaseAction;
import com.xdlv.weixing.bean.*;
import com.xdlv.weixing.service.UserSerivce;

public class UserAction extends BaseAction {

	String phone;
	String validateCode;
    String code;
    String openid;
    Dzlist dzlist;

	UserSerivce userSerivce;
    final static String appID = I18n.getI18n("appID");
    final static String appsecret = I18n.getI18n("appsecret");

	public String userBindIndex()throws Exception{
        //String url = String.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s" +
                //"&secret=%s&code=%s&grant_type=authorization_code", appID,appsecret,code);
        //String retJson = HttpClientTpl.get(url);
        //JSONObject json = JSONObject.fromObject(retJson);
        //setRequestAttribute("openId",json.getString("openid"));
        setRequestAttribute("openId","openid123");
        setRequestAttribute("viewId","Main");
        return SUCCESS;
    }
	public String userBind(){
        UserValidate userValidate = userSerivce.getValidateCodeByPhone(phone, validateCode);
        if (userValidate == null){
            throw new FwException("验证码无效，请重新获取");
        }
        Userdz userdz = new Userdz(phone, openid);
        userSerivce.saveUserDz(userdz);
		return FINISH;
	}
	
	public String sendValidateCode(){
		//首先要判断是否为合法用户
		UserCompany[] userCompanys = userSerivce.getUserCompanyByPhone(phone);
		if (userCompanys == null || userCompanys.length < 1){
			throw new FwException("不是合法客商用户");
		}
        if (userSerivce.getUserdzByPhone(phone) != null){
            throw new FwException("该用户手机号己经绑定");
        }
        UserValidate userValidate = new UserValidate(phone, FwUtil.getValidateCode());
        userSerivce.saveUserValidate(userValidate);
		return FINISH;
	}

    public String loadDzRecord(){
        int year, month;
        if (dzlist == null || dzlist.getYear() == 0 || dzlist.getMonth() == 0){
            //get obtain dz record
            ImportDzRecord importDzRecord = userSerivce.getLastedNotifyImportDzRecord();
            if (importDzRecord == null){
                throw new FwException("当前没有账单可供查询");
            }
            year = importDzRecord.getYear();
            month = importDzRecord.getMonth();
        } else {
            //apply parameters from user
            year = dzlist.getYear();
            month = dzlist.getMonth();
        }
        dzlist = userSerivce.getDzlist(openid,year, month);
        return SUCCESS;
    }

    public String confirmDz(){
        dzlist.setIsok("Y");
        userSerivce.upateDzlistStatus(dzlist);
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Dzlist getDzlist() {
        return dzlist;
    }

    public void setDzlist(Dzlist dzlist) {
        this.dzlist = dzlist;
    }
}
