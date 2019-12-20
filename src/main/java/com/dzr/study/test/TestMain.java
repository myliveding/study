package com.dzr.study.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author dingzr
 * @since 2018/5/25 10:51
 */
public class TestMain {

    /**
     * 获取默认时区偏移量: +8
     */
    private static final ZoneOffset DEFAULT_ZONE_OFF_SET = ZoneOffset.of("+8");

    /**
     * 时间转 int
     *
     * @param time 待转时间
     * @return int
     */
    public static int parseTimeToInt(LocalDateTime time) {
        return (int)time.toEpochSecond(DEFAULT_ZONE_OFF_SET);
    }

    /**
     * 获取传入时间的凌晨时刻时间戳
     */
    public static int getMaxTimeOfNowDate(){
        return parseTimeToInt(LocalDateTime.of(LocalDate.now(), LocalTime.MAX));
    }

    public static void main(String[] args) {
        System.err.println(BigDecimal.valueOf(2000).divide(BigDecimal.valueOf(174), 2, RoundingMode.HALF_UP));

//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            list.add(0);
//            list.add(1);
//            list.add(2);
//            list.add(3);
//            list.add(4);
//        }
//
//        long start1 = System.currentTimeMillis();
//        Map<String, Long> map = new HashMap<>();
//        map.put("draftCount", list.stream().filter(t -> t == 0).count());
//        map.put("withdrawnCount", list.stream().filter(t -> t == 1).count());
//        map.put("overdueCount", list.stream().filter(t -> t == 2).count());
//        map.put("closeCount", list.stream().filter(t -> t == 3).count());
//        map.put("recruitingCount", list.stream().filter(t -> t == 4).count());
//        System.err.println("11111111111111111111111   " + map.get("draftCount"));
//        System.err.println("11111111111111111111111   " + (System.currentTimeMillis() - start1));
//
//        long start2 = System.currentTimeMillis();
//        int draftCount = 0;
//        int withdrawnCount = 0;
//        int overdueCount = 0;
//        int closeCount = 0;
//        int recruitingCount = 0;
//        for (Integer t : list) {
//            if(t == 0){
//                draftCount = draftCount + 1;
//            }
//            if(t == 1){
//                withdrawnCount += 1;
//            }
//            if(t == 2){
//                overdueCount = overdueCount + 1;
//            }
//            if(t == 3){
//                closeCount = closeCount + 1;
//            }
//            if(t == 4){
//                recruitingCount = recruitingCount + 1;
//            }
//        }
//        System.err.println("22222222222222222222222222222222   " + draftCount + " --- "+ withdrawnCount);
//        System.err.println("22222222222222222222222222222222   " + (System.currentTimeMillis() - start2));


        BigDecimal a = new BigDecimal("2.00");

        System.err.println(a.toString());


    }


}
