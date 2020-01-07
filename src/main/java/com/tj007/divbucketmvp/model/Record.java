package com.tj007.divbucketmvp.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Record {

    @Field("user_id")
    private String user_id;

    @Field("url")
    private String url;

    @Field("id")
    private String id;

    @Field("value")
    private String value;

    @Field("date")
    private String date;

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public String getUser_id() {
        return user_id;
    }

    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getValue() {
        return value;
    }

}
