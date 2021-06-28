package com.IO.Stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {

    public static void main(String[] args) throws IOException {

        //读取字节数据
        //demo01();
        //使用字节数组进行读取
        demo02();
    }

    private static void demo02() throws IOException {
        File f = new File("D:\\test\\d.txt");
        FileInputStream fi = new FileInputStream(f);
        byte[] b = new byte[1024];
        int len=0;
        while ((len=fi.read(b))!=-1){
            System.out.println(new String(b,0,len));
        }
        fi.close();
    }

    private static void demo01() throws IOException {
        File f = new File("D:\\test\\c.txt");
        FileInputStream fi = new FileInputStream(f);
        int len=0;
        while ((len=fi.read())!=-1){
            System.out.println(len);
            System.out.println((char)len);
        }
        fi.close();
    }
}
