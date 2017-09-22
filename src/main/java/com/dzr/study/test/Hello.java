package com.dzr.study.test;

/**
 * @author dingzr
 * @Description
 * @ClassName Hello
 * @since 2017/9/22 17:36
 */
public class Hello {

    public Hello() {
        System.err.println("static Hello");
    }

    {
        System.err.println("I m Hello");
    }

    static {
        System.err.println("static Hello");
    }
}
