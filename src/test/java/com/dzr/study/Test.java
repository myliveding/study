package com.dzr.study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dingzr
 * @Description
 * @ClassName Test
 * @since 2017/10/31 15:03
 */
public class Test {
    public static void main(String[] args) {
        System.err.println("44444444444444444444444444444");

        String a = "^[0-9a-zA-Z]{6}$";
        Pattern pattern = Pattern.compile(a);
        Matcher matcher = pattern.matcher("333333");
        System.err.println(matcher.matches());

        System.err.println("kk_k5=555".matches("[A-Za-z0-9_]+"));
    }

}
