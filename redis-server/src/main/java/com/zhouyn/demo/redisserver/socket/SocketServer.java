package com.zhouyn.demo.redisserver.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketServer {

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ServerSocket serverSocket = new ServerSocket(9999);
        while (true) {
            Socket socket = serverSocket.accept();
            Runnable runnable = () -> {
                System.out.println("服务端等待输入......");
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                    while (true) {
                        String str = bufferedReader.readLine();
                        if (str == null) {
                            System.out.println("关机...");
                            break;
                        }
                        System.out.println("当前线程:" + Thread.currentThread().getName());
                        System.out.println(String.format("客户端%s发来消息:%s", socket.getLocalAddress(), str));
                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            };

            executorService.submit(runnable);
        }


    }
}
