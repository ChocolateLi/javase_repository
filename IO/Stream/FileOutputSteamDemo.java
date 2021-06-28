package com.IO.Stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

//字节输出流测试demo
public class FileOutputSteamDemo {

    public static void main(String[] args) throws IOException {

        //写入一个字节
        //demo01();

        //写入字节数组
        //demo02();

        //写入指定字节长度的字节数组
        //demo03();

        //数据追加续写
        //demo04();

        //换行追加续写
        demo05();

    }

    private static void demo05() throws IOException {
        File f = new File("D:\\test\\d.txt");
        FileOutputStream fo = new FileOutputStream(f,true);
        byte[] b = "abcde".getBytes();
        for (int i=0;i<5;i++){
            fo.write(b);
            fo.write("\r\n".getBytes());
        }
        //关闭流
        fo.close();
    }

    private static void demo04() throws IOException {
        File f = new File("D:\\test\\d.txt");
        FileOutputStream fo = new FileOutputStream(f,true);
        byte[] b = "abcde".getBytes();
        for (int i=0;i<5;i++){
            fo.write(b);
        }
        //关闭流
        fo.close();
    }

    private static void demo03() throws IOException {
        File f = new File("D:\\test\\c.txt");
        FileOutputStream fo = new FileOutputStream(f);
        byte[] b = "abcde！".getBytes();
        fo.write(b,2,2);//cd
        //关闭流
        fo.close();
    }

    private static void demo02() throws IOException {
        File f = new File("D:\\test\\b.txt");
        FileOutputStream fo = new FileOutputStream(f);
        byte[] b = "你好呀！".getBytes();
        fo.write(b);
        //关闭流
        fo.close();
    }

    private static void demo01() throws IOException{
        File f = new File("D:\\test\\a.txt");
        FileOutputStream fo = new FileOutputStream(f);
        //写入一个字节
        fo.write(97);//97就是a
        //关闭流
        fo.close();
    }


}
