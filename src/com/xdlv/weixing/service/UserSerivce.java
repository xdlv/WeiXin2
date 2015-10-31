package com.xdlv.weixing.service;

import java.util.Collection;
import java.util.List;

import com.xdlv.weixing.bean.*;

public interface UserSerivce extends BaseService{

	UserCompany[] getUserCompanyByPhone(String phone);
	
	UserValidate[] getUserValidateForNotSend();
	
	int updateUserValidateStatus(String phone,String status);

	User userLogin(String name, String pwd);

	List<User> getUsers(int start, int end);

	int getUsersCount();

	void saveUser(User user);

	int batchSaveUserCompany(List<UserCompany> userCompanyList);

	int getUserCompanysCount();

	List<UserCompany> getAllUserCompanys(int start, int end);

	void saveUserValidate(UserValidate userValidate);
    
    int deleteUserValidateForUnuse();

    UserValidate getValidateCodeByPhone(String phone, String validateCode);

    void saveUserDz(Userdz userdz);

    Userdz getUserdzByPhone(String phone);

    int batchSaveDzlists(Collection<Dzlist> values);
}