package com.xdlv.weixing.action;

import com.xdlv.fw.action.BaseAction;
import com.xdlv.weixing.bean.ImportDzRecord;
import com.xdlv.weixing.service.UserSerivce;

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
