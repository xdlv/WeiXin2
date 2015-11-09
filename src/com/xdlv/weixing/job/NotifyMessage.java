package com.xdlv.weixing.job;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.xdlv.fw.FwUtil;
import com.xdlv.fw.HttpClientTpl;
import com.xdlv.fw.I18n;
import com.xdlv.weixing.bean.ImportDzRecord;
import com.xdlv.weixing.bean.Userdz;
import com.xdlv.weixing.service.UserSerivce;

import net.sf.json.JSONObject;


/**
 * Created by xd on 2015/11/1.
 */
public class NotifyMessage {
    UserSerivce userSerivce;

    Logger logger = Logger.getLogger(NotifyMessage.class);
    public void execute() throws Exception{
        List<ImportDzRecord> importDzRecordList = userSerivce.getImportDzRecordForSend();
        if (importDzRecordList == null || importDzRecordList.size() < 1){
            logger.info("there is no notify message to send");
            return;
        }
        // every time we only process a record
        ImportDzRecord importDzRecord = importDzRecordList.get(0);
        List<Userdz> userdzs = userSerivce.getAllUserdzs(0, 5000000);
        if (userdzs == null){
            logger.info("there is no company to send");
            return;
        }
        String url = I18n.getI18n("detail_url");
        String retString;
        //construct message body:
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("touser","");//placeHold
        jsonObject.put("template_id", I18n.getI18n("notify_msg_tpl"));
        jsonObject.put("url","");//placeHold
        jsonObject.put("data",JSONObject.fromObject(String.format("{\"year\" : {\"value\":\"%d\", \"color\":\"#173177\"}, \"month\": {\"value\":\"%d\"" +
                ", \"color\":\"#173177\"},\"day\": {\"value\":\"%d\", \"color\":\"#173177\"}}"
                ,importDzRecord.getYear(),importDzRecord.getMonth(),FwUtil.getLastDayInMonth(importDzRecord.getYear(),
                importDzRecord.getMonth()))));

        for (Userdz userdz : userdzs){
            if (StringUtils.isBlank(userdz.getWxid())){
                logger.error("no wxid in userdz record:" + userdz.getPhone());
                continue;
            }
            logger.debug("start to notify:" + userdz.getPhone());
            jsonObject.put("touser",userdz.getWxid());
            jsonObject.put("url",url + "?openid=" + userdz.getWxid());
            retString = HttpClientTpl.postJson(String.format("https://api.weixin.qq.com/cgi-bin/message/template/send" +
                    "?access_token=%s", getAccessToken()), jsonObject.toString());
            logger.debug("end with ret:" + retString);
        }
        // finally we must set the status of ImportRecord
        importDzRecord.setNotification("E");
        userSerivce.updateImportDzRecordStatus(importDzRecord);
    }
    public void setUserSerivce(UserSerivce userSerivce) {
        this.userSerivce = userSerivce;
    }

    private String getAccessToken() throws Exception {
        return ((RefreshAccessToken)FwUtil.getBean("refreshAccessToken")).getAccessToken();
    }


}
