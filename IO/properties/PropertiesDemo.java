package com.IO.properties;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        //基本存储方法
        //demo01();
        //把集合数据存储到硬盘中
        //demo02();
        //从硬盘读数据到集合
        demo03();
    }

    private static void demo03() throws IOException {
        Properties p = new Properties();
        //输入流
        FileReader fd = new FileReader("D:\\test\\prop.txt");
        //加载
        p.load(fd);
        //读取数据
        Set<String> strings = p.stringPropertyNames();
        for (String key:strings){
            System.out.println(key+"="+p.getProperty(key));
        }

    }

    private static void demo02() throws IOException {
        Properties p = new Properties();
        //存数据
        p.setProperty("迪丽热巴","170");
        p.setProperty("杨幂","168");
        p.setProperty("谢娜","165");
        //输出流
        FileWriter fw = new FileWriter("D:\\test\\prop.txt");
        //存储方法
        p.store(fw,"save data");
        fw.flush();
        fw.close();
    }

    private static void demo01() {
        Properties p = new Properties();
        //存数据
        p.setProperty("迪丽热巴","170");
        p.setProperty("杨幂","168");
        p.setProperty("谢娜","165");

        //读取数据
        Set<String> set = p.stringPropertyNames();
        for (String key:set){
            System.out.println(key+"="+p.getProperty(key));
        }

    }
}
