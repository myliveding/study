package com.dzr.structure.controller;

import com.dzr.framework.BaseController;
import com.dzr.structure.service.ExecutorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("executor")
@Api(value = "ExecutorController", tags = "executor", description = "线程")
public class ExecutorController extends BaseController {

    private final ExecutorService executorService;

    @Autowired
    public ExecutorController(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @PostMapping("/validExecutor")
    @ApiOperation(value = "验证异步线程池", produces = "application/json; charset=utf-8")
    public Map<String, Object> validExecutor() {
        executorService.logOutInfo();
        return successResult("validExecutor");
    }


    @PostMapping("/validExecutorFuture")
    @ApiOperation(value = "验证同步线程池返回值", produces = "application/json; charset=utf-8")
    public Map<String, Object> validExecutorFuture() throws ExecutionException, InterruptedException {
        return successResult(executorService.sayHello("springBoot executorFuture ...").get());
    }

    @PostMapping("/singleExecutor")
    @ApiOperation(value = "非注解单线程", produces = "application/json; charset=utf-8")
    public Map<String, Object> singleExecutor() {

        return successResult(executorService.singleExecutorNoAnnotation());
    }

    @PostMapping("/executorNoAnnotation")
    @ApiOperation(value = "非注解线程池", produces = "application/json; charset=utf-8")
    public Map<String, Object> executorNoAnnotation() {
        executorService.executorNoAnnotation();
        return successResult("executorNoAnnotation");
    }

}
