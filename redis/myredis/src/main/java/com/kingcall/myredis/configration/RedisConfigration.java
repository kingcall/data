package com.kingcall.myredis.configration;

import com.kingcall.myredis.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfigration {
    private static Logger logger = LoggerFactory.getLogger(RedisConfigration.class);
    @Bean(name = "redisClient")
    public RedisUtils getRedisClient(@Value("${spring.redis.host}") String master,
                                     @Value("${spring.redis.host}") String slave,
                                     @Value("${spring.redis.port}") int port) {
        logger.warn(String.format("init common redis client config detail : [ master : %s ,slave:%s , port : %s ] ", master, slave, port));
        return new RedisUtils(master, slave, port);
    }

}
