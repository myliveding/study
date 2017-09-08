package com.dzr.study.mapper;

import com.dzr.study.po.Wechat;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface WechatMapper {

    int deleteByPrimaryKey(String appId);

    int insert(Wechat record);

    int insertSelective(Wechat record);

    Wechat selectByPrimaryKey(String appId);

    int updateByPrimaryKeySelective(Wechat record);

    int updateByPrimaryKey(Wechat record);
}