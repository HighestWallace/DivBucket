package com.tj007.divbucketmvp.model;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

public class WebMonitor {
    @Field("user_id")
    private String user_id;

    @Field("url")
    private String url;

    @Field("remark")
    private String remark;

    @Field("cookie")
    private String cookie;

    @Field("tag")
    private ArrayList<String> tag;

    @Field("path")
    private ArrayList<String> path;

    @Field("isActive")
    private boolean isActive;

    public String getUrl() {
        return url;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public ArrayList<String> getTag() {
        return tag;
    }

    public ArrayList<String> getPath() {
        return path;
    }

    public String getCookie() {
        return cookie;
    }

    public String getRemark() {
        return remark;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public void setTag(ArrayList<String> tag) {
        this.tag = tag;
    }

    public void setPath(ArrayList<String> path) {
        this.path = path;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }
}
