package com.dzr.study.mapper;

import com.dzr.study.po.Wechat;

public interface WechatMapper {

    int deleteByPrimaryKey(String appId);

    int insert(Wechat record);

    int insertSelective(Wechat record);

    Wechat selectByPrimaryKey(String appId);

    int updateByPrimaryKeySelective(Wechat record);

    int updateByPrimaryKey(Wechat record);
}