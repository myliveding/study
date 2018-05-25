package com.dzr.study.po;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author dingzr
 * @Description
 * @ClassName DefaultValue
 * @since 2018/5/25 10:49
 */

public class DefaultValue {


    private Integer id;

    @Value("caiwei")
    private String name;

    @Value("20")
    private int num;

    @Value("65.00")
    private double amt;

    public Integer getId() {
        return id;
    }

    @Value("2")
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }
}
