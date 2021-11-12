package com.zhouyn.demo.redisserver.demo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class ImageTest {
    public static void main(String[] args) throws IOException {
        //统一资源
        URL url = new URL("http://dev.cloudflarecdns.com/1597459211-bc07a232f93fb813f747a28164d53f73.jpg");
        //连接类的父类，抽象类
        URLConnection urlConnection = url.openConnection();
        //http的连接类
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
        //设置超时
        httpURLConnection.setConnectTimeout(1000 * 5);
        //设置请求方式，默认是GET
        httpURLConnection.setRequestMethod("GET");
        //设置字符编码
        httpURLConnection.setRequestProperty("Charset", "UTF-8");

        httpURLConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36");
        //打开到此URL引用的资源的通信链接（如果尚未建立这样的连接）
        httpURLConnection.connect();
        // 文件大小
        int fileLength = httpURLConnection.getContentLength();
        System.out.println("下载的文件大小为:" + fileLength + "Byte");

        System.out.println(httpURLConnection.getInputStream().toString());
    }
}
