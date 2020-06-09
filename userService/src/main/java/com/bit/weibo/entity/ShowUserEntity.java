package com.bit.weibo.entity;

import java.util.Date;

public class ShowUserEntity {
    private String userid;
    private String username;
    private String logo;
    private String sex;
    private String intro;
    private Date registertime;
    private boolean isFollow;

    public ShowUserEntity(){}
    public ShowUserEntity(UserdetailEntity u)
    {
        this.userid = u.getUserid();
        this.username = u.getUsername();
        this.logo = u.getLogo();
        this.sex = u.getSex();
        this.intro = u.getIntro();
        this.registertime = u.getRegistertime();
    }
    public boolean isFollow() {
        return isFollow;
    }

    public void setFollow(boolean follow) {
        isFollow = follow;
    }
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
}
