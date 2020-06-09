package com.bit.weibo.controller;

import com.bit.weibo.entity.FollowEntity;
import com.bit.weibo.entity.ShowUserEntity;
import com.bit.weibo.entity.UserdetailEntity;
import com.bit.weibo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //按昵称查找用户
    @GetMapping(value="/findUserByName")
    public List<UserdetailEntity> findUserByName(@RequestParam String name)
    {
        return userService.findUserByName(name);
    }

    //获取关注用户列表
    @GetMapping(value = "/getFollowUser")
    public List<UserdetailEntity> getFollowUser(@RequestParam String userid,
                                                @RequestParam int pageNum,@RequestParam int pageSize)
    {
        return userService.getFollowUser(userid,pageNum,pageSize);
    }

    //关注用户
    @GetMapping(value = "/followUser")
    public int followUser(@RequestParam String userid1,@RequestParam String userid2)
    {
        return userService.followUser(userid1,userid2);
    }

    //取关用户
    @GetMapping(value = "/unfollowUser")
    public int unfollowUser(@RequestParam String userid1,@RequestParam String userid2)
    {
        return userService.unfollowUser(userid1,userid2);
    }

    //获取用户详细信息
    @GetMapping(value = "/getUserDetail")
    public ShowUserEntity getUserDetail(@RequestParam String userid1, @RequestParam String userid2)
    {
        return userService.getUserDetail(userid1,userid2);
    }

    //获取个人详细信息
    @GetMapping(value = "/getMyDetail")
    public UserdetailEntity getMyDetail(@RequestParam String userid)
    {
        return userService.getMyDetail(userid);
    }
}
