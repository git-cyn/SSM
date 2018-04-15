package com.ssm.dao;

import com.ssm.pojo.User;

import java.util.List;

public interface UserDao {

    public List<User> findUsers(String keyWords);

    public List<User> selectAllUser();

    public User getUser(int id);

    public void insertUser(User user);

    public void deleteUser(int id);

    public void editUser(User user);
}