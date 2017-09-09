package com.dzr.study.service.impl;

import com.dzr.study.framework.exception.ApiException;
import com.dzr.study.framework.mybatis.PageView;
import com.dzr.study.mapper.UserMapper;
import com.dzr.study.po.User;
import com.dzr.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @FileName UserServiceImpl
 * @Author dingzr
 * @CreateTime 2017/9/9 23:12 九月
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    @Override
    public User findUserByPrimaryKey(Integer id){
        if(null == id){
            throw new ApiException(20102, "用户ID");
        }
        return userMapper.selectByPrimaryKey(id);
    };

    /**
     * 查询用户列表
     * @return
     */
    @Override
    public PageView findUserList(PageView pageView){
        Map<String, Object> map = new HashMap<>();
        map.put("paging", pageView);
        pageView.setRecords(userMapper.findUserList(map));
        return pageView;
    };


}
