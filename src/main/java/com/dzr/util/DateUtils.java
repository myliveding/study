package com.dzr.util;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author dingzr
 * @Description
 * @ClassName DateUtils
 * @since 2017/9/15 17:26
 */
public class DateUtils {

    private static ZoneId zone = ZoneId.systemDefault();


    /**
     * 当前时间加减天数
     *
     * @param param p
     * @return r
     */
    public static Integer dayPlus(Integer param) {
        LocalDateTime tomorrow = LocalDateTime.now().plusDays(param);
        return Integer.parseInt(String.valueOf(tomorrow.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() / 1000));
    }


    public static void main(String[] args) {
        //System.err.println(zone);

    }

}
