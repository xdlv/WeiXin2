package com.xdlv.weixing.service.impl;

import java.util.List;

import com.xdlv.weixing.bean.*;
import com.xdlv.weixing.service.UserSerivce;

public class UserSerivceImpl extends BaseServiceImpl implements UserSerivce{

	UserCompanyMapper userCompanyMapper;
	UserValidateMapper userValidateMapper;
	UserdzMapper userdzMapper;
	UserMapper userMapper;
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
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User userLogin(String name, String pwd) {
		return userMapper.selecUserByNameAndPwd(name, pwd);
	}
	@Override
	public void saveUser(User user) {
		user.setId(getPrimaryKey("t_user"));
		userMapper.insert(user);
	}

	@Override
	public List<User> getUsers(int start, int end) {
		return userMapper.selectUsers(start, end);
	}
	@Override
	public int getUsersCount() {
		return userMapper.selectUserCount();
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
}
