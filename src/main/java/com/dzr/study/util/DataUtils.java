package com.dzr.study.util;

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

}
