package com.bit.weibo.service;

import com.bit.weibo.FeignInterface.ImageServiceInterface;
import com.bit.weibo.entity.BlogEntity;
import com.bit.weibo.entity.FollowEntity;
import com.bit.weibo.repository.BlogRepository;
import com.bit.weibo.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private FollowRepository followRepository;
    @Autowired
    private ImageServiceInterface imageServiceInterface;

    //获取关注人微博，按时间降序
    public List<BlogEntity> getFollowWeibo(String userid,int pageNum,int pageSize)
    {
        List<String>follow = followRepository.findAllById(userid);
        List<BlogEntity> blogEntityList= blogRepository.findAll(follow,pageNum*pageSize,pageSize);
        return blogEntityList;
    }

    //获取某个用户的微博，按时间降序
    public List<BlogEntity> getUserWeibo(String userid,int pageNum,int pageSize)
    {
        List<BlogEntity> blogEntityList = blogRepository.findByUserid(userid,pageNum*pageSize,pageSize);
        return blogEntityList;
    }

    //转发微博
    public int forwardBlog(String userid,String username,String weiboid,String forward_content)
    {
        BlogEntity blog = blogRepository.findById(weiboid);
        BlogEntity newblog = new BlogEntity(userid,username);
        if(blog.getWeiboid().equals(blog.getOriginalid()))
            newblog.setForward_context(forward_content);
        else {
            String new_context = forward_content+"//@" + blog.getUsername() + ":" + blog.getForward_content();
            newblog.setForward_context(new_context);
        }
        newblog.setPicture(blog.getPicture());
        newblog.setOriginalid(blog.getOriginalid());
        newblog.setContent(blog.getContent());
        blog.setForward(blog.getForward()+1);
        blogRepository.save(blog);
        blogRepository.save(newblog);
        return 1;
    }

    //发微博
    public int publishBlog(String userid, String username, String content, MultipartFile file)
    {
        BlogEntity newblog = new BlogEntity(userid,username);
        newblog.setOriginalid(newblog.getWeiboid());
        newblog.setContent(content);
        blogRepository.save(newblog);
        if(file!=null) {
            String image_path = imageServiceInterface.uploadFile(file);
            newblog.setPicture(image_path);
            blogRepository.save(newblog);
        }
        return  1;
    }

    //点赞
    public int dianZan(String weiboid)
    {
        BlogEntity blog = blogRepository.findById(weiboid);
        blog.setZan(blog.getZan()+1);
        blogRepository.save(blog);
        return 1;
    }

}
