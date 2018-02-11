package com.dzr.study.test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author dingzr
 * @Description
 * @ClassName ThreadPoolTest
 * @since 2018/2/11 10:12
 */
public class ThreadPoolTest {


    public static void main(String[] args) {
        try {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            Future f = executorService.submit(() -> {
                System.err.println("kaish");
                int a = 1 / 0;
                System.err.println("44444");
            });
            try {
                f.get();
            } catch (Exception e) {
                System.err.println("yichang1" + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("yichang2");
        }
    }

}
