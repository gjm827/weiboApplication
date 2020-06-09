package com.bit.weibo.controller;

import com.bit.weibo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping(value = "/register")
    public int login(@RequestParam String userid, @RequestParam String password,
                     @RequestParam String username, @RequestParam String sex,
                     @RequestParam String intro,@RequestParam("file") MultipartFile file) {
        return registerService.registerService(userid, password, username, sex, intro,file);
    }
}
