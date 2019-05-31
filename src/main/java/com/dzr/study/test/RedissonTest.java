package com.dzr.study.test;

import com.dzr.study.service.impl.RedissonServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: dingzr
 * @Date: 2019/5/30 16:01
 * @Description:
 */

@Controller
@RequestMapping("test")
@Slf4j
public class RedissonTest {

    @Autowired
    private RedissonServiceImpl redissonService;

    @RequestMapping(value = "/test")
    @ResponseBody
    public void test(String recordId) {

        RLock lock = redissonService.getRLock(recordId);
        try {
            boolean bs = lock.tryLock(5, 6, TimeUnit.SECONDS);
            if (bs) {
                // 业务代码
                log.info("进入业务代码: " + recordId);

                lock.unlock();
            } else {
                Thread.sleep(300);
            }
        } catch (Exception e) {
            log.error("", e);
            lock.unlock();
        }
    }

}
