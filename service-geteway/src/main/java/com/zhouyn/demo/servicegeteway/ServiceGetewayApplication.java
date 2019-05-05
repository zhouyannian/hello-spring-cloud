package com.zhouyn.demo.servicegeteway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ServiceGetewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceGetewayApplication.class, args);
    }

}
