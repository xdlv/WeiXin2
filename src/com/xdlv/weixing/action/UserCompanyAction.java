package com.xdlv.weixing.action;

import com.xdlv.fw.FwUtil;
import com.xdlv.fw.action.BaseAction;
import com.xdlv.weixing.bean.UserCompany;
import com.xdlv.weixing.service.UserSerivce;
import org.apache.commons.lang.StringUtils;

import java.net.URLDecoder;
import java.util.List;

public class UserCompanyAction extends BaseAction{

    List<UserCompany> userCompanys;
    UserCompany userCompany = new UserCompany();
    UserSerivce userSerivce;
    public String obtainUserCompanys()throws Exception{
        if (userCompany != null && StringUtils.isNotBlank(userCompany.getCompanyName())){
            userCompany.setCompanyName(URLDecoder.decode(userCompany.getCompanyName(), FwUtil.UTF8));
        }
        total = userSerivce.getUserCompanysCount(userCompany);
        userCompanys = userSerivce.getAllUserCompanys(userCompany,start, limit);
        return SUCCESS;
    }

    public void setUserCompanys(List<UserCompany> userCompanys) {
        this.userCompanys = userCompanys;
    }

    public List<UserCompany> getUserCompanys() {
        return userCompanys;
    }

    public void setUserSerivce(UserSerivce userSerivce) {
        this.userSerivce = userSerivce;
    }

    public UserCompany getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(UserCompany userCompany) {
        this.userCompany = userCompany;
    }
}
