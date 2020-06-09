package com.bit.weibo.controller;

import com.bit.weibo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @GetMapping(value="/login")
    public int login(@RequestParam("userid") String userid,@RequestParam("password") String password)
    {
       return loginService.loginService(userid,password);
    }

}
