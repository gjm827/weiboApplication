package com.bit.weibo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name = "Follow")
@IdClass(PrimaryKey.class)
public class FollowEntity {
    @Id
    private String userid1;
    @Id
    private String userid2;

    public String getUserid1() {
        return userid1;
    }

    public void setUserid1(String userid1) {
        this.userid1 = userid1;
    }

    public String getUserid2() {
        return userid2;
    }

    public void setUserid2(String userid2) {
        this.userid2 = userid2;
    }
}
