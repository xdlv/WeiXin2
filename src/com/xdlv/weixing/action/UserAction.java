package com.xdlv.weixing.action;

import com.xdlv.fw.FwException;
import com.xdlv.fw.FwUtil;
import com.xdlv.fw.HttpClientTpl;
import com.xdlv.fw.I18n;
import com.xdlv.fw.action.BaseAction;
import com.xdlv.weixing.bean.*;
import com.xdlv.weixing.service.UserSerivce;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserAction extends BaseAction {

    static Logger logger = Logger.getLogger(UserAction.class);
    public static final String RET_KEY = "RET_FOR_TOUCH";

    String phone;
    String validateCode;

    String code;
    String openid;
    String state;

    Dzlist dzlist;
    List<Dzlist> dzlists;

    UserSerivce userSerivce;
    final static String appID = I18n.getI18n("appID");
    final static String appsecret = I18n.getI18n("appsecret");

    public String userBindIndex() throws Exception {
        Userdz userdz = getUserDzFromWeixing();
        setRetAttribute("openId",openid);
        //check if is used already bind.
        if (userdz != null) {
            setRetAttribute("phone", userdz.getPhone());
            setRetAttribute("viewId", "Main");
        } else {
            setRetAttribute("viewId", "License");
        }
        return SUCCESS;
    }
    public String currentDzIndex()throws Exception{
        return checkBindAndView("CurrentDz");
    }

    public String historyQueryIndex()throws Exception{
        return checkBindAndView("HistoryQuery");
    }

    private String checkBindAndView(String viewId) throws Exception{
        Userdz userdz = getUserDzFromWeixing();
        setRetAttribute("openId",openid);
        if (userdz == null){
            setRetAttribute("viewId", "License");
        } else {
            setRetAttribute("viewId", viewId);
        }
        return SUCCESS;
    }
    private Userdz getUserDzFromWeixing()throws Exception{
        if (openid == null){
            // wei xing
            String url = String.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s" +
                    "&secret=%s&code=%s&grant_type=authorization_code", appID,appsecret,code);
            String retJson = HttpClientTpl.get(url);
            logger.info("ret openid :" + retJson);
            JSONObject json = JSONObject.fromObject(retJson);
            openid = (String) json.get("openid");
            if (openid == null) {
                throw new FwException("无法获取用户信息:openid");
            }
        }
        return userSerivce.getUserdzByOpenid(openid);
    }
    private void setRetAttribute(String key, String value){
        HttpServletRequest request = ServletActionContext.getRequest();
        JSONObject jsonObject = (JSONObject)request.getAttribute(RET_KEY);
        if (jsonObject == null){
            jsonObject = new JSONObject();
            request.setAttribute(RET_KEY, jsonObject);
        }
        jsonObject.put(key, value);
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

    public String loadDzRecord() {
        int year, month;
        if (dzlist == null || dzlist.getYear() == 0 || dzlist.getMonth() == 0) {
            //get obtain dz record
            ImportDzRecord importDzRecord = userSerivce.getLastedNotifyImportDzRecord();
            if (importDzRecord == null || "N".equals(importDzRecord.getNotification())) {
                throw new FwException("当前没有账单可供查询");
            }
            year = importDzRecord.getYear();
            month = importDzRecord.getMonth();
            logger.info("load dzlist from current:" + year + "-" + month);
        } else {
            //apply parameters from user
            year = dzlist.getYear();
            month = dzlist.getMonth();
            logger.info("load dzlist from history:" + year + "-" + month);
        }
        dzlists = userSerivce.getDzlist(openid, year, month);
        return SUCCESS;
    }

    public String confirmDz() {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setDzlists(List<Dzlist> dzlists) {
        this.dzlists = dzlists;
    }

    public List<Dzlist> getDzlists() {
        return dzlists;
    }
}
