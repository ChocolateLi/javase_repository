package com.IO.Reader_Writer;

import java.io.FileWriter;
import java.io.IOException;

public class WriterDemo {
    public static void main(String[] args) throws IOException {
        //写入单个单词
        //demo01();
        //通过字符数组写入
        //demo02();
        //通过字符串写入
        //demo03();
        //续写并换行
        demo04();
    }

    private static void demo04() throws IOException {
        FileWriter fw = new FileWriter("D:\\test\\g.txt",true);
        String s = "你怎么那么优秀呀！";
        for (int i=0;i<5;i++){
            fw.write(s + "\r\n");
        }

        fw.flush();
        fw.close();
    }

    private static void demo03() throws IOException {
        FileWriter fw = new FileWriter("D:\\test\\f.txt");
        String s = "你怎么那么优秀呀！";
        fw.write(s);
        fw.flush();
        fw.close();
    }

    private static void demo02() throws IOException {
        FileWriter fw = new FileWriter("D:\\test\\f.txt");
        char[] c = "优秀".toCharArray();
        fw.write(c);
        fw.flush();
        fw.close();
    }

    private static void demo01() throws IOException {
        FileWriter fw = new FileWriter("D:\\test\\e.txt");
        fw.write(97);
        fw.flush();
        fw.close();
    }
}
