package com.dzr.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.validation.annotation.Validated;
import redis.clients.jedis.JedisPoolConfig;

import javax.validation.constraints.NotNull;
import java.time.Duration;

/**
 * @Auther: dingzr
 * @Date: 2019/1/28 10:52
 * @Description:
 */

@Configuration
@Data
@ConfigurationProperties(prefix = "spring.redis")
@Validated
public class RedisConfig {

    @NotNull
    private Integer database;

    @NotNull
    private Integer databaseListen;

    @NotNull
    private String host;

    @NotNull
    private Integer port;

    private String passWord;

    @NotNull
    private Integer timeout;

    @NotNull
    private Integer maxActive;

    @NotNull
    private Integer maxWait;

    @NotNull
    private Integer maxIdle;

    @NotNull
    private Integer minIdle;

    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);
        poolConfig.setNumTestsPerEvictionRun(10);
        poolConfig.setTimeBetweenEvictionRunsMillis(60000);
        return poolConfig;
    }

    /**
     * 组装redis工厂
     */
    private RedisConnectionFactory getFactoryByDataBase(JedisPoolConfig jedisPoolConfig, Integer database){
        //单机版jedis
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        //设置redis服务器的host或者ip地址
        redisStandaloneConfiguration.setHostName(host);
        //设置默认使用的数据库
        redisStandaloneConfiguration.setDatabase(database);
        //设置密码
        redisStandaloneConfiguration.setPassword(RedisPassword.of(passWord));
        //设置redis的服务的端口号
        redisStandaloneConfiguration.setPort(port);

        //获得默认的连接池构造器(怎么设计的，为什么不抽象出单独类，供用户使用呢)
        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jpcb =
                (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder)JedisClientConfiguration.builder()
                        .connectTimeout(Duration.ofMillis(timeout));
        //指定jedisPoolConifig来修改默认的连接池构造器（真麻烦，滥用设计模式！）
        jpcb.poolConfig(jedisPoolConfig);
        //通过构造器来构造jedis客户端配置
        JedisClientConfiguration jedisClientConfiguration = jpcb.build();
        //单机配置 + 客户端配置 = jedis连接工厂
        return new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);
    }

    @Bean
    @Primary
    @Qualifier
    public RedisConnectionFactory redisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
        return getFactoryByDataBase(jedisPoolConfig, database);
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactoryListen(JedisPoolConfig jedisPoolConfig) {
        return getFactoryByDataBase(jedisPoolConfig, databaseListen);
    }

    @Bean(name = "redisTemplate")
    @Primary
    @Qualifier
    public RedisTemplate<String, Object> redisTemplate(){
        RedisTemplate<String, Object> redisTemplateForListen = new RedisTemplate<>();
        redisTemplateForListen.setConnectionFactory(redisConnectionFactory(jedisPoolConfig()));
        setSerializer(redisTemplateForListen);
        redisTemplateForListen.afterPropertiesSet();
        return redisTemplateForListen;
    }


    @Bean(name = "redisTemplateForListen")
    public RedisTemplate<String, Object> redisTemplateForListen(){
        RedisTemplate<String, Object> redisTemplateForListen = new RedisTemplate<>();
        redisTemplateForListen.setConnectionFactory(redisConnectionFactoryListen(jedisPoolConfig()));
        setSerializer(redisTemplateForListen);
        redisTemplateForListen.afterPropertiesSet();
        return redisTemplateForListen;
    }


    private void setSerializer(RedisTemplate<String, Object> template) {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(
                Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        template.setKeySerializer(template.getStringSerializer());
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        //在使用String的数据结构的时候使用这个来更改序列化方式
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringSerializer );
        template.setValueSerializer(stringSerializer );
        template.setHashKeySerializer(jackson2JsonRedisSerializer );
        template.setHashValueSerializer(jackson2JsonRedisSerializer );
    }

}
