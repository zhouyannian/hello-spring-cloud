package com.zhouyn.demo.serviceConsumer.service;

import com.zhouyn.demo.serviceConsumer.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User createUser(User user);

    User findUserById(Long id);

    User updateUser(User user);

    void deleteUser(Long id);

}
