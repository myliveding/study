package com.dzr.study.config;

import lombok.Data;
import lombok.ToString;

/**
 * @Auther: dingzr
 * @Date: 2019/6/3 17:26
 * @Description:
 */

@Data
@ToString
public class RedisSentinelConfig {

    /**
     * 哨兵master 名称    
     */
    private String master;

    /**
     * 哨兵节点
     */
    private String nodes;

    /**
     * 哨兵配置
     */
    private boolean masterOnlyWrite;

    /**
     *      
     */
    private int failMax;
}
