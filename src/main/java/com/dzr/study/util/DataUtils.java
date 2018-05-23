package com.dzr.study.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @FileName DataUtils
 * @Author dingzr
 * @CreateTime 2017/9/9 23:10 九月
 */
public class DataUtils {

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(201712);
        list.add(201801);
        list.add(201905);

        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                int maxYear = Integer.parseInt(list.get(i).toString().substring(0, 4));
                int maxMonth = Integer.parseInt(list.get(i).toString().substring(4, 6));
                int minYear = Integer.parseInt(list.get(i - 1).toString().substring(0, 4));
                int minMonth = Integer.parseInt(list.get(i - 1).toString().substring(4, 6));
                System.err.println(minYear + "--" + minMonth + "--" + maxYear + "--" + maxMonth);
                if ((maxYear == minYear && maxMonth - minMonth != 1) || maxYear - minYear > 1
                        || (maxYear - minYear == 1 && (maxMonth != 1 || minMonth != 12))) {
                    System.err.println(true);
                }
            }
        }

    }

}
