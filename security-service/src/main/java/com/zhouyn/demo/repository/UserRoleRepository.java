package com.zhouyn.demo.repository;

import com.zhouyn.demo.entity.LoginUser;
import com.zhouyn.demo.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 类名
 *
 * @Author: zhouyn
 * @Data: 2019/8/21 16:10
 * @Description: 描述
 * @Version: 1.0
 **/
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {

    List<UserRole> findByUserId(Long userId);
}
