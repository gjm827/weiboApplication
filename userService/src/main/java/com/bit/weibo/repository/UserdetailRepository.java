package com.bit.weibo.repository;

import com.bit.weibo.entity.UserdetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserdetailRepository extends JpaRepository<UserdetailEntity,Integer> {
    @Query(value = "select * from userdetail where username like %:name%",nativeQuery = true)
    public List<UserdetailEntity> findByUsername(String name);

    @Query(value ="select * from userdetail where userid in :follow limit :start,:size",nativeQuery = true)
    public List<UserdetailEntity> findAllByUserid(List<String>follow,int start,int size);

    @Query(value ="select * from userdetail where userid =:userid",nativeQuery = true)
    public UserdetailEntity findByUserid(String userid);
}
