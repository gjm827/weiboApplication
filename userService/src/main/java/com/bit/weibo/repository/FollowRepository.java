package com.bit.weibo.repository;

import com.bit.weibo.entity.FollowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FollowRepository extends JpaRepository<FollowEntity,Integer> {

    @Query(value ="select userid2 from follow where userid1=:userid1 ",nativeQuery = true)
    public List<String> findAllById(String userid1);

    @Query(value ="select * from follow where userid1=:userid1 and userid2=:userid2 ",nativeQuery = true)
    public FollowEntity find(String userid1,String userid2);
}
