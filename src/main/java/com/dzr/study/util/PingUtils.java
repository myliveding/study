package com.dzr.study.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static jodd.util.ThreadUtil.sleep;

/**
 * @Auther: dingzr
 * @Date: 2020/6/8 13:51
 * @Description:
 */
public class PingUtils {

    private static Domain ping(String domian) {
        long start = System.currentTimeMillis();
        Domain result = new Domain();
        try {
            InetAddress address = InetAddress.getByName(domian);
            result.setIp(address.getHostAddress());
            result.setHost(address.getHostName());
            long end = System.currentTimeMillis();
            result.setTime(end - start);
        } catch (UnknownHostException e) {
            result.setIp("0.0.0.0");
            result.setHost("UNKONW");
        }
        return result;
    }

    public static class Domain {
        String ip;
        String host;
        long time;

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return String.format("host=%s, ip=%s, time=%s", host, ip, time);
        }
    }

    public static void main(String[] args) {

        List<String> domainList = Stream.of(
                "ib.snssdk.com",
                "api3-normal-c-lf.amemv.com",
                "api100-core-c-lf.amemv.com",
                "drop-l-misc-core-lf.snssdk.com",
                "drop-s-aweme-lf.snssdk.com",
                "drop-l-misc-core-lf.snssdk.com"
        ).distinct().collect(Collectors.toList());


        List<Domain> list = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            domainList.forEach(t -> {
                Domain domain = ping(t);
                if(list.stream().noneMatch(m -> m.getIp().equals(domain.getIp()))){
                    list.add(domain);
                }
            });
            int finalI = i;
            list.stream().sorted(Comparator.comparing(Domain::getIp)).forEach(t -> System.err.println("第 " + finalI + "次 ：" + t.ip));
            sleep(100000);
        }
        list.stream().sorted(Comparator.comparing(Domain::getIp)).forEach(t -> System.err.println(t.ip));
    }


}
