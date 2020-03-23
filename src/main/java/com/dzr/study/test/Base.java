package com.dzr.study.test;

/**
 * @Auther: dingzr
 * @Date: 2020/3/12 16:20
 * @Description:
 */
public class Base {

    private String baseName = "base";
    public Base(){
        callName();
    }

    public void callName(){
        System. out. println(baseName);
    }

    static class Sub extends Base{
        private String baseName = "sub";
        public void callName()
        {
            System. out. println (baseName) ;
        }
    }

    public static void main(String[] args){
        Base b = new Sub();
    }

    /**
     *   链接：https://www.nowcoder.com/questionTerminal/c2bfb1512dfa4a7eab773a5871a52402?mutiTagIds=134&orderByHotValue=1
         解题要点：
         1、静态内部类是不依赖于外部类的，静态内部类中只能访问外部类的静态成员（变量和方法），此处的内部类没有意义，静态非静态，只是在构造内部类对象时写法不同，但程序执行没有差异；
         2、继承关系类的加载顺序（不考虑静态属性和静态代码的情况下）：初始化父类的非静态成员属性或非静态代码块-->执行父类的构造函数-->初始化子类的非静态成员属性或非静态代码块-->执行子类的构造函数；本题中首先执行父类的 privateString baseName = "base";，然后执行父类的构造函数；执行过程中调用callName()方法；
         3、多态：父类引用指向子类对象，父类引用b指向了子类对象new Sub();多态中，实际执行时如果子类重写了父类的方法，则执行子类的方法；
         4、根据多态的原则，再执行父类的构造方法中调用callName方法，实际调用的是子类的callName方法，子类的callName方法输出的是属性baseName的值，可是这时子类的baseName属性还没有被初始化，因为此时仍处在父类构造函数执行过程中。
     */
    /**
     *
     1.首先，需要明白类的加载顺序。
     (1) 父类静态代码块(包括静态初始化块，静态属性，但不包括静态方法)
     (2) 子类静态代码块(包括静态初始化块，静态属性，但不包括静态方法 )
     (3) 父类非静态代码块( 包括非静态初始化块，非静态属性 )
     (4) 父类构造函数
     (5) 子类非静态代码块 ( 包括非静态初始化块，非静态属性 )
     (6) 子类构造函数
     其中：类中静态块按照声明顺序执行，并且(1)和(2)不需要调用new类实例的时候就执行了(意思就是在类加载到方法区的时候执行的)
     2.其次，需要理解子类覆盖父类方法的问题，也就是方法重写实现多态问题。
     Base b = new Sub();它为多态的一种表现形式，声明是Base,实现是Sub类， 理解为 b 编译时表现为Base类特性，运行时表现为Sub类特性。
     当子类覆盖了父类的方法后，意思是父类的方法已经被重写，题中 父类初始化调用的方法为子类实现的方法，子类实现的方法中调用的baseName为子类中的私有属性。
     由1.可知，此时只执行到步骤4.,子类非静态代码块和初始化步骤还没有到，子类中的baseName还没有被初始化。所以此时 baseName为空。 所以为null。
     *
     *
     *
     *
     *
     */

}
