package com.zhouyn.demo.redisServer;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        redisTemplate.opsForValue().set("student:1", "kirito");
        Assertions.assertThat(redisTemplate.opsForValue().get("student:1")).isEqualTo("kirito");
    }
}
