package com.test.dao;

import com.test.entity.User;

/**
 * DAO接口,mybatis动态完成Impl
 */
public interface UserDao {

    User getUserById(Integer id);

}
