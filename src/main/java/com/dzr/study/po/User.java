package com.dzr.study.po;

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

    private Date subscribeTime;

    private String remark;

    private Boolean delete;


}