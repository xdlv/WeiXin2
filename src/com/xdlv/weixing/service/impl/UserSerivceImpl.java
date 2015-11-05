package com.xdlv.weixing.service.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.xdlv.weixing.bean.*;
import com.xdlv.weixing.service.UserSerivce;

public class UserSerivceImpl extends BaseServiceImpl implements UserSerivce{

	UserCompanyMapper userCompanyMapper;
	UserValidateMapper userValidateMapper;
	UserdzMapper userdzMapper;
    DzlistMapper dzlistMapper;
    ImportDzRecordMapper importDzRecordMapper;
	@Override
	public UserCompany[] getUserCompanyByPhone(String phone) {
		return userCompanyMapper.getUserCompanyByPhone(phone);
	}
	
	@Override
	public UserValidate[] getUserValidateForNotSend() {
		return userValidateMapper.selectUserValidateForNotSend();
	}
	
	@Override
	public int updateUserValidateStatus(String phone, String status){
		return userValidateMapper.updateStatusByPhone(phone,status);
	}
	
	public void setUserdzMapper(UserdzMapper userdzMapper) {
		this.userdzMapper = userdzMapper;
	}
	
	public void setUserCompanyMapper(UserCompanyMapper userCompanyMapper) {
		this.userCompanyMapper = userCompanyMapper;
	}
	
	public void setUserValidateMapper(UserValidateMapper userValidateMapper) {
		this.userValidateMapper = userValidateMapper;
	}

    public void setDzlistMapper(DzlistMapper dzlistMapper) {
        this.dzlistMapper = dzlistMapper;
    }

    public void setImportDzRecordMapper(ImportDzRecordMapper importDzRecordMapper) {
        this.importDzRecordMapper = importDzRecordMapper;
    }

	@Override
	public int batchSaveUserCompany(List<UserCompany> userCompanyList) {
		for (UserCompany userCompany : userCompanyList){
			userCompanyMapper.insert(userCompany);
		}
		return userCompanyList.size();
	}

    @Override
    public int getUserCompanysCount(){
        return userCompanyMapper.getUserCompanysCount();
    }

    @Override
    public List<UserCompany> getAllUserCompanys(int start, int end){
        return userCompanyMapper.selectUserCompanys(start, end);
    }

	@Override
	public void saveUserValidate(UserValidate userValidate) {
		userValidateMapper.insert(userValidate);
	}

    @Override
    public int deleteUserValidateForUnuse() {
        return userValidateMapper.deleteUserValidateForUnuse();
    }

    @Override
    public UserValidate getValidateCodeByPhone(String phone, String validateCode) {
        return userValidateMapper.getValidateCodeByPhone(phone,validateCode);
    }

    @Override
    public void saveUserDz(Userdz userdz) {
        userdzMapper.insert(userdz);
    }

    @Override
    public Userdz getUserdzByPhone(String phone) {
        return userdzMapper.selectUserdzByKey(phone);
    }

    @Override
    public int batchSaveDzlists(Collection<Dzlist> values) {
        Date date = new Date();
        for (Dzlist value : values){
            value.setImpdate(date);
            dzlistMapper.insert(value);
        }
        return values.size();
    }

	@Override
	public List<Dzlist> getAllDzlists(Dzlist dzlist,int start, int end) {
		return dzlistMapper.selectDzlists(dzlist, start, end);
	}

    @Override
    public void saveImportDzRecord(ImportDzRecord importDzRecord) {
        importDzRecordMapper.insert(importDzRecord);
    }

    @Override
    public int getDzListCount(Dzlist dzlist) {
        return dzlistMapper.getDzListCount(dzlist);
    }

    @Override
    public List<ImportDzRecord> getAllImportDzRecords() {
        return importDzRecordMapper.getAllImportDzRecords();
    }

    @Override
    public ImportDzRecord getImportDzRecordByYearAndMonth(int year, int month) {
        return importDzRecordMapper.getImportDzRecordByYearAndMonth(year,month);
    }

    @Override
    public void updateImportDzRecordStatus(ImportDzRecord importDzRecord) {
        importDzRecordMapper.updateImportDzRecordStatus(importDzRecord);
    }

    @Override
    public List<ImportDzRecord> getImportDzRecordForSend() {
        return importDzRecordMapper.selectDzRecordByStatus("Y");
    }

    @Override
    public List<Userdz> getAllUserdzs(int start, int end) {
        return userdzMapper.getAllUserdzs(start, end);
    }

    @Override
    public ImportDzRecord getLastedNotifyImportDzRecord() {
        List<ImportDzRecord> importDzRecords = importDzRecordMapper.getLastedNotifyImportDzRecord();
        if (importDzRecords != null && importDzRecords.size() > 0){
            return importDzRecords.get(0);
        }
        return null;
    }

    @Override
    public Dzlist getDzlist(String wxid, int year, int month) {
        List<Dzlist> dzlists = dzlistMapper.selectDzlistsByYearAndMonth(wxid, year, month);
        if (dzlists != null && dzlists.size() > 0){
            return dzlists.get(0);
        }
        return null;
    }

    @Override
    public void upateDzlistStatus(Dzlist dzlist) {
        dzlistMapper.updateDzlistStatus(dzlist);
    }

    public Userdz getUserdzByOpenid(String openid)
    {
        return userdzMapper.selectUserdzByOpenid(openid);
    }

    @Override
    public void deleteUserdzByOpenId(String fromUserName) {
        userdzMapper.deleteUserdzByOpenid(fromUserName);
    }
}
