package com.dzr.study.test.hello;

/**
 * @author dingzr
 * @Description
 * @ClassName HelloA
 * @since 2017/9/22 17:37
 */
public class HelloA extends Hello {

    private static HelloA a = new HelloA();

    public HelloA() {
        System.err.println("子类 构造方法 static HelloA");
    }

    {
        System.err.println("子类 非静态代码块 I’m HelloA");
    }

    //只被初始化一次
    static {
        System.err.println("子类 静态代码块 static HelloA");
    }

    public static void main(String[] args) {
        new HelloA();
    }

    /**
     *  总结:
     *  对象的初始化顺序:首先执行父类静态的内容，父类静态的内容执行完毕后，接着去执行子类的静态的内容，
     *  当子类的静态内容执行完毕之后，再去看父类有没有非静态代码块，如果有就执行父类的非静态代码块，
     *  父类的非静态代码块执行完毕，接着执行父类的构造方法；父类的构造方法执行完毕之后，
     *  它接着去看子类有没有非静态代码块，如果有就执行子类的非静态代码块。子类的非静态代码块执行完毕再去执行子类的构造方法。
     *  总之一句话，静态代码块内容先执行，接着执行父类非静态代码块和构造方法，然后执行子类非静态代码块和构造方法。
     *
     *  注意:子类的构造方法，不管这个构造方法带不带参数，默认的它都会先去寻找父类的不带参数的构造方法。
     *  如果父类没有不带参数的构造方法，那么子类必须用supper关键子来调用父类带参数的构造方法，否则编译不能通过。
     *
     *  如果类已经被加载：
     *  则静态代码块和静态变量就不用重复执行，再创建类对象时，只执行与实例相关的变量初始化和构造方法。
     */

    /**
     *
     *
     *
     *
     *
     */

}
