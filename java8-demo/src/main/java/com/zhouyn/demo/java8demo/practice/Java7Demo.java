/**
 * Copyright (c) 2020,TravelSky.
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 */
package com.zhouyn.demo.java8demo.practice;

import com.zhouyn.demo.java8demo.constant.DemoConstant;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static com.zhouyn.demo.java8demo.constant.DemoConstant.USER_ID;
import static com.zhouyn.demo.java8demo.constant.DemoConstant.USER_PASSWORD;

/**
 * Java7Demo
 *
 * @author: zhouyn
 * @data: 2020/1/9 14:42
 * @description: 描述
 * @version: 1.0
 **/
@Slf4j
public class Java7Demo {
    public static void main(String[] args) {

        // 1、数字变量对下划线的支持
        int intNum = 123_456;
        long longNum = 10_000L;
        float floatNum = 20_888F;

        // 2、swich对String的支持
        String str = "JAVA";
        switch (str) {
            case "JAVA":
                break;
            case "PHP":
                break;
            case "C#":
                break;
            default:
                break;
        }
        // 3、try-with-resource
        try (FileInputStream inputStream = new FileInputStream("")) {
            inputStream.available();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 4、捕获多种异常
        try {
            String ip = Inet4Address.getLocalHost().getHostAddress();
            Connection connection = null;
            Statement statement = connection.createStatement();
        } catch (UnknownHostException | SQLException e) {
            log.error(e.getMessage());
            // TODO
        }

        // 5、创建泛型时类型推断
        List<String> list = new ArrayList<>();
        list.add("A");
    }
}
