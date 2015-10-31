package com.xdlv.weixing.service;

import java.util.List;

import com.xdlv.weixing.bean.User;
import com.xdlv.weixing.bean.UserCompany;
import com.xdlv.weixing.bean.UserValidate;

public interface UserSerivce extends BaseService{

	UserCompany getUserCompanyByPhone(String phone);
	
	UserValidate[] getUserValidateForNotSend();
	
	int updateUserValidateStatus(String phone,String status);

	User userLogin(String name, String pwd);

	List<User> getUsers(int start, int end);

	int getUsersCount();

	void saveUser(User user);

	int batchSaveUserCompany(List<UserCompany> userCompanyList);

	int getUserCompanysCount();

	List<UserCompany> getAllUserCompanys(int start, int end);
}
