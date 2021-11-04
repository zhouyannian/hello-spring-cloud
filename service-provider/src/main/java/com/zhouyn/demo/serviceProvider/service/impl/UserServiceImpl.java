package com.zhouyn.demo.serviceProvider.service.impl;

import com.zhouyn.demo.serviceProvider.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String testThread() {
        return Thread.currentThread().getName();
    }
}
