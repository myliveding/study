package com.dzr.study.po;

import lombok.Data;

import java.util.Date;

@Data
public class Wechat {

    private String appId;

    private String appSecret;

    private String name;

    private String accessToken;

    private String jsapiTicket;

    private String remark;

    private Date createTime;

    private Date updateTime;

    private Boolean delete;

}