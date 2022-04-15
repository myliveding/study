package com.dzr.structure.service;

/**
 * @Auther: dingzr
 * @Date: 2018/12/24 10:40
 * @Description:
 */
public interface RedisExpiredService {

    /**
     * 接收过期的key通知事件，进行分类处理
     *
     * @param channel 渠道
     * @param key     具体的过期key
     */
    void handelExpiredKey(String channel, String key);

    /**
     * 校验key是否过期
     *
     * @param key        redis key
     * @param primaryKey key后面拼接的主键id
     */
    void deleteRedisKey(String key, Integer primaryKey);

    /**
     * 模糊删除不需要的redis key
     */
    void deleteRedisKeys(String key);

    String getKey(String key);

    /**
     * 获取监听数据源的key值
     */
    String getKeyForListen(String key);

}
