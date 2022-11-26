package com.cloud.hql.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
public class RedisHelper {
    private final Logger logger = LoggerFactory.getLogger(RedisHelper.class);

    private JedisPoolConfig config;

    private JedisPool pool;

    private Jedis jedis;
    public RedisHelper() {
        logger.info("init redis");
        config = new JedisPoolConfig();
        config.setMaxIdle(200);
        config.setMaxTotal(300);
        config.setTestOnBorrow(false);
        config.setTestOnReturn(false);
        pool = new JedisPool(config, "127.0.0.1", 6379, 3000, "123456");
        try {
            jedis = pool.getResource();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void set(String key, String val) {
        jedis.set(key, val);
        logger.info("set:" + key + " val:" + val);
    }


}
