package com.dzr.study.test.po;

import lombok.Data;

/**
 * @author dingzr
 * @Description 测试类型
 * @ClassName Paper
 * @since 2017/9/15 15:14
 */

@Data
public class Paper {
    private Integer id;
    private String userName;
    private String nickName;
    private String pwd;
    private Integer age;
    private String address;
    private String birthday;
    private Waste waste;
}
