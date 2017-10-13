package cn.com.jldata.test;

import cn.com.jldata.assp.base.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

public class TestRedisTemplate extends TestBase {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Test
    public void test(){
        redisTemplate.opsForValue().set("a","123");
        System.out.println(redisTemplate.opsForValue().get("a"));
    }
}
