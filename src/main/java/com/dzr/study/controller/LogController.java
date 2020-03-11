package com.dzr.study.controller;

import com.dzr.study.framework.BaseController;
import com.dzr.study.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("log")
@Api(value = "LogController", tags = "log", description = "日志模块")
public class LogController extends BaseController {

    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }


    @PostMapping(value = "loggerService")
    @CrossOrigin(origins = "*", maxAge = 3600, methods = {})
    @ApiOperation(value = "测试日志", httpMethod = "POST", produces = "application/json; charset=utf-8")
    public Map<String, Object> loggerService() {
        logService.loggerService();
        return successResult("loggerService");
    }

    @PostMapping(value = "loggerSlf4jService")
    @ApiOperation(value = "测试Slf4j日志", httpMethod = "POST", produces = "application/json; charset=utf-8")
    public Map<String, Object> loggerSlf4jService() {
        logService.loggerSlf4jService();
        return successResult("loggerSlf4jService");
    }

}
