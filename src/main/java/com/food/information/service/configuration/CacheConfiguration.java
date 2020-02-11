package com.food.information.service.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;

@Configuration
@EnableCaching
public class CacheConfiguration {
    @Bean
    public RedisCacheManager redisCacheManager(LettuceConnectionFactory lettuceConnectionFactory) {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration
                .defaultCacheConfig()
                .disableCachingNullValues()
                .entryTtl(Duration.ofHours(24))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json()));
        redisCacheConfiguration.usePrefix();

        return RedisCacheManager.RedisCacheManagerBuilder
                .fromConnectionFactory(lettuceConnectionFactory)
                .cacheDefaults(redisCacheConfiguration)
                .build();
    }
}
