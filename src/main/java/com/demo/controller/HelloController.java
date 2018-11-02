package com.demo.controller;

import com.demo.entity.UserInfo;
import com.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/userTest")
    @ResponseBody
    public String userTest(Integer id){
        UserInfo userInfo = userInfoService.selectByPrimaryKey(id);
        if(userInfo != null){
            return "Hello " + userInfo.getUserName();
        }
        return "not found";
    }

    @RequestMapping("/index")
    public String index(){
        return "login";
    }

}
