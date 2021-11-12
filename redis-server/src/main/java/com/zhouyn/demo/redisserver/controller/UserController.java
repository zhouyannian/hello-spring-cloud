package com.zhouyn.demo.redisserver.controller;

import com.zhouyn.demo.redisserver.service.UserService;
import com.zhouyn.demo.redisserver.annotation.PicException;
import com.zhouyn.demo.redisserver.annotation.PicResponse;
import com.zhouyn.demo.redisserver.annotation.PicResultCode;
import com.zhouyn.demo.redisserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PicResponse
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() throws InterruptedException {

        //return restTemplate.getForEntity("http://SERVICE-PROVIDER/hello", String.class).getBody();
        int result = userService.asycTest();
        System.out.println(result);
        System.out.println("UserController线程：" + Thread.currentThread().getName());
        return "Hello World!";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUser() {

        //return restTemplate.getForEntity("http://SERVICE-PROVIDER/hello", String.class).getBody();

//        return new User(1L, "周延年", 29, 0);
        return null;
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order() {

        //return restTemplate.getForEntity("http://SERVICE-PROVIDER/hello", String.class).getBody();

        throw new PicException(PicResultCode.ACCESS_DENIED.code(), PicResultCode.ACCESS_DENIED.message());
    }
}
