package com.zhouyn.demo.service.impl;

import com.zhouyn.demo.entity.LoginUser;
import com.zhouyn.demo.entity.UserRole;
import com.zhouyn.demo.repository.RoleRepository;
import com.zhouyn.demo.repository.UserRepository;
import com.zhouyn.demo.repository.UserRoleRepository;
import com.zhouyn.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名
 *
 * @Author: zhouyn
 * @Data: 2019/8/21 16:07
 * @Description: 描述
 * @Version: 1.0
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        LoginUser loginUser = userRepository.findByUserName(userName);

        List<UserRole> userRoleList = userRoleRepository.findByUserId(loginUser.getId());

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        userRoleList.forEach(userRole -> {
            String roleName = roleRepository.findById(userRole.getRoleId()).get().getRoleName();
            if (!StringUtils.isEmpty(roleName)) {
                authorityList.add(new SimpleGrantedAuthority(roleName));
            }
            log.info("用户：{}拥有角色：{}", userName, roleName);

        });

        User user = new User(userName, loginUser.getPassword(), authorityList);

        return user;
    }
}
