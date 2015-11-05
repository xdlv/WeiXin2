package com.xdlv.weixing.action;

import com.xdlv.fw.FwException;
import com.xdlv.fw.action.BaseAction;
import com.xdlv.weixing.bean.ImportDzRecord;
import com.xdlv.weixing.service.UserSerivce;

import java.util.Calendar;
import java.util.List;

public class ImportDzRecordAction extends BaseAction{

    List<ImportDzRecord> importDzRecords;
    ImportDzRecord importDzRecord;
    UserSerivce userSerivce;

    public String obtainImportDzRecord(){
        importDzRecords = userSerivce.getAllImportDzRecords();
        return SUCCESS;
    }

    public String notifyMessage(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        ImportDzRecord importDzRecord = userSerivce.getImportDzRecordByYearAndMonth(
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1);
        if (importDzRecord == null || !"N".equals(importDzRecord.getNotification())){
            throw new FwException("上月对账信息己下发或者还没有上传，无法进行下发");
        }
        importDzRecord.setNotification("Y");
        userSerivce.updateImportDzRecordStatus(importDzRecord);
        return FINISH;
    }

    public List<ImportDzRecord> getImportDzRecords() {
        return importDzRecords;
    }

    public void setImportDzRecords(List<ImportDzRecord> importDzRecords) {
        this.importDzRecords = importDzRecords;
    }

    public void setUserSerivce(UserSerivce userSerivce) {
        this.userSerivce = userSerivce;
    }

    public void setImportDzRecord(ImportDzRecord importDzRecord) {
        this.importDzRecord = importDzRecord;
    }

    public ImportDzRecord getImportDzRecord() {
        return importDzRecord;
    }
}
