package com.dzr.study.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
        String aaa = "W19030500016357442,W19030100000524322,W19030100000726372,W19030700012048876,W19031200021956205," +
                "W19030100000828364,W19030400014754856,W19030100005944682,W19030100000930014,W19030100001231830,W19030100001131780," +
                "W19030500011847132,W19030500011947181";
        System.err.println(aaa.split(",").length);

        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        System.err.println(map);

        BigDecimal a = BigDecimal.valueOf(50.16);
        System.err.println(a.setScale(2, BigDecimal.ROUND_UNNECESSARY));

        System.err.println("删灯笼裤福建省大家好聚精会神".length());
        System.err.println("删灯笼裤福建省大家好聚精会神".substring(0, 10));
        System.err.println(BigDecimal.valueOf(2000).divide(BigDecimal.valueOf(174), 2, RoundingMode.HALF_UP));

    }


}
