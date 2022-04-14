package com.dzr.thread;

/**
 * @author dingzr 2021-09-08 16:43
 */
public class ThreadRunning extends Thread{

    public ThreadRunning(String name){
        //重写构造，可以对线程添加名字
        super(name);
    }

    @Override
    public void run() {
        while(true){
            System.out.println("good time");
            //在run方法里，this代表当前线程
            System.out.println(this);
        }
    }

    public static void main(String[] args){
        ThreadRunning threadRuning = new ThreadRunning("1111");
        threadRuning.start();
    }

}
