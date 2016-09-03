package com.cqut.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cqut.entity.User;
import com.cqut.service.user.UserService;
import com.cqut.util.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by geely on 2015/11/22.
 */
@Controller
public class TestController {
    @Resource
    private UserService userService;
    //todo http://localhost:8080/baseType.do?xage=10
    @RequestMapping(value = "baseType.do")
    @ResponseBody
    public String baseType(@RequestParam("xage") int age){
        return "age:"+age;
    }

    //todo http://localhost:8080/baseType2.do?age=10
    @RequestMapping(value = "baseType2.do")
    @ResponseBody
    public String baseType2(Integer age){
        return "age:"+age;
    }

    //todo http://localhost:8080/array.do?name=Tom&name=Lucy&name=Jim
    @RequestMapping(value = "array.do")
    @ResponseBody
    public String array(String[] name){
        StringBuilder sbf = new StringBuilder();
        for(String item : name){
            sbf.append(item).append(" ");
        }
        return sbf.toString();
    }

    //todo http://localhost:8080/object.do?name=Tom&age=10
    //TODO http://localhost:8080/object.do?name=Tom&age=10&contactInfo.phone=10086
    //TODO http://localhost:8080/object.do?user.name=Tom&admin.name=Lucy&age=10
//    @RequestMapping(value = "object.do")
//    @ResponseBody
//    public String object(User user, Admin admin){
//        return user.toString()+" "+admin.toString();
//    }
//
//    @InitBinder("user")
//    public void initUser(WebDataBinder binder){
//        binder.setFieldDefaultPrefix("user.");
//    }
//    @InitBinder("admin")
//    public void initAdmin(WebDataBinder binder){
//        binder.setFieldDefaultPrefix("admin.");
//    }
//
//    //TODO http://localhost:8080/list.do?users[0].name=Tom&users[1].name=Lucy
//    //TODO http://localhost:8080/list.do?users[0].name=Tom&users[1].name=Lucy&users[20].name=Jim
//    @RequestMapping(value = "list.do")
//    @ResponseBody
//    public String list(UserListForm userListForm){
//        return "listSize:"+userListForm.getUsers().size() + "  " + userListForm.toString();
//    }
//
//    //TODO http://localhost:8080/set.do?users[0].name=Tom&users[20].name=Lucy
//    @RequestMapping(value = "set.do")
//    @ResponseBody
//    public String set(UserSetForm userSetForm){
//        return userSetForm.toString();
//    }
//
//    //TODO http://localhost:8080/map.do?users['X'].name=Tom&users['X'].age=10&users['Y'].name=Lucy
//    @RequestMapping(value = "map.do")
//    @ResponseBody
//    public String map(UserMapForm userMapForm){
//        return userMapForm.toString();
//    }


//    {
//        "name": "Jim",
//            "age": 16,
//            "contactInfo": {
//                "address": "beijing",
//                "phone": "10010"
//              }
//    }
    //application/json
    @RequestMapping(value = "json2.do")
    @ResponseBody
    public User json(@RequestBody User user){
        return user;
    }


    @RequestMapping(value = "date2.do")
    @ResponseBody
     public String date2(Date date2){
        return date2.toString();
    }

    @RequestMapping(value = "/subject/{subjectId}/")
    @ResponseBody
    public String subject(@PathVariable("subjectId") String subjectId){
        return subjectId.toString();
    }


    @RequestMapping(value = "user2.do",method = RequestMethod.GET)
    @ResponseBody
    public User getUser2(){
        return userService.getUser("dd");
    }



    @RequestMapping(value = "user.do",method = RequestMethod.GET)
    @ResponseBody
    public String getUser(){
        return JSON.toJsonString(userService.getUser("dd"));
    }

    @RequestMapping(value = "user.do",method = RequestMethod.PUT)
    @ResponseBody
    public String putUser(){
        return "mapping is user.do ,but I'm putUser";
    }


}
