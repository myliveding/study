package com.dzr.study.string;

/**
 * @author dingzr 2022-04-13 16:31
 */
public class Replace {
    public static void main(String[] args) {
        String message = "容易通过面试,包工作餐,高薪岗位,商保,提供住宿";
        System.err.println(message.replace(",","-"));
        System.err.println(message.replaceAll(",","-"));


        String init = "Bob is a Bird... Bob is a Plane... Bob is Superman!";
        String changed = init.replaceAll("Bob is", "It's"); // Noncompliant
        System.err.println(changed);
        changed = changed.replaceAll("\\.\\.\\.", ";"); // Noncompliant
        System.err.println(changed + "---------");

        init = "Bob is a Bird... Bob is a Plane... Bob is Superman!";
        changed = init.replace("Bob is", "It's");
        System.err.println(changed);
        changed = changed.replace("...", ";");
        System.err.println(changed + "---------");


        init = "Bob is a Bird... Bob is a Plane... Bob is Superman!";
        changed = init.replaceAll("\\w*\\sis", "It's");
        System.err.println(changed);
        changed = changed.replaceAll("\\.{3}", ";");
        System.err.println(changed + "---------");


    }

}
