package com.dzr.study.test;

import com.dzr.study.po.Paper;
import com.dzr.study.po.WorkHours;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author dingzr
 * @Description Steam相关方法
 * @ClassName SteamTest
 * @since 2017/5/24 15:44
 */
public class SteamTest {

    /**
     * 初始化生成集合
     *
     * @param size
     * @return
     */
    public static List<Paper> getList(int size) {
        List<Paper> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Paper user = new Paper();
            user.setId(i);
            user.setAge(i);
            user.setAddress("address：" + i);
            list.add(user);
        }
        return list;
    }

    /**
     * 创建steam流
     */
    private static void generateSteam() {
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> e = "1")
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList()).stream().forEach(t -> System.err.println(t));

        List<String> asList = Arrays.asList("1", "2", "3", "3");
        Map map = asList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.err.println("map" + map);
    }

    /**
     * 单个stream的多次操作
     */
    public static void doubleSteamTest() {
        List<Paper> list = getList(3);
        list.stream().peek(t -> System.err.println("第二次: " + t.getAge())).collect(Collectors.toList());
        list.stream()
                .peek(e -> System.out.println("Filtered value: " + e.getAge()))
                .peek(e -> e.setAge(e.getAge() + 1)) //这个可以的，赋值也是生效的
                .peek(e -> System.out.println("Filtered value1: " + e.getAge()))
//                .flatMap(person -> Stream.of(person.getId(), person.getAge())) //不太对劲
                .collect(Collectors.toList())
                .stream()
                .forEach(t -> System.err.println("dfshs--" + t.getAge() + "--" + t.getId()));
    }

    /**
     * 排序 默认是升序的h1，h2
     */
    private static void compare() {
        List<Paper> list = getList(3);

        list.stream().sorted((h1, h2) -> h2.getAge().compareTo(h1.getAge()))
                .collect(Collectors.toList());

        list.stream().forEach(a -> System.err.println(a.getAge()));

        list.sort(Comparator.comparing(Paper::getAge));
        list.sort(Comparator.comparing(Paper::getAge).reversed());
    }

    /**
     * 获取集合里面的对象
     */
    public static void getObject() {
        List<Paper> list = getList(3);
        Optional<Paper> a = list.stream().filter(t -> t.getId() == 2).findFirst();
//        User user = list.stream().filter(t -> t.getId() == 5).findFirst().get();
        Paper user = a.get();
        System.err.println(a.isPresent());
    }

    public void streamGenerate() {

        Random seed = new Random();
        Supplier<Integer> random = seed::nextInt;
        Stream.generate(random).limit(10).forEach(System.out::println);
        //Another way
        IntStream.generate(() -> (int) (System.nanoTime() % 100)).
                limit(10).forEach(System.out::println);

//        Stream.generate(new WasteSupplier()).limit(10).
//                forEach(p -> System.out.println(p.getName() + ", " + p.getAge()));


        Stream.iterate(0, n -> n + 3).limit(10).forEach(System.err::println);


    }

//    public class WasteSupplier implements Supplier<Waste> {
//        private int index = 0;
//        private Random random = new Random();
//
//        @Override
//        public Waste get() {
//            return new Waste(index++, "StormTestUser" + index, random.nextInt(100));
//        }
//    }

    private static final Set<Integer> SPECIAL_WORK_TIME = Stream.of(8,9,10,0).collect(Collectors.toSet());




    public static void main(String[] args) {
        List<WorkHours> list = new ArrayList<>();

        WorkHours user = new WorkHours();
        user.setStartTime(1555545600);
        user.setEndTime(1555561800 );
        list.add(user);

        WorkHours user1 = new WorkHours();
        user1.setStartTime(1555567200);
        user1.setEndTime(1555603200 );
        list.add(user1);

        WorkHours user2 = new WorkHours();
        user2.setStartTime(1555567250);
        user2.setEndTime(1555603200 );
        list.add(user2);

//        list.forEach(t -> System.err.println(t.getStartTime()));
//        list.sort(Comparator.comparing(WorkHours::getStartTime));
//        list.forEach(t -> System.err.println("new   " + t.getStartTime()));
//        System.err.println(JSONArray.fromObject(list).toString());
//        Stream.of("1,2,,2,6".split(",")).filter(t -> !"".equals(t)).map(Integer::parseInt).collect(Collectors.toList()).forEach(t -> System.err.println(t));

        for (WorkHours t : list) {
            List<WorkHours> tempList = list.stream()
                    .filter(m -> m.getStartTime().equals(t.getStartTime()))
                    .collect(Collectors.toList());
            if (tempList.size() > 1) {
                t.setDesc("5555");
            }
        }

        list.forEach(t -> System.err.println(t.getDesc()));

        Optional<Integer> maxRealPayTime = Stream.of(1,5,8,6,9).max(Integer::compare);
        System.err.println(maxRealPayTime.get());

        System.err.println("aa ooo   ddd     fgfgf-gg".replace(" ",""));

    }

}
