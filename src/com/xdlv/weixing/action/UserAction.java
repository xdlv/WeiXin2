package com.xdlv.weixing.action;

import com.xdlv.fw.FwException;
import com.xdlv.fw.FwUtil;
import com.xdlv.fw.HttpClientTpl;
import com.xdlv.fw.I18n;
import com.xdlv.fw.action.BaseAction;
import com.xdlv.weixing.bean.UserCompany;
import com.xdlv.weixing.bean.UserValidate;
import com.xdlv.weixing.bean.Userdz;
import com.xdlv.weixing.service.UserSerivce;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

public class UserAction extends BaseAction {

	String phone;
	String validateCode;
    String code;
    String openid;

	UserSerivce userSerivce;
    final static String appID = I18n.getI18n("appID");
    final static String appsecret = I18n.getI18n("appsecret");

	public String userBindIndex()throws Exception{
        String url = String.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s" +
                "&secret=%s&code=%s&grant_type=authorization_code", appID,appsecret,code);
        //String retJson = HttpClientTpl.get(url);
        //JSONObject json = JSONObject.fromObject(retJson);
        //setRequestAttribute("openid",json.getString("openid"));
        setRequestAttribute("openid","openid123");
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
}
