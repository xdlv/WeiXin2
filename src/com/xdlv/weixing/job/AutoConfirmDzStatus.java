package com.xdlv.weixing.job;

import com.xdlv.weixing.service.UserSerivce;
import org.apache.log4j.Logger;

public class AutoConfirmDzStatus {

    UserSerivce userSerivce;
    Logger logger = Logger.getLogger(AutoConfirmDzStatus.class);
    public void execute() throws Exception{
        logger.info("start to update dz list automatically");
        int updateCount = userSerivce.updateDzListAutomatic();
        logger.info(String.format("end there are %d records to be updated",updateCount));
    }

    public void setUserSerivce(UserSerivce userSerivce) {
        this.userSerivce = userSerivce;
    }
}
