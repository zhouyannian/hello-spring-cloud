package com.zhouyn.demo.repository;

import com.zhouyn.demo.entity.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 类名
 *
 * @Author: zhouyn
 * @Data: 2019/8/21 16:10
 * @Description: 描述
 * @Version: 1.0
 **/
public interface UserRepository extends JpaRepository<LoginUser,Long> {

    LoginUser findByUserName(String userName);
}
