package com.dzr.study.controller;

import com.dzr.study.framework.BaseController;
import com.dzr.study.framework.mybatis.PageView;
import com.dzr.study.service.RedisExpiredService;
import com.dzr.study.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("test")
@Api(value = "TestController", tags = "test", description = "测试模块")
public class TestController extends BaseController{


    private final RedisExpiredService redisExpiredService;

    @Autowired
    public TestController(RedisExpiredService redisExpiredService) {
        this.redisExpiredService = redisExpiredService;
    }

    @RequestMapping(value = "deleteRedisKey" ,method = RequestMethod.GET)
    @ApiOperation(value = "deleteRedisKey", httpMethod = "GET", response = Map.class,
            notes = "deleteRedisKey", produces = "application/json; charset=utf-8")
    public Map<String, Object> deleteRedisKey(
            @ApiParam(value = "keyHead") @RequestParam(value = "keyHead") String keyHead,
            @ApiParam(value = "primaryKey") @RequestParam(value = "primaryKey") Integer primaryKey) {
        redisExpiredService.deleteRedisKey(keyHead, primaryKey);
        return successResult("");
    }

    @RequestMapping(value = "deleteRedisKeys" ,method = RequestMethod.GET)
    @ApiOperation(value = "模糊的key", httpMethod = "GET", response = Map.class,
            notes = "模糊的key", produces = "application/json; charset=utf-8")
    public Map<String, Object> findUserInfo(
            @ApiParam(value = "模糊的key") @RequestParam(value = "key") String key) {
        redisExpiredService.deleteRedisKeys(key);
        return successResult("");
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "connectDbType" ,method = RequestMethod.GET)
    @ApiOperation(value = "connectDbType", httpMethod = "GET", response = Map.class,
            notes = "connectDbType", produces = "application/json; charset=utf-8")
    public Map<String, Object> connectDbType(
            @ApiParam(value = "key") @RequestParam(value = "key") String key) {
        return successResult(redisTemplate.opsForValue().get(key));
    }


    @RequestMapping(value = "getKey" ,method = RequestMethod.GET)
    @ApiOperation(value = "getKey", httpMethod = "GET", response = Map.class,
            notes = "getKey", produces = "application/json; charset=utf-8")
    public Map<String, Object> getKey(
            @ApiParam(value = "key") @RequestParam(value = "key") String key) {
        return successResult(redisExpiredService.getKey(key));
    }

    @RequestMapping(value = "getKeyForListen" ,method = RequestMethod.GET)
    @ApiOperation(value = "getKeyForListen", httpMethod = "GET", response = Map.class,
            notes = "getKeyForListen", produces = "application/json; charset=utf-8")
    public Map<String, Object> getKeyForListen(
            @ApiParam(value = "key") @RequestParam(value = "key") String key) {
        return successResult(redisExpiredService.getKeyForListen(key));
    }


}
