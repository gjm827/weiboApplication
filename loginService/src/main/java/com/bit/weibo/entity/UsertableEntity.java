package com.bit.weibo.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="usertable")
public class UsertableEntity {
    @Id
    private String userid;
    private String password;

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserid() {
        return userid;
    }

    public String getPassword() {
        return password;
    }
    public UsertableEntity(){}
    public UsertableEntity(String userid,String password)
    {
        this.userid = userid;
        this.password = password;
    }
}
