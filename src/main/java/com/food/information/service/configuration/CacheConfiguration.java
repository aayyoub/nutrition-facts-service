package com.food.information.service.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
@EnableCaching
public class CacheConfiguration {
    @Bean
    public RedisSerializer<Object> redisSerializer() {
        return new Jackson2JsonRedisSerializer(Object.class);
    }
}
