package com.dzr.study.service;

import com.dzr.study.framework.mybatis.PageView;
import com.dzr.study.po.User;

import java.util.List;

/**
 * @author dingzr
 * @Description
 * @ClassName UserService
 * @since 2017/9/8 17:24
 */
public interface UserService {

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    User findUserByPrimaryKey(Integer id);

    /**
     * 查询用户列表
     * @return
     */
    PageView findUserList(PageView pageView);

}
