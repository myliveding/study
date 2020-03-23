package com.dzr.study.test;

/**
 * @Auther: dingzr
 * @Date: 2020/3/12 16:32
 * @Description:
 */
public class Add {

    static{
//         x = 5;
        int x=5;
    }
    static int x,y;
    public static void main(String args[]){
        x--; // x = -1
        myMethod( );
        //y = 0  x = 1
        System.out.println(x + y + ++x);// 3
    }

    public static void myMethod( ){
        //X++ 在运算中先参与运算在自增 y = (x++) + (++x)
        // 先变成 y = (-1++) + (++x); x = 0; y = -1 + 1; x = 1; y = 0;
        y=x++ + ++x;
    }

}
