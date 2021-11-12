package com.zhouyn.demo.redisserver.service;

import com.zhouyn.demo.redisserver.entity.AddImage2AliyunEvent;
import com.zhouyn.demo.redisserver.entity.User;
import com.zhouyn.demo.redisserver.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AddImage2AliyunListener {

    @Autowired
    private UserRepository userMapper;

    @Async
    @EventListener
    public void onApplicationEvent(AddImage2AliyunEvent addImage2AliyunEvent) throws InterruptedException {
//        System.out.println("AddImage2AliyunListener当前线程：" + Thread.currentThread().getName());
//        Thread.sleep(3000);
//        System.out.println(addImage2AliyunEvent.getSource());
//
//        throw new NullPointerException("hehe");

//        String sql = "INSERT INTO t_user(user_name,age,sex) VALUES ('test',29,0)";
//        jdbcTemplate.update(sql);

        User user = User.builder()
                .userName("test")
                .age(66)
                .sex(0)
                .build();
        System.out.println(userMapper.save(user));

    }
}
