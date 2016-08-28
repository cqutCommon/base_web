package com.cqut.service.user.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.cqut.dao.student.StudentTestDao;
import com.cqut.dao.user.UserMapper;
import com.cqut.entity.StudentTest;
import com.cqut.entity.User;
import com.cqut.service.user.UserService;
import com.cqut.util.MD5Util;
import org.springframework.stereotype.Service;


/**
 * ClassName
 *
 * @author qiaowei.wu
 * @version 1.0 2015/11/30 20:12
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private StudentTestDao studentTestDao;
    @Override
    //@Transactional
    public int insertUser(User user) {
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        userMapper.insertUser(user);
        return userMapper.insertUser(user);
    }

    @Override
    public int deleteUser(User user) {
        return userMapper.deleteUser(user);
    }

    @Override
    public int updateUser(User user) {
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        return userMapper.updateUser(user);
    }

    @Override
    public User getUser(String userName) {
        return userMapper.getUserbyUserName(userName);
    }

    @Override
    public User getUser(String userName, String password) {
        testFind();

        return userMapper.getUser(userName, MD5Util.getMD5(password));
    }
    public void instertTestSave(){
        testSave(1);
        testSave(50);
        testSave(200);
        testSave(1000);
        testSave(2000);
        testSave(5000);
    }
    private void testSave(int size){
        Date date = new Date();
        long start = System.currentTimeMillis();
        try {
            for (int i=0;i<size;i++){
                StudentTest student = new StudentTest();
                student.setName("张三");
                student.setSex("男");
                student.setAge(i);
                student.setPhone("110");
                student.setInfo("ddd");
                student.setRegisterDate(date);

                studentTestDao.insertStudent(student);
            }
            System.out.println("size="+size+" : "+(System.currentTimeMillis()-start)+"ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void testFind(){
        testFind(1);
        testFind(50);
        testFind(200);
        testFind(1000);
        testFind(2000);
        testFind(5000);
    }

    private void testFind(int size){
        long start = System.currentTimeMillis();
        try {
            List<StudentTest> studentTests = studentTestDao.getStudents("and 1=1 LIMIT "+size);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("size="+size+" : "+(System.currentTimeMillis()-start)+"ms");
    }
    @Override
    public List<User> getUsers(String where) {
        return userMapper.getUsers(where);
    }
}
