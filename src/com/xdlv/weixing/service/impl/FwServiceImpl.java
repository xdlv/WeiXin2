package com.xdlv.weixing.service.impl;

import com.xdlv.fw.FwException;
import com.xdlv.fw.I18n;
import com.xdlv.weixing.bean.User;
import com.xdlv.weixing.bean.UserMapper;
import com.xdlv.weixing.service.FwService;

import java.util.List;

/**
 * Created by exiglvv on 11/4/2015.
 */
public class FwServiceImpl extends BaseServiceImpl implements FwService {
    UserMapper userMapper;
    @Override
    public User userLogin(String name, String pwd) {
        User user = userMapper.selectUserByName(name);
        if (user != null && pwd.equals(I18n.MD5(user.getPwd()))) {
            return user;
        } else {
            throw new FwException("user don't exist");
        }
    }

    @Override
    public void saveOrUpdateUser(User user) {
        if (user.getId() != null){
            userMapper.updateByPrimaryKey(user);
        } else {
            user.setId(getPrimaryKey("t_user"));
            userMapper.insert(user);
        }
    }

    @Override
    public List<User> getUsers(int start, int limit) {
        return userMapper.selectUsers(start, limit);
    }

    @Override
    public int getUsersCount() {
        return userMapper.selectUserCount();
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void deleteUserById(Integer id) {
        userMapper.deleteUserByKey(id);
    }
}
