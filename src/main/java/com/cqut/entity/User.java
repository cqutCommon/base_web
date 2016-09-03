package com.cqut.entity;

import com.cqut.util.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * ClassName
 *
 * @author qiaowei.wu
 * @version 1.0 2015/11/25 16:35
 */
public class User {

    private int id;

    private String userName;

    private String password;

    private String gender;

    private String hobby;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date = new Date();

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return JSON.toJsonString(this);
    }
}
