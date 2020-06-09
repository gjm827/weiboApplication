package com.bit.weibo.service;

import com.bit.weibo.entity.UsertableEntity;
import com.bit.weibo.repository.UsertableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UsertableRepository usertableRepository;

    public int loginService(String userid, String password)
    {
        UsertableEntity user =  usertableRepository.findById(userid);
        if (user == null)
            return 0;
        if (user.getPassword().equals(password))
            return 1;
        return -1;

    }
}
