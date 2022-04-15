package com.dzr.config;


import com.dzr.listener.RedisExpiredListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;


/**
 * @Auther: dingzr
 * @Date: 2018/12/21 13:26
 * @Description:
 */
@Configuration
public class RedisListenerContainerConfig {

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(new RedisExpiredListener(), new PatternTopic("__keyevent@8__:expired"));
        return container;
    }


}
