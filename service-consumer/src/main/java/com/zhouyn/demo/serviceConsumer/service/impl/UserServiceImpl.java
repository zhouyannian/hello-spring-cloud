package com.zhouyn.demo.serviceConsumer.service.impl;

import com.zhouyn.demo.serviceConsumer.entity.User;
import com.zhouyn.demo.serviceConsumer.repository.UserRepository;
import com.zhouyn.demo.serviceConsumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Cacheable(value = "users", key = "#id")
    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @CachePut(value = "users", key = "#user.id")
    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @CacheEvict(value = "users")
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public String testThread() {
        System.out.println(Thread.currentThread().getName());

        return Thread.currentThread().getName();
    }
}
