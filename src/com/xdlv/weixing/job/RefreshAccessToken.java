package com.xdlv.weixing.job;

import com.xdlv.fw.HttpClientTpl;
import com.xdlv.fw.I18n;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

public class RefreshAccessToken {

    String accessToken;
    static Logger logger = Logger.getLogger(RefreshAccessToken.class);

    public synchronized String getAccessToken() throws Exception {
        if (accessToken == null){
            execute();
        }
        return accessToken;
    }
    synchronized void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }
    public void execute() throws Exception {
        logger.info("start to refresh token");
        String url = String.format("https://api.weixin.qq.com/cgi-bin/token" +
                "?grant_type=client_credential&appid=%s&secret=%s"
                , I18n.getI18n("appID"),I18n.getI18n("appsecret"));
        String json = HttpClientTpl.get(url);
        String token = JSONObject.fromObject(json).getString("access_token");
        setAccessToken(token);
        logger.info("get token:" + token);
    }
}
