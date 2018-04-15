package com.test.entity;

/**
 * 实体类：属性对应数据库表的字段
 */
public class User {

    private Integer id;
    private Integer age;
    private String password;
    private String userName;


    public User(Integer id , Integer age , String password, String userName) {
        this.id = id;
        this.age = age;
        this.password = password;
        this.userName = userName;

    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
