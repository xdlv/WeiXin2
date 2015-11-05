package com.xdlv.weixing.service;

import com.xdlv.weixing.bean.User;

import java.util.List;

/**
 * Created by exiglvv on 11/4/2015.
 */
public interface FwService extends BaseService{

    User userLogin(String name, String pwd);

    List<User> getUsers(int start, int limit);

    int getUsersCount();

    void saveOrUpdateUser(User user);

    void deleteUserById(Integer id);
}
