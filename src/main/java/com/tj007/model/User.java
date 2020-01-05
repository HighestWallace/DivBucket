package com.tj007.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.bson.Document;

//@Document（collection="user"）
public class User {
    @Id
    private String user_id;

    @Field("psw")
    private String psw;
    @Field("binding_email")
    private String binding_email;
    @Field("user_name")
    private String user_name;
    @Field("work")
    private String work;

    public String getUser_id() {
        return user_id;
    }

    public String getPsw() {
        return psw;
    }

    public String getBinding_email() {
        return binding_email;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getWork() {
        return work;
    }
}
