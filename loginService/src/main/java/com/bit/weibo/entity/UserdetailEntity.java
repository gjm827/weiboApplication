package com.bit.weibo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name="userdetail")
public class UserdetailEntity {
    @Id
    private String userid;
    private String username;
    private String logo;
    private String sex;
    private String intro;
    private Date registertime;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Date getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }

    public UserdetailEntity() {
    }

    public UserdetailEntity(String userid, String username, String logo, String sex, String intro, Date registertime) {
        this.userid = userid;
        this.username = username;
        this.logo = logo;
        this.sex = sex;
        this.intro = intro;
        this.registertime = registertime;
    }
}
