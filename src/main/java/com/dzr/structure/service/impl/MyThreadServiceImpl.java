package com.dzr.structure.service.impl;

/**
 * @author dingzr
 * @Description 线程测试类
 * @ClassName MyThreadServiceImpl
 * @since 2018/10/11 14:33
 */
public class MyThreadServiceImpl {

    public synchronized static void methodMain(String param){
        System.err.println("主方法执行。。。start---" + param);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        methodMainSec();
        System.err.println("主方法执行。。。end---" + param);
    }

    private static void methodMainSec(){
        System.err.println("被调用方法执行。。。");
    }


    public static void main(String[] args) {
        for (int i = 0; i < 2 ; i++) {
            methodMain(i + "-循环");
        }
    }

}
