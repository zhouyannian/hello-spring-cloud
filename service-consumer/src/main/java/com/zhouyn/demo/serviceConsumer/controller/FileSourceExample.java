package com.zhouyn.demo.serviceConsumer.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileSourceExample {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/zhouyn/Study/workspace/hello-spring-cloud/service-consumer/src/main/resources/file.txt";

        // 1、使用系统文件路径方式加载文件
        WritableResource wres = new PathResource(filePath);

        // 2、使用类路径方式加载文件
        Resource res = new ClassPathResource("file.txt");

        // 3、使用WritableResource接口写资源文件
//        OutputStream outputStream = wres.getOutputStream();
//        outputStream.write("欢迎光临".getBytes());
//        outputStream.close();

        // 4、使用Resource接口读资源文件
        InputStream inputStream = wres.getInputStream();
        InputStream inputStream2 = res.getInputStream();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i;
        while ((i = inputStream.read()) != -1) {
            byteArrayOutputStream.write(i);
        }

        System.out.println(byteArrayOutputStream.toString());
        System.out.println("wres = " + wres.getFilename());
        System.out.println("res = " + res.getFilename());

    }
}
