package com.dzr.study.test;

/**
 * @author dingzr
 * @Description
 * @ClassName HelloA
 * @since 2017/9/22 17:37
 */
public class HelloA extends Hello {

    public HelloA() {
        System.err.println("static HelloA");
    }

    {
        System.err.println("I m HelloA");
    }

    static {
        System.err.println("static HelloA");
    }

    public static void main(String[] args) {
        new HelloA();
    }
}
