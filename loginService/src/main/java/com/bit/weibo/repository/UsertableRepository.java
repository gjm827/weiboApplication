package com.bit.weibo.repository;

import com.bit.weibo.entity.UsertableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsertableRepository extends JpaRepository<UsertableEntity,Integer> {

    @Query(value ="select * from usertable where userid=:userid ",nativeQuery = true)
    public UsertableEntity findById(String userid);
}
