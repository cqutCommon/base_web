package com.cqut.dao.user;

import java.util.List;

import com.cqut.entity.User;
import org.apache.ibatis.annotations.Param;


/**
 * ClassName
 *
 * @author qiaowei.wu
 * @version 1.0 2015/11/30 19:21
 */
public interface UserMapper {

    public int insertUser(User user);

    public int deleteUser(User user);

    public int updateUser(User user);

    public User getUserbyUserName(String userName);

    public User getUser(@Param("userName") String userName, @Param("password") String password);

    public List<User> getUsers(@Param("where") String where);
}
