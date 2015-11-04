package com.xdlv.weixing.action;

import java.util.ArrayList;
import java.util.List;

import com.xdlv.fw.action.BaseAction;
import com.xdlv.weixing.bean.User;
import com.xdlv.weixing.service.FwService;
import com.xdlv.weixing.service.UserSerivce;

public class FwUserAction extends BaseAction {

    User user;
    List<User> users;
    FwService fwService;

    public String userLogin() {
        User userRecord = fwService.userLogin(user.getName(), user.getPwd());
        if (userRecord != null) {
            users = new ArrayList<User>();
            users.add(userRecord);
        }
        return SUCCESS;
    }

    public String deleteUser() {
        for (int i=0; users != null && i<users.size();i++){
            fwService.deleteUserById(users.get(i).getId());
        }
        return FINISH;
    }

    public String obtainUsers() {
        total = fwService.getUsersCount();
        users = fwService.getUsers(start, start + limit);
        return SUCCESS;
    }

    public String saveUser() {
        fwService.saveUser(user);
        return FINISH;
    }

    public void setFwService(FwService fwService) {
        this.fwService = fwService;
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
