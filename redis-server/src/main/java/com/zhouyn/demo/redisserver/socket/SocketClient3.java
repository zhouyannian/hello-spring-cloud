package com.zhouyn.demo.redisserver.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient3 {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 9999)) {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("请输入:");
                String str = scanner.nextLine();
                if ("exit".equals(str)) {
                    break;
                }
                bufferedWriter.write(str);
                bufferedWriter.write("\n");
                bufferedWriter.flush();
//                socket.shutdownOutput();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
