package com.dzr.study.test;

import com.dzr.study.po.User;

import java.util.ArrayList;
import java.util.function.*;

/**
 * @Auther: dingzr
 * @Date: 2020/3/10 14:08
 * @Description: lambda 表达式学习
 */
public class Lambda {
    public static void main(String[] args) {
        //https://www.cnblogs.com/kingsonfu/p/11022980.html

        /************lambda用法begin************/
        //匿名内部类写法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("内部类写法");
            }
        }).start();

        //lambda 写法
        new Thread(() -> System.out.println("lambda写法")).start();


        /************lambda用法end************/

        /************构造函数begin************/
        //ClassName::instanceMethod模式

        //> Supplier<T>
        //没有入参，返回T类型结果，使用get方法获取返回结果
        Supplier<User> us = User::new;
        //等效
        Supplier<User> us2 = () -> new User();
        //获取对象
        User user = us.get();


        //> Function<T, R>
        //接受一个入参T，返回R类型对象，使用apply方法获取方法执行的内容

        //一个参数,参数类型不同则会编译出错
        Function<Integer, User> uf = id -> new User(id);
        //或加括号
        Function<Integer, User> uf2 = (id) -> new User(id);
        //等效
        Function<Integer, User> uf3 = (Integer id) -> new User(id);
        User apply = uf.apply(61888);
        System.err.println(apply.getId());

//        User userT = new User(88, "bb");
//        Function<User, String> uft = u -> u.getName();
//        String name = uft.apply(userT);
//        System.out.println(name);

        //ClassName::staticMethod  类的静态方法：把表达式的参数值作为staticMethod方法的参数
        Function<Integer, String> sf = String::valueOf;
        //等效
        Function<Integer, String> sf2 = (x) -> String.valueOf(x);
        String apply1 = sf.apply(61888);

        //两个参数
        BiFunction<Integer, String, User> ubf = (id, name) -> new User(id, name);
        User happy = ubf.apply(618, "狂欢happy");
        System.err.println(happy.toString());
        /************构造函数end************/



        /************方法引用begin************/
        //> Consumer<T>
        //接受一个参数T，没有返回值，使用accept方法对参数执行操作
        //objectName::instanceMethod，对象实例方法：把表达式的参数值作为instanceMethod方法的参数
        Consumer<String> sc = System.out::println;
        //等效
        Consumer<String> sc2 = (x) -> System.out.println(x);
        sc.accept("618, 狂欢happy accept");

        Consumer<String> consumer = ele -> System.out.println(10);
        //num = num + 2;
        consumer.accept("hello");

        //> Predicate<T>
        //接受一个入参，返回结果为true或者false,使用test方法进行测试并返回测试结果
        //ClassName::instanceMethod  类的实例方法：把表达式的第一个参数当成instanceMethod的调用者，其他参数作为该方法的参数
        BiPredicate<String, String> sbp = String::equals;
        //等效
        BiPredicate<String, String> sbp2 = (x, y) -> x.equals(y);
        boolean test = sbp.test("a", "A");
        /************方法引用end************/

        ArrayList<User> items = new ArrayList<>();
        items.add(new User(11, "小牙刷", 1205 ));
        items.add(new User(5, "日本马桶盖", 99905 ));
        items.add(new User(7, "格力空调", 8888 ));
        items.add(new User(17, "肥皂", 200 ));
        items.add(new User(9, "冰箱", 420000 ));
        items.removeIf(ele -> ele.getId() == 7);
        //通过 foreach 遍历，查看是否已经删除
        items.forEach(System.out::println);

        /*
        items.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getId()  - o2.getId();
            }
        });
        */
        items.sort((o1, o2) -> o1.getId() - o2.getId());
        System.out.println(items);

    }



}
