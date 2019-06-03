package com.dzr.study.test;

import com.dzr.study.service.impl.RedissonDistributedLocker;

import org.redisson.api.RExpirable;
import org.redisson.api.RList;
import org.redisson.client.codec.IntegerCodec;
import org.redisson.client.codec.StringCodec;
import org.redisson.codec.SerializationCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: dingzr
 * @Date: 2019/5/30 16:01
 * @Description:
 */

@SpringBootTest
@RunWith(SpringRunner.class)
@Component
public class RedissonTest {

    @Autowired
    private RedissonDistributedLocker redissonLocker;
    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void contextLoads() throws Exception {
//        int count = 10;
//        CountDownLatch latch = new CountDownLatch(count);
//        for (int i = 0; i < count; i++) {
//            Thread thread = new Thread(() -> {
//                try {
//                    String lockKey = "17631701110";
//                    redissonLocker.tryLock(lockKey, TimeUnit.SECONDS, 100, 8);
//                    System.out.println("===加锁===" + Thread.currentThread().getName());
//
//                    System.out.println("===做自己操作===");
//                   // Thread.sleep(1000);
//
//                    System.out.println("===释放锁===" + Thread.currentThread().getName());
//                    redissonLocker.unlock(lockKey);
//
//                    System.out.println(latch.getCount());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                latch.countDown();
//            });
//            thread.start();
//
//        }
//        latch.await();

        RBucket bucket = redissonClient.getBucket("newData1");
        bucket.set("222");
        System.err.println(bucket.get());


        RBucket bucket1 = redissonClient.getBucket("app-info:0");
        System.err.println(bucket1.get());


        RList<String> list = redissonClient.getList("xbz_service:position_refresh_num:2019-05-15");
        System.err.println(list.size() + "--" + list.isExists());

        list.readAll().forEach(System.err::println);

    }

}
