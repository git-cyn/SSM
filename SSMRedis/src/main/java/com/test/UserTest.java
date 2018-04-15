package com.test;

import com.ssm.dao.UserDao;
import com.ssm.pojo.User;
import com.ssm.service.UserService;
import com.ssm.utils.RedisCacheConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 2018/4/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class UserTest {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void getAllUser() throws Exception {
        List<User> lists = userService.selectAllUser();
    }

    @Test
    public void insert() throws Exception {
        User user = new User();
        user.setId(2);
        user.setAge(12);
        user.setPassword("12qw");
        user.setUserName("caoyin");
        userService.insertUser(user);
    }
    @Test
    public void getUser() throws Exception {
      User u = userService.getUser(1);
       System.out.println(u.getUserName());
    }
    @Test
    public void d() throws Exception {
        System.out.println(redisTemplate.opsForValue().get("getUser"));
        User user = new User();
        user.setId(3);
        user.setAge(12);
        user.setPassword("12qw");
        user.setUserName("caoyin");
        redisTemplate.opsForValue().set("get",user);
        User d =(User) redisTemplate.opsForValue().get("get");
        System.out.println(d.getUserName());

    }
}
