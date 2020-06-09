package com.bit.weibo.repository;

import com.bit.weibo.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogRepository extends JpaRepository<BlogEntity,Integer> {
    @Query(value ="select * from blog where userid in :follow order by loadtime desc limit :start,:size",nativeQuery = true)
    public List<BlogEntity> findAll(List<String>follow,int start,int size);

    @Query(value = "select * from blog where weiboid=:weiboid",nativeQuery = true)
    public BlogEntity findById(String weiboid);

    @Query(value = "select * from blog where userid=:userid order by loadtime desc limit :start,:size",nativeQuery = true)
    public List<BlogEntity> findByUserid(String userid,int start,int size);
}
