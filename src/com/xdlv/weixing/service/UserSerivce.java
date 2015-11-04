package com.xdlv.weixing.service;

import java.util.Collection;
import java.util.List;

import com.xdlv.weixing.bean.*;

public interface UserSerivce extends BaseService{

	UserCompany[] getUserCompanyByPhone(String phone);
	
	UserValidate[] getUserValidateForNotSend();
	
	int updateUserValidateStatus(String phone,String status);

	int batchSaveUserCompany(List<UserCompany> userCompanyList);

	int getUserCompanysCount();

	List<UserCompany> getAllUserCompanys(int start, int end);

	void saveUserValidate(UserValidate userValidate);
    
    int deleteUserValidateForUnuse();

    UserValidate getValidateCodeByPhone(String phone, String validateCode);

    void saveUserDz(Userdz userdz);

    Userdz getUserdzByPhone(String phone);

    int batchSaveDzlists(Collection<Dzlist> values);

	int getDzListCount(Dzlist dzlist);

    List<Dzlist> getAllDzlists(Dzlist dzlist, int start, int end);

    void saveImportDzRecord(ImportDzRecord importDzRecord);

    List<ImportDzRecord> getAllImportDzRecords();

    ImportDzRecord getImportDzRecordByYearAndMonth(int year, int month);

    void updateImportDzRecordStatus(ImportDzRecord importDzRecord);

    List<ImportDzRecord> getImportDzRecordForSend();

    List<Userdz> getAllUserdzs(int start, int end);

    ImportDzRecord getLastedNotifyImportDzRecord();


    Dzlist getDzlist(String wxid, int year, int month);

    void upateDzlistStatus(Dzlist dzlist);

    Userdz getUserdzByOpenid(String openId);

    void deleteUserdzByOpenId(String fromUserName);
}