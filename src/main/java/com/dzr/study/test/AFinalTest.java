package com.dzr.study.test;

/**
 * @Auther: dingzr
 * @Date: 2019/12/27 15:10
 * @Description:
 */
public class AFinalTest {

    public static void main(String[] args) {
        b x1=new b();
        x1.showInformation();
    }
}

class a{
    public final void showInformation() {
        System.out.println("可能是A");
    }
}

final class b extends a{

}