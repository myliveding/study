package com.dzr.study.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author dingzr
 * @Description
 * @ClassName ExecutorConfig
 * @since 2018/9/29 16:10
 */

@Component
public class ThreadAsyncConfigurer implements AsyncConfigurer {

    @Bean
    public Executor executorConfig() {
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        //设置核心线程数
        threadPool.setCorePoolSize(10);
        //设置最大线程数
        threadPool.setMaxPoolSize(100);
        //线程池所使用的缓冲队列
        threadPool.setQueueCapacity(10);
        //等待任务在关机时完成--表明等待所有线程执行完
        threadPool.setWaitForTasksToCompleteOnShutdown(true);
        // 等待时间 （默认为0，此时立即停止），并没等待xx秒后强制停止
        threadPool.setAwaitTerminationSeconds(60);
        //  线程名称前缀
        threadPool.setThreadNamePrefix("MyStudyAsync-");

        //线程存活时间
        //表示线程没有任务执行时最多保持多久时间会终止。
        // 默认情况下，只有当线程池中的线程数大于corePoolSize时，keepAliveTime才会起作用，
        // 直到线程池中的线程数不大于corePoolSize，即当线程池中的线程数大于corePoolSize时，
        // 如果一个线程空闲的时间达到keepAliveTime，则会终止，直到线程池中的线程数不超过corePoolSize。
        // 但是如果调用了allowCoreThreadTimeOut(boolean)方法，在线程池中的线程数不大于corePoolSize时，
        // keepAliveTime参数也会起作用，直到线程池中的线程数为0；
        threadPool.setKeepAliveSeconds(60);
        //对拒绝task的处理策略
        threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 初始化线程
        threadPool.initialize();
        return threadPool;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }


}
