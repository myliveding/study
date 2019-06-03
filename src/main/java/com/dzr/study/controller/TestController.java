package com.dzr.study.controller;

import com.dzr.study.framework.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("test")
@Api(value = "TestController", tags = "test", description = "测试模块")
public class TestController extends BaseController{


    @RequestMapping(value = "deleteRedisKey" ,method = RequestMethod.GET)
    @ApiOperation(value = "deleteRedisKey", httpMethod = "GET", response = Map.class,
            notes = "deleteRedisKey", produces = "application/json; charset=utf-8")
    public Map<String, Object> deleteRedisKey(
            @ApiParam(value = "keyHead") @RequestParam(value = "keyHead") String keyHead,
            @ApiParam(value = "primaryKey") @RequestParam(value = "primaryKey") Integer primaryKey) {

        return successResult("");
    }


}
