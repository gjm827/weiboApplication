package com.bit.weibo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Entity(name = "blog")
public class BlogEntity {
    @Id
    private String weiboid;
    private String originalid;
    private Timestamp loadtime;
    private String content;
    private String forward_content;
    private String picture;
    private String userid;
    private String username;
    private int zan;
    private int forward;
    private int comment;
    public BlogEntity(){}
    public BlogEntity(String userid,String username)
    {
        this.zan = 0;
        this.comment = 0;
        this.forward = 0;
        Timestamp now = new Timestamp(System.currentTimeMillis());
        String tsStr = "";
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            tsStr = sdf.format(now);
            //System.out.println(tsStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.loadtime = now;
        this.setUserid(userid);
        this.setUsername(username);
        this.setWeiboid(userid+tsStr);
        this.setLoadtime(now);
    }
    public String getWeiboid() {
        return weiboid;
    }

    public void setWeiboid(String weiboid) {
        this.weiboid = weiboid;
    }

    public String getOriginalid() {
        return originalid;
    }

    public void setOriginalid(String originalid) {
        this.originalid = originalid;
    }

    public Timestamp getLoadtime() {
        return loadtime;
    }

    public void setLoadtime(Timestamp loadtime) {
        this.loadtime = loadtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getForward_content() {
        return forward_content;
    }

    public void setForward_context(String forward_content) {
        this.forward_content = forward_content;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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

    public int getZan() {
        return zan;
    }

    public void setZan(int zan) {
        this.zan = zan;
    }

    public int getForward() {
        return forward;
    }

    public void setForward(int forward) {
        this.forward = forward;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }
}
