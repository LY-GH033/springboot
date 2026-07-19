package com.mybatis.common;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
@EnableCaching
@Configuration
public class RedisConfig {
    @Bean
    public ConcurrentMapCacheManager cacheManager() {
        // 创建一个默认的 ConcurrentMapCacheManager
        return new ConcurrentMapCacheManager("defaultCache"); // 可以指定一个或多个默认缓存名
    }
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        // 设置key和value的序列化方式
        template.setKeySerializer(new StringRedisSerializer()); // 设置key的序列化器为StringRedisSerializer
        template.setValueSerializer(new JdkSerializationRedisSerializer()); // 设置value的序列化器为JdkSerializationRedisSerializer
        template.setHashKeySerializer(new StringRedisSerializer()); // 设置hash key的序列化器为StringRedisSerializer
        template.setHashValueSerializer(new JdkSerializationRedisSerializer()); // 设置hash value的序列化器为JdkSerializationRedisSerializer
        template.afterPropertiesSet(); // 初始化RedisTemplate

        return template;
    }
}