package com.xdlv.weixing.action;

import com.xdlv.fw.action.BaseAction;
import com.xdlv.weixing.bean.Dzlist;
import com.xdlv.weixing.service.UserSerivce;

import java.util.List;

/**
 * Created by xd on 2015/10/31.
 */
public class DzlistAction extends BaseAction{
    List<Dzlist> dzlists;
    UserSerivce userSerivce;

    public String obtainDzlists(){
        return SUCCESS;
    }

    public void setUserSerivce(UserSerivce userSerivce) {
        this.userSerivce = userSerivce;
    }

    public void setDzlists(List<Dzlist> dzlists) {
        this.dzlists = dzlists;
    }

    public List<Dzlist> getDzlists() {
        return dzlists;
    }
}
