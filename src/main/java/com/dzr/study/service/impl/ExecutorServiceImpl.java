package com.dzr.study.service.impl;


import com.dzr.study.framework.MyTask;
import com.dzr.study.service.ExecutorService;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.*;

/**
 * @author dingzr
 * @Description 线程池使用
 * https://blog.csdn.net/gol_phing/article/details/49032055  非注解线程池
 * https://www.cnblogs.com/yw0219/p/8810956.html 注解线程池
 * @since 2018/9/29 15:18
 */

@Service
@Transactional
public class ExecutorServiceImpl implements ExecutorService {

    @Async
    @Override
    public void logOutInfo() {
        System.err.println("执行线程池：" + System.currentTimeMillis());
        System.out.println("线程名称：" + Thread.currentThread().getName());
    }

    @Async
    @Override
    public Future<String> sayHello(String name) {
        String res = name + ":Hello World!";
        LoggerFactory.getLogger(ExecutorServiceImpl.class).info(res);
        return new AsyncResult<>(res);
    }

    @Override
    public Object singleExecutorNoAnnotation() {
        try {
            java.util.concurrent.ExecutorService executorService = Executors.newSingleThreadExecutor();
            Future f = executorService.submit(() -> {
                System.err.println("开始执行 ...");
                int a = 1 / 1;
                //int a = 1 / 0;
                System.err.println("执行结束。。。");
                return "right data" + a;
            });

            try {
            } catch (Exception e) {
                System.err.println("异常：" + e.getMessage());
            }
            return f.get();
        } catch (Exception e) {
            System.err.println("异常2：");
        }
        return null;
    }


    @Override
    public void executorNoAnnotation() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));

        for (int i = 0; i < 15; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" +
                    executor.getQueue().size() + "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }

}
