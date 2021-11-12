package com.zhouyn.demo.redisserver.demo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ClassLoaderTest extends ClassLoader {

    private String classLoaderName;

    private final String fileExtension = ".class";

    public ClassLoaderTest(String classLoaderName) {
        // 将系统类加载器当做该类加载器的父加载器
        super();
        this.classLoaderName = classLoaderName;
    }

    public ClassLoaderTest(ClassLoader parent, String classLoaderName) {
        // 显示指定该类加载器的父加载器
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }

    @Override
    protected Class<?> findClass(String name) {
        byte[] data = this.loadClassData(name);

        return this.defineClass(name, data, 0, data.length);
    }

    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        try {
            this.classLoaderName = this.classLoaderName.replace(".", "/");
            is = new FileInputStream(new File(name + this.fileExtension));
            baos = new ByteArrayOutputStream();

            int ch = 0;

            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }

            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

        return data;
    }

    public static void main(String[] args) throws Exception {
        ClassLoaderTest classLoaderTest = new ClassLoaderTest("classloader-zhouyn");
        test(classLoaderTest);
    }

    public static void test(ClassLoader classLoader) throws Exception {
        Class<?> clazz = classLoader.loadClass("com.zhouyn.demo.redisserver.demo.MyTest8");
        Object object = clazz.newInstance();

        System.out.println(object);
    }
}
