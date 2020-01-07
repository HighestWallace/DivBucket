package com.tj007.divbucketmvp.model;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;
public class Manager {
    @Id
    private String manager_id;

    @Field("psw")
    private String psw;

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getManager_id() {
        return manager_id;
    }

    public String getPsw() {
        return psw;
    }

    public void setManager_id(String manager_id) {
        this.manager_id = manager_id;
    }

    
}
