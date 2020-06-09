package com.bit.weibo.service;

import com.bit.weibo.Feign.ImageInterface;
import com.bit.weibo.entity.UserdetailEntity;
import com.bit.weibo.repository.UsertableRepository;
import com.bit.weibo.entity.UsertableEntity;
import com.bit.weibo.repository.UserdetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class RegisterService {
    @Autowired
    private UserdetailRepository userdetailRepository;
    @Autowired
    private UsertableRepository usertableRepository;
    @Autowired
    private ImageInterface imageInterface;

    public int registerService(String userid, String password, String username,
                               String sex, String intro, MultipartFile file)
    {
        if(usertableRepository.findById(userid)!=null)
            return -1;
        UsertableEntity user = new UsertableEntity(userid,password);
        usertableRepository.save(user);
        UserdetailEntity userd = new UserdetailEntity(userid,username,"",sex,intro,new java.util.Date());
        userdetailRepository.save(userd);
        if(file!=null) {
            String image_path = imageInterface.uploadFile(file);
            userd.setLogo(image_path);
            userdetailRepository.save(userd);
        }
        return 1;
    }

}
