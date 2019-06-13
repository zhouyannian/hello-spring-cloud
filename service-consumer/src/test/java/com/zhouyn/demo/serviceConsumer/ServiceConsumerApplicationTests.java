package com.zhouyn.demo.serviceConsumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceConsumerApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void redisTest() {
        // redis存储数据
        String key = "users:3";
        //redisTemplate.opsForValue().set(key, "yukong");
        // 获取数据
        Set<String> keys = redisTemplate.keys("*");
        System.out.println("获取缓存中key为" + key + "的值为：" + redisTemplate.opsForValue().get(key));



    }

}
