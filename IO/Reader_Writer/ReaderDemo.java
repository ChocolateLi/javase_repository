package com.IO.Reader_Writer;

import java.io.FileReader;
import java.io.IOException;

public class ReaderDemo {

    public static void main(String[] args) throws IOException {
        //读取字符数据
        //demo01();
        //使用字符数组读取
        demo02();
    }

    private static void demo02() throws IOException {
        FileReader fd = new FileReader("D:\\test\\b.txt");
        int len = 0;
        char[] r = new char[1024];
        while((len=fd.read(r))!=-1){
            System.out.println(new String(r,0,len));
        }
        fd.close();
    }

    private static void demo01() throws IOException {
        FileReader fd = new FileReader("D:\\test\\b.txt");
        int len = 0;
        while((len=fd.read())!=-1){
            System.out.print((char)len);
        }
        fd.close();
    }
}
