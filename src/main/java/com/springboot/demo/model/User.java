package com.springboot.demo.model;

import lombok.Data;

@Data
public class User {
    private String uid;
    private String uname;
    private String uage;
    public User(String uId,String uName,String uAge){
        uid = uId;
        uname = uName;
        uage = uAge;
    }

}
