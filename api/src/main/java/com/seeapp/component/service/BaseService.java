package com.seeapp.component.service;

import com.github.mydog.db.MysqlClient;
import com.github.mydog.redis.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * servie 基类
 *
 * @author zhuhui
 */
public abstract class BaseService {

    @Autowired
    protected MysqlClient mysqlClient;
    @Autowired
    protected RedisClient redisClient;
}
