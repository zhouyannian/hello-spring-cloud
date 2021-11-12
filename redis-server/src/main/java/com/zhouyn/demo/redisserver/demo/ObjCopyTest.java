package com.zhouyn.demo.redisserver.demo;

import com.zhouyn.demo.redisserver.entity.User;
import org.springframework.beans.BeanUtils;

public class ObjCopyTest {
    public static void main(String[] args) {
        User user = new User();
        user.setAge(28);

        ObjCopyTest objCopyTest = new ObjCopyTest();
        objCopyTest.query(user);
    }

    public void query(User user) {
        User newUser = new User();
        BeanUtils.copyProperties(user, newUser);
        newUser.setUserName("zhouyn");
        System.out.println("new user=" + newUser);
        System.out.println("user=" + user);
    }
}
