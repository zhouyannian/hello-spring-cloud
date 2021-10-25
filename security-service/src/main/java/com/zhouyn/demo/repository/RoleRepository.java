package com.zhouyn.demo.repository;

import com.zhouyn.demo.entity.LoginUser;
import com.zhouyn.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 类名
 *
 * @Author: zhouyn
 * @Data: 2019/8/21 16:10
 * @Description: 描述
 * @Version: 1.0
 **/
public interface RoleRepository extends JpaRepository<Role,Long> {

}
