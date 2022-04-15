package com.dzr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: dingzr
 * @Date: 2020/3/11 16:05
 * @Description:
 */

@Configuration
public class CrossConfig {

    @Bean
    public WebMvcConfigurer CrossOriginConfig(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/api/**");
            }
        };
    };

}
