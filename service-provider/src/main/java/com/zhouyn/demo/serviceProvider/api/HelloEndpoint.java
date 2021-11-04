//package com.zhouyn.demo.serviceProvider.api;
//
//import com.netflix.appinfo.EurekaInstanceConfig;
//import com.zhouyn.demo.serviceProvider.service.UserService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Enumeration;
//
//
//@RestController
//public class HelloEndpoint {
//    protected Logger logger = LoggerFactory.getLogger(HelloEndpoint.class);
//
//    @Autowired
//    private EurekaInstanceConfig eurekaInstanceConfig;
//    @Value("${server.port}")
//    private int serverPort = 0;
//
//    @Autowired
//    private UserService userService;
//
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public String hello(HttpServletRequest request) {
//
//        Enumeration<String> e =  request.getHeaderNames();
//        System.out.println(e);
//
//        this.logger.info("/hello, instanceId:{}, host:{}", eurekaInstanceConfig.getInstanceId(),
//                eurekaInstanceConfig.getHostName(false));
//        return "Hello, Spring Cloud! My port is " + serverPort;
//    }
//
//    @GetMapping(value = "/test")
//    public String testThread(){
//        return userService.testThread();
//    }
//
//}
