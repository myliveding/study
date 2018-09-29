package com.dzr.study.service;

import java.util.concurrent.Future;

/**
 * @author dingzr
 * @Description
 * @ClassName ExecutorService
 * @since 2018/9/29 15:18
 */
public interface ExecutorService {

    void logOutInfo();

    Future<String> sayHello(String name);

    Object singleExecutorNoAnnotation();

    void executorNoAnnotation();

}
