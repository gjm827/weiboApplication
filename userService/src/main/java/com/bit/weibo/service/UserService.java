package com.bit.weibo.service;

import com.bit.weibo.entity.FollowEntity;
import com.bit.weibo.entity.ShowUserEntity;
import com.bit.weibo.entity.UserdetailEntity;
import com.bit.weibo.repository.FollowRepository;
import com.bit.weibo.repository.UserdetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private FollowRepository followRepository;
    @Autowired
    private UserdetailRepository userdetailRepository;

    //按昵称查找用户
    public List<UserdetailEntity> findUserByName(String name)
    {
        List<UserdetailEntity> userdetailEntityList = userdetailRepository.findByUsername(name);
        return userdetailEntityList;
    }

    //获取关注用户列表
    public List<UserdetailEntity> getFollowUser(String userid,int pageNum,int pageSize)
    {
        List<String>follow = followRepository.findAllById(userid);
        List<UserdetailEntity>follow_detail = userdetailRepository.findAllByUserid(follow,pageNum*pageSize,pageSize);
        return follow_detail;
    }

    //关注用户
    public int followUser(String userid1,String userid2)
    {
        FollowEntity newFollow = new FollowEntity(userid1,userid2);
        followRepository.save(newFollow);
        return 1;
    }
    //取关用户
    public int unfollowUser(String userid1, String userid2)
    {
        FollowEntity Follow = new FollowEntity(userid1,userid2);
        followRepository.delete(Follow);
        return 1;
    }

    //获取用户详细信息
    public ShowUserEntity getUserDetail(String userid1,String userid2)
    {
        UserdetailEntity userdetail = userdetailRepository.findByUserid(userid2);
        ShowUserEntity showUserEntity = new ShowUserEntity(userdetail);
        FollowEntity Follow = null;
        Follow = followRepository.find(userid1,userid2);
        if(Follow != null)
            showUserEntity.setFollow(true);
        return showUserEntity;
    }

    //获取个人详细信息
    public UserdetailEntity getMyDetail(String userid)
    {
        UserdetailEntity userdetail = userdetailRepository.findByUserid(userid);
        return userdetail;
    }
}
