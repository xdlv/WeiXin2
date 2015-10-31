package com.xdlv.weixing.action;

import com.xdlv.fw.action.BaseAction;
import com.xdlv.weixing.bean.UserCompany;
import com.xdlv.weixing.service.UserSerivce;

import java.util.List;

public class UserCompanyAction extends BaseAction{

    List<UserCompany> userCompanys;
    UserSerivce userSerivce;
    public String obtainUserCompanys(){
        total = userSerivce.getUserCompanysCount();
        userCompanys = userSerivce.getAllUserCompanys(start, start + limit);
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
}
