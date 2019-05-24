package com.zhouyn.demo.apolloClient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Value("${request.timeout:200}")
    private String timeout;

    @GetMapping("/index")
    public String hello() {
        return "Hello, man!";
    }

    @GetMapping("/timeout")
    public String getTimeout() {
        return timeout;
    }
}
