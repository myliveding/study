package com.dzr.study.config;

import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @Auther: dingzr
 * @Date: 2019/5/30 15:53
 * @Description:
 */

@Configuration
@Data
@ConfigurationProperties(prefix = "spring.redisson")
@Validated
public class RedissonConfig {

    @NotNull
    private Integer database;

    @NotNull
    private Integer databaseListen;

    @NotNull
    private String host;

    @NotNull
    private Integer port;

    private String passWord;

    @NotNull
    private Integer timeout;

    @NotNull
    private Integer maxActive;

    @NotNull
    private Integer maxWait;

    @NotNull
    private Integer maxIdle;

    @NotNull
    private Integer minIdle;


    @Bean
    public RedissonClient getRedisson(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + host + ":" + port).setPassword(passWord);
        //添加主从配置
        //config.useMasterSlaveServers().setMasterAddress("").setPassword("").addSlaveAddress(new String[]{"",""});
        return Redisson.create(config);
    }

}
