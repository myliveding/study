package com.dzr.study.test;

/**
 * @author dingzr
 * @Description
 * @ClassName InstanceofTest
 * @since 2017/9/15 14:08
 */
public class InstanceofTest {

    public static void main(String[] args) {

        //类C是类B的子类，对象和他的子类进行instanceof判断为false
        A a = null;
        B b = null;
        boolean res;

        System.out.println("instanceoftest test case 1: ------------------");
        res = a instanceof A;
        System.out.println("a instanceof A: " + res);

        res = b instanceof B;
        System.out.println("b instanceof B: " + res);

        System.out.println("instanceoftest test case 2: ------------------");
        a = new B();
        b = new B();

        res = a instanceof A;
        System.out.println("a instanceof A: " + res);

        res = a instanceof B;
        System.out.println("a instanceof B: " + res);

        res = b instanceof A;
        System.out.println("b instanceof A: " + res);

        res = b instanceof B;
        System.out.println("b instanceof B: " + res);

        System.out.println("instanceoftest test case 3: ------------------");
        B b2 = new C();

        res = b2 instanceof A;
        System.out.println("b2 instanceof A: " + res);

        res = b2 instanceof B;
        System.out.println("b2 instanceof B: " + res);

        res = b2 instanceof C;
        System.out.println("b2 instanceof C: " + res);

        System.out.println("instanceoftest test case 4: ------------------");
        B b3 = new B();

        res = b3 instanceof A;
        System.out.println("b3 instanceof A: " + res);

        res = b3 instanceof B;
        System.out.println("b3 instanceof B: " + res);

        res = b3 instanceof C;
        System.out.println("b3 instanceof C: " + res);
    }

}
