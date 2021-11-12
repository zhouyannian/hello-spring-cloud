package com.zhouyn.demo.redisserver.demo;

import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ImageUrl2Base64 {
    public static void main(String[] args) throws IOException {
//        String imagePath = "/Users/zhouyn/Downloads/图片/lufei2.jpeg";
//        System.out.println(encodeToString(imagePath));

        String base64Str = "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQA";
        System.out.println(base64Str.substring(base64Str.indexOf("base64,") + 7));
    }

    /**
     * 将图片转换成base64格式进行存储
     *
     * @param imagePath
     * @return
     */
    public static String encodeToString(String imagePath) throws IOException {
        String type = StringUtils.substring(imagePath, imagePath.lastIndexOf(".") + 1);
        BufferedImage image = ImageIO.read(new File(imagePath));
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();
            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }
}


