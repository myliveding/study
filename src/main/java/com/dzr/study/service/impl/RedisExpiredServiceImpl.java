package com.dzr.study.service.impl;

import com.dzr.study.service.RedisExpiredService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @Auther: dingzr
 * @Date: 2018/12/24 10:38
 * @Description: redis key 过期处理接口
 */

@Service
@SuppressWarnings("unchecked")
public class RedisExpiredServiceImpl implements RedisExpiredService {

//    @Autowired
//    private RedisTemplate redisTemplate;

    private final Logger logger = LoggerFactory.getLogger(RedisExpiredServiceImpl.class);

    /**
     * redis 过期key常量
     * 数据库里面的键事件通知，所有通知以 keyevent@ 为前缀，针对event
     */
    private static final Pattern KEY_EVENT_EXPIRED_TOPIC = Pattern.compile("__keyevent@[1-3]{1}__:expired");

    /**
     * 需要做过期key回调处理key的开始字符串
     */
    private static final String KEY_EVENT_EXPIRED_KEY_START_STRING = "xbz_service:expired_listen:";

    /**
     * 接收过期的key通知事件，进行分类处理
     *
     * @param channel 渠道
     * @param key     具体的过期key
     */
    public void handelExpiredKey(String channel, String key) {
        logger.info("最终接收到的 channel：" + channel + " -- key：" + key);
    }

    /**
     * 校验key是否过期
     * 删除不需要的redis key
     * @param keyHead        redis key头
     * @param primaryKey key后面拼接的主键id
     */
    @Override
    public void deleteRedisKey(String keyHead, Integer primaryKey) {
        if (redisTemplate.hasKey(keyHead + primaryKey)) {
            redisTemplate.delete(keyHead + primaryKey);
        }
    }

    /**
     * 模糊删除不需要的redis key
     */
    @Override
    public void deleteRedisKeys(String key) {
        Set<String> keys = redisTemplate.keys(key);
        if (CollectionUtils.isNotEmpty(keys)) {
            redisTemplate.delete(keys);
        }
    }


    @Autowired
    private RedisTemplate redisTemplate;
    @Resource(name = "redisTemplateForListen")
    private RedisTemplate redisTemplateForListen;

    /**
     * 获取默认数据源的key值
     */
    public String getKey(String key){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        return null == valueOperations.get(key) ? "" : valueOperations.get(key).toString();
    }

    /**
     * 获取监听数据源的key值
     */
    public String getKeyForListen(String key){
        ValueOperations valueOperations =  redisTemplateForListen.opsForValue();
        return null == valueOperations.get(key) ? "" : valueOperations.get(key).toString();
    }


}
