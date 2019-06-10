package com.seeapp.demo.component.configuration;

import com.github.mydog.redis.RedisClient;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Protocol;

/**
 * Redis 配置
 *
 * @author zhuhui
 */
@Configuration
public class RedisConfiguration {

    @Value("${redis.host:localhost}")
    private String host;
    @Value("${redis.port:6379}")
    private int port;
    @Value("${redis.password:#{null}}")
    private String password;
    @Value("${redis.pool.minIdle:0}")
    private int poolMinIdle;
    @Value("${redis.pool.maxIdle:16}")
    private int poolMaxIdle;
    @Value("${redis.pool.maxTotal:16}")
    private int poolMaxTotal;
    @Value("${redis.pool.maxWait:3000}")
    private int poolMaxWait;

    @Bean(destroyMethod = "destroy")
    public RedisClient redisClient() {
        RedisClient redisClient = new RedisClient();
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMinIdle(poolMinIdle);
        poolConfig.setMaxIdle(poolMaxIdle);
        poolConfig.setMaxTotal(poolMaxTotal);
        poolConfig.setMaxWaitMillis(poolMaxWait);
        JedisPool jedisPool = new JedisPool(poolConfig, host, port, Protocol.DEFAULT_TIMEOUT, password);
        redisClient.setJedisPool(jedisPool);
        return redisClient;
    }
}
