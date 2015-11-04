package com.xdlv.weixing.action;

import com.xdlv.fw.FwUtil;
import com.xdlv.fw.action.BaseAction;
import com.xdlv.weixing.bean.Dzlist;
import com.xdlv.weixing.service.UserSerivce;
import org.apache.commons.lang.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.List;

/**
 * Created by xd on 2015/10/31.
 */
public class DzlistAction extends BaseAction{
    List<Dzlist> dzlists;
    UserSerivce userSerivce;

    Dzlist dzlist;
    private InputStream excelFile;
    public String obtainDzlists()throws Exception{
        if (dzlist != null && StringUtils.isNotBlank(dzlist.getUsername())){
            dzlist.setUsername(URLDecoder.decode(dzlist.getUsername(), FwUtil.UTF8));
        }
        total = userSerivce.getDzListCount(dzlist);
        dzlists = userSerivce.getAllDzlists(dzlist,start, start + limit);
        return SUCCESS;
    }

    public String downLoadDzlists() throws Exception{
        excelFile = new ByteArrayInputStream("ABC".getBytes());
        return SUCCESS;
    }

    public InputStream getExcelFile() {
        return excelFile;
    }

    public String getFileName() throws Exception {
        return "对账记录" + "-" + dzlist.getYear() + "-" + dzlist.getMonth()+ ".xls";
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

    public Dzlist getDzlist() {
        return dzlist;
    }

    public void setDzlist(Dzlist dzlist) {
        this.dzlist = dzlist;
    }

}
