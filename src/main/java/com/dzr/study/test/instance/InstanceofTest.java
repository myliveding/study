package com.dzr.study.test.instance;

/**
 * @author dingzr
 * @Description java 中的instanceof 运算符是用来在运行时指出对象是否是特定类的一个实例。
 * instanceof通过返回一个布尔值来指出，这个对象是否是这个特定类或者是它的子类的一个实例。
 * @ClassName InstanceofTest
 * @since 2017/9/15 14:08
 */
public class InstanceofTest {

    /**
     * 子类是父类得实例，但是父类不是子类得实例
     * null 比较结果都为假
     *
     * @param args
     */

    public static void main(String[] args) {

        //B是A得实现类
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
