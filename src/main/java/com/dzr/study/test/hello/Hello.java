package com.dzr.study.test.hello;

/**
 * @author dingzr
 * @Description
 * @ClassName Hello
 * @since 2017/9/22 17:36
 */
public class Hello {

    private static Hello a = new Hello();

    public Hello() {
        System.err.println("父类 构造方法 static Hello");
    }

    {
        System.err.println("父类 非静态代码块 I'm Hello");
    }

    static {
        System.err.println("父类 静态代码块 static Hello");
    }
}
