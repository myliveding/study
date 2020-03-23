package com.dzr.study.test;

import netscape.javascript.JSException;
import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: dingzr
 * @Date: 2020/3/12 17:34
 * @Description: 算法
 */
public class Arithmetic {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,4,6,2};
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < a.length; i++){
            for (int j = i + 1; j < a.length; j++) {
                if(a[i] == a[j]){
                    if(!list.contains(a[j])){
                        list.add(a[j]);
                    }
                }
            }
            System.err.println(a[i]);
        }

        list.forEach(System.err::println);


    }

}
