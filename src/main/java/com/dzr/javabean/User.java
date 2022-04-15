package com.dzr.javabean;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Integer id;

    private String name;

    private Integer phone;

    private String email;

    private String openid;

    private String neckname;

    private Integer sex;

    private String headimgurl;

    private Boolean subscribe;

    private Integer subscribeTime;

    private String remark;

    private Boolean isDelete;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(String name, Integer phone) {
        this.name = name;
        this.phone = phone;
    }


    public User(Integer id, String name, Integer phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}