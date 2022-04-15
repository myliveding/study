package com.dzr.structure.service;

import com.dzr.framework.mybatis.PageView;
import com.dzr.javabean.User;

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
