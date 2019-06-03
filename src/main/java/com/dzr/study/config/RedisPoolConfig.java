package com.dzr.study.config;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @Auther: dingzr
 * @Date: 2019/6/3 17:22
 * @Description:
 */

@Data
@ToString
public class RedisPoolConfig {

    @NotNull
    private int maxIdle;

    @NotNull
    private int minIdle;

    @NotNull
    private int maxActive;

    @NotNull
    private int maxWait;

    @NotNull
    private int connTimeout;

    @NotNull
    private int soTimeout;

    /**
     * 池大小
     */
    @NotNull
    private int size;

}
