package com.dzr.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author dingzr
 * @Description
 * @ClassName ApiResultUtil
 * @since 2017/7/5 13:43
 */
public final class ApiResultUtil {
    private Properties p = new Properties();
    private static ApiResultUtil instance;
    private static Logger logger = LoggerFactory.getLogger(ApiResultUtil.class);

    private ApiResultUtil() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("api-error.properties");
        try {
            p.load(inputStream);
        } catch (IOException e1) {
            logger.error("读取文件出错" + e1.getMessage());
        }
    }

    public static ApiResultUtil getInstance() {
        if (instance == null) {
            instance = new ApiResultUtil();
        }
        return instance;
    }

    public String getErrorInfo(String key) {
        return p.getProperty(key);
    }
}
