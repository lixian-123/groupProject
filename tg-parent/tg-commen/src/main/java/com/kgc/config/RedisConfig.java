package com.kgc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    //1.创建JedisPoolConfig对象，在该对象中完成一些连接池配置
    //2.创建JedisConnectionFactory对象,配置redis连接信息
    //@ConfigurationProperties(prefix="spring.redis"):会将前缀相同的内容创建一个实体
    //3.创建RedisTemplate:用于执行Redis操作方法
    @Bean
    public RedisTemplate<String, Object> getRedisTemplate(JedisConnectionFactory factory){
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        //关联连接工厂
        template.setConnectionFactory(factory);
        //为key设置序列化
        template.setKeySerializer(new StringRedisSerializer());
        //为value设置序列化
        template.setValueSerializer(new StringRedisSerializer());
        return template;
    }
}
