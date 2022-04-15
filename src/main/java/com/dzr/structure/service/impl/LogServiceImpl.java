package com.dzr.structure.service.impl;

import com.dzr.structure.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author dingzr
 * @Description
 * @since 2018/9/30 11:24
 */

@Service
@Transactional
@Slf4j
public class LogServiceImpl implements LogService {

    private static Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);

    public void loggerService() {
        logger.debug("debug：....");
        logger.info("info...");
        logger.error("error...");
    }

    public void loggerSlf4jService() {
        log.debug("Slf4j debug....");
        log.info("Slf4j info...");
        log.error("Slf4j error...");
    }


}
