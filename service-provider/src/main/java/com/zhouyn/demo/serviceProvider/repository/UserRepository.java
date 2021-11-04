package com.zhouyn.demo.serviceProvider.repository;

import com.zhouyn.demo.serviceProvider.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User, Long> {

}
