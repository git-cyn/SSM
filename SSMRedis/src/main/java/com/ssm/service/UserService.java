package com.ssm.service;

import com.ssm.pojo.User;

import java.util.List;

/**
 * user表的操作接口
 * @author YaoQi
 */
public interface UserService {

    public List<User> findUsers(String keyWords);

    public List<User> selectAllUser();

    public User getUser(int id);

    public void insertUser(User user);

    public void deleteUser(int id);

    public void editUser(User user);

}