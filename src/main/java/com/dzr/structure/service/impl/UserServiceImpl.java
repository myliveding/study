package com.dzr.structure.service.impl;

import com.dzr.framework.exception.ApiException;
import com.dzr.framework.mybatis.PageView;
import com.dzr.structure.mapper.UserMapper;
import com.dzr.javabean.User;
import com.dzr.structure.service.UserService;
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

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 获取用户信息
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
     */
    @Override
    public PageView findUserList(PageView pageView){
        Map<String, Object> map = new HashMap<>();
        map.put("paging", pageView);
        pageView.setRecords(userMapper.findUserList(map));
        return pageView;
    };


}
