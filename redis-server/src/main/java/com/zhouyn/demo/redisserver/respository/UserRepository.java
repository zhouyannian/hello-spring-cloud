package com.zhouyn.demo.redisserver.respository;

import com.zhouyn.demo.redisserver.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends CrudRepository<User, Long> {

}
