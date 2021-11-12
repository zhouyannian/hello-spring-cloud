package com.zhouyn.demo.redisserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private UserSerivceImpl userSerivce;

    @Transactional(rollbackFor = Exception.class)
    public int asycTest() throws InterruptedException {
//        applicationEventPublisher.publishEvent(new AddImage2AliyunEvent("3333"));

//        userMapper.save(new User(6L,"TEST",20));
        userSerivce.test();
        throw new NullPointerException("hehe");
//        return 1;
    }
}
