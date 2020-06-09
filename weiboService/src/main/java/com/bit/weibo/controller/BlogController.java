package com.bit.weibo.controller;

import com.bit.weibo.FeignInterface.ImageServiceInterface;
import com.bit.weibo.entity.BlogEntity;
import com.bit.weibo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private ImageServiceInterface imageServiceInterface;
    //获取关注用户微博
    @GetMapping("/getFollowWeibo")
    public List<BlogEntity> getFollowWeibo(@RequestParam String userid,
    @RequestParam int pageNum,@RequestParam int pageSize)
    {
        return blogService.getFollowWeibo(userid,pageNum,pageSize);
    }

    //获取用户历史微博
    @GetMapping("/getUserWeibo")
    public List<BlogEntity> getUserWeibo(@RequestParam String userid,
    @RequestParam int pageNum,@RequestParam int pageSize) { return blogService.getUserWeibo(userid,pageNum,pageSize);}

    //转发微博
    @GetMapping("/forwardWeibo")
    public int forwardBlog(@RequestParam String userid,@RequestParam String username,
                           @RequestParam String weiboid,@RequestParam String forward_content)
    {
        return blogService.forwardBlog(userid,username,weiboid,forward_content);
    }

    //发微博
    @PostMapping("/publishWeibo")
    public int publishBlog(@RequestParam String userid,@RequestParam String username,
                           @RequestParam String content,@RequestParam("file") MultipartFile file)
    {
        //return imageServiceInterface.uploadFile(file);
        return blogService.publishBlog(userid,username,content,file);
    }

    //点赞
    @GetMapping("/dianZan")
    public int dianZan(@RequestParam String weiboid)
    {
        return blogService.dianZan(weiboid);
    }
}
