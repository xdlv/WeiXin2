package com.xdlv.weixing.action;

import java.util.ArrayList;
import java.util.List;

import com.xdlv.fw.action.BaseAction;
import com.xdlv.weixing.bean.User;
import com.xdlv.weixing.service.UserSerivce;

public class FwUserAction extends BaseAction {

	User user;
	List<User> users;
	UserSerivce userService;
	
	public String userLogin(){
		User userRecord = userService.userLogin(user.getName(), user.getPwd());
		if (userRecord != null){
			users = new ArrayList<User>();
			users.add(userRecord);
		}
		return SUCCESS;
	}
	
	public String obtainUsers(){
		total = userService.getUsersCount();
		users = userService.getUsers(start, start + limit);
		return SUCCESS;
	}
	
	public String saveUser(){
		userService.saveUser(user);
		return FINISH;
	}
	
	
	public void setUserService(UserSerivce userService) {
		this.userService = userService;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
