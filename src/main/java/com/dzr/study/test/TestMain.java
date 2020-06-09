package com.dzr.study.test;

import org.apache.commons.codec.binary.Hex;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    public static void main(String[] args) throws Exception {
//        System.err.println(BigDecimal.valueOf(2000).divide(BigDecimal.valueOf(174), 2, RoundingMode.HALF_UP));

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

//        BigDecimal a = new BigDecimal("2.00");
//        System.err.println(a.toString());
//        StringBuilder d = new StringBuilder();
//        System.err.println(d.toString().equals(""));
//        System.err.println(d.substring(0, d.length() - 1).toString());
// dbf2e870f5267482650b76dc4d92e4d5
//        System.err.println(md5("dbf2e870f5267482650b76dc4d92e4d5"));
        //19476b460cac0494b3a71902d4bd6425
        String dateStr="2020-06-07 12:13:34";
        String pattern="yyyy-MM-dd HH:mm:ss";
        DateFormat dateFormat= new SimpleDateFormat(pattern);
        Date date=dateFormat.parse(dateStr);
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        System.err.println(calendar);

    }

    /**
     * md5加密
     * @param password 原始密码
     */
    public static String md5(String password) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            byte[] passwordBytes = m.digest(password.getBytes());
            String passwordHash = new String(Hex.encodeHex(passwordBytes));
            byte[] md = m.digest(passwordHash.getBytes());
            return new String(Hex.encodeHex(md));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }



}
