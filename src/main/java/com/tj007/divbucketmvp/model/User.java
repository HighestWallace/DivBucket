package com.tj007.divbucketmvp.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

//@Document（collection="user"）
public class User {
    @Id
    private String user_id;

    @Field("psw")
    private String psw;

    @Field("user_name")
    private String user_name;

    @Field("work")
    private String work;

    @Field("avatar")
    private String avatar;

    @Field("age")
    private Integer age;

    @Field("sex")
    private Integer sex;

    @Field("location")
    private String location;

    public String getUser_id() {
        return user_id;
    }

    public String getPsw() {
        return psw;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getWork() {
        return work;
    }

    public Integer getSex() {
        return sex;
    }

    public Integer getAge() {
        return age;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getLocation() {
        return location;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }


    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public void init(){
        this.work = "";
        this.age = 0;
        this.sex = 0;
        this.location = "";
        this.avatar = "https://i.loli.net/2020/01/07/m765yUlHYfQVXeK.jpg";
    }


}
