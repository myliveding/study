package com.dzr.study.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dingzr 2021-11-22 11:16
 */
public class MatcherDo {

    private static final String formatSpecifier = "\\d+";

    private static Pattern fsPattern = Pattern.compile(formatSpecifier);

    public static void main(String[] args) {

        Matcher m = fsPattern.matcher("DDD");
        // 判定参数是否与正则完全匹配  返回布尔值
        System.err.println(m.matches());


        // 此方法从匹配器区域的开头开始，如果该方法的前一次调用成功了并且从那时开始匹配器没有被重置，则从以前匹配操作没有匹配的第一个字符开始。
        // 如果匹配成功，则可以通过 start、end 和 group 方法获取更多信息。
        // matcher.start() 返回匹配到的子字符串在字符串中的索引位置.
        // matcher.end()返回匹配到的子字符串的最后一个字符在字符串中的索引位置.
        // matcher.group()返回匹配到的子字符串
        Matcher m1 = fsPattern.matcher("反反复复33fff444");

        // 可入参字符串下标，下标从0开始
//        System.err.println(m1.find(2));

        while (m1.find()) {
            System.out.println(m1.group());
        }


        // Mathcher的find和lookingAt()方法执行成功之后，会影响后续的find的执行，因为下一次find会从上次匹配成功的位置开始继续查找，如果不想这样可以使用reset()方法复原匹配器的状态。
        System.err.println(m1.lookingAt());

        // 匹配成功该方法才能使用，否则报错
//        System.err.println(m1.start());

        System.err.println(m1.find());
        System.err.println(m1.find());

    }
}
