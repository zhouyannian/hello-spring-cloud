package com.zhouyn.demo.redisserver.service;

import com.zhouyn.demo.redisserver.entity.User;
import com.zhouyn.demo.redisserver.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSerivceImpl {

    @Autowired
    private UserRepository userRepository;

    //    @Transactional(rollbackFor = Exception.class)
    public void test() {
        User user = User.builder()
                .userName("test")
                .age(66)
                .sex(0)
                .build();
        System.out.println(userRepository.save(user));
    }
}
