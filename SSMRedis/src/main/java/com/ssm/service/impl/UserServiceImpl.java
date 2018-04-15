package com.ssm.service.impl;

import java.util.List;
import javax.annotation.Resource;

import com.ssm.dao.UserDao;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.ssm.pojo.User;

/**
 * userService
 *
 * 缓存机制说明：所有的查询结果都放进了缓存，也就是把MySQL查询的结果放到了redis中去，
 * 然后第二次发起该条查询时就可以从redis中去读取查询的结果，从而不与MySQL交互，从而达到优化的效果，
 * redis的查询速度之于MySQL的查询速度相当于 内存读写速度 /硬盘读写速度
 * @Cacheable("a")注解的意义就是把该方法的查询结果放到redis中去，下一次再发起查询就去redis中去取，存在redis中的数据的key就是a；
 * @CacheEvict(value={"a","b"},allEntries=true) 的意思就是执行该方法后要清除redis中key名称为a,b的数据；
 */
@Service("userService")
@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Cacheable("getAllUsers")
    @Override
    public List<User> selectAllUser() {
        System.out.println("再次查询没有打印这条语句表示缓存成功");
        return this.userDao.selectAllUser();
    }
    @Cacheable("getUser")
    @Override
    public User getUser(int id) {
        return this.userDao.getUser(id);
    }

    @CacheEvict(value= {"getAllUser","getUserById","findUsers"},allEntries=true)//清空缓存，allEntries变量表示所有对象的缓存都清除
    @Override
    public void insertUser(User user) {
        this.userDao.insertUser(user);
    }

    @CacheEvict(value= {"getAllUser","getUserById","findUsers"},allEntries=true)
    @Override
    public void deleteUser(int id) {
        this.userDao.deleteUser(id);
    }

    @Cacheable("findUsers")
    @Override
    public List<User> findUsers(String keyWords) {
        return userDao.findUsers(keyWords);
    }

    @CacheEvict(value= {"getAllUser","getUserById","findUsers"},allEntries=true)
    @Override
    public void editUser(User user) {
        this.userDao.editUser(user);
    }
}