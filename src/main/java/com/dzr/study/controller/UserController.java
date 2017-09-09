package com.dzr.study.controller;

import com.dzr.study.framework.BaseController;
import com.dzr.study.framework.mybatis.PageView;
import com.dzr.study.po.User;
import com.dzr.study.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description
 * @FileName UserController
 * @Author dingzr
 * @CreateTime 2017/9/9 23:18 九月
 */

@RestController
@RequestMapping("user")
@Api(value = "UserController", tags = "user", description = "用户模块")
public class UserController extends BaseController{

    @Autowired
    UserService userService;

    /**
     * @Title 获取政策包设置第二步的页面展示数据
     * @param id
     * @return
     */
    @RequestMapping(value = "findUserInfo" ,method = RequestMethod.GET)
    @ApiOperation(value = "获取用户数据信息", httpMethod = "GET", response = Map.class,
            notes = "获取用户数据信息", produces = "application/json; charset=utf-8")
    public Map<String, Object> findUserInfo(
            @ApiParam(value = "用户ID") @RequestParam(value = "id", required = true) Integer id){

        return successResult(userService.findUserByPrimaryKey(id));
    }


    @GetMapping("/findUserList")
    @ApiOperation(value = "查询用户列表", response = Map.class,
            notes = "获取用户列表", produces = "application/json; charset=utf-8")
    public Map<String, Object> findUserList(@ApiParam("开始序号") @RequestParam(value = "start", defaultValue = "1", required = false) Integer start,
                                                       @ApiParam("每页展示数量") @RequestParam(value = "length", defaultValue = "10", required = false) Integer length) {
        PageView pageView = userService.findUserList(getPageView(((start / length) + 1) + "", length + ""));

        if (pageView.getRecords() == null || pageView.getRecords().size() == 0) {
            return successResult(pageView.getRowCount(), null);
        }
        return successResult(pageView.getRowCount(), pageView);
    }

}
