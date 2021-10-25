package com.zhouyn.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名
 *
 * @Author: zhouyn
 * @Data: 2019/8/21 16:35
 * @Description: 描述
 * @Version: 1.0
 **/
@Controller
public class LoginController {


    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }


}
