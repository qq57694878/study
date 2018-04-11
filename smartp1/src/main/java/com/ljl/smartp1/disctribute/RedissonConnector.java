package com.ljl.smartp1.disctribute;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by fangzhipeng on 2017/4/5.
 * 获取RedissonClient连接类
 */
@Component
public class RedissonConnector {
    RedissonClient redisson;
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private Integer port;
    @Value("${spring.redis.password}")
    private String password;
    @PostConstruct
    public void init(){
       String url = "redis://"+this.host+":"+this.port;

        Config config = new Config();

        config.useSingleServer().setAddress(url).setPassword(this.password);

        redisson= Redisson.create(config);
    }

    public RedissonClient getClient(){
        return redisson;
    }

}