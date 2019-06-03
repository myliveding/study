package com.dzr.study.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @Auther: dingzr
 * @Date: 2019/6/3 11:09
 * @Description:
 */

@Configuration
@Data
@ConfigurationProperties(prefix = "spring.redis")
@Validated
public class RedisConfig {

    @NotNull
    private int database;

    /**
     * 等待节点回复命令的时间。该时间从命令发送成功时开始计时
     *      
     */
    @NotNull
    private int timeout;

    private String password;

    @NotNull
    private String mode;

    /**
     * 池配置
     *      
     */
    @NotNull
    private RedisPoolConfig pool;

    /**
     * 单机信息配置
     *      
     */
    private RedisSingleConfig single;

    /**
     * 集群 信息配置
     *      
     */
    private RedisClusterConfig cluster;

    /**
     * 哨兵配置
     *      
     */
    private RedisSentinelConfig sentinel;


}
