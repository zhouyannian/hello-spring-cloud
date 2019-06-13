package com.zhouyn.demo.serviceConsumer.repository;

import com.zhouyn.demo.serviceConsumer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
