package com.ssm.pojo;

import java.io.Serializable;

/**
 * User实体类对应数据库中的tb_user表
 * 
 * @author YaoQi
 * 要想使用redis存对象，一定要让实体类实现Serializable接口，否则会报错。
 */
public class User implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -5244288298702801619L;

    private Integer id;
    private Integer age;
    private String password;
    private String userName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}