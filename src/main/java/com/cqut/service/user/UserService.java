package com.cqut.service.user;

import com.cqut.entity.User;

import java.util.List;



/**
 * ClassName
 *
 * @author qiaowei.wu
 * @version 1.0    2015/11/30 20:11
 */
public interface UserService {

    public int insertUser(User user);

    public int deleteUser(User user);

    public int updateUser(User user);

    public User getUser(String userName);

    public User getUser(String userName, String password);
    void instertTestSave();
    public List<User> getUsers(String where);
}
