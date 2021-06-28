package com.IO.transformStream;

import java.io.*;

public class TransformStream {

    public static void main(String[] args) throws IOException {
        //将utf-8的文件转换为GBK的文件
        //utf8_to_gbk();
        //InputStreamReader读取gbk文件
        demo01();
    }

    private static void demo01() throws IOException {
        //不指定gbk会出现乱码
        InputStreamReader ir = new InputStreamReader(new FileInputStream("D:\\test\\f_gbk.txt"),"gbk");
        int len = 0;
        char[] c = new char[1024];
        while ((len=ir.read(c))!=-1){
            System.out.println(new String(c,0,len));
        }
    }

    private static void utf8_to_gbk() throws IOException {
        //InputStreamReader是字符转换为字节的桥梁
        InputStreamReader ir = new InputStreamReader(new FileInputStream("D:\\test\\f.txt"),"utf-8");
        //OutputStreamWriter是字节转换为字符的桥梁
        OutputStreamWriter ow = new OutputStreamWriter(new FileOutputStream("D:\\test\\f_gbk.txt"),"gbk");
        int len=0;
        while ((len=ir.read())!=-1){
            ow.write(len);
        }
        ow.flush();
        ow.close();
        ir.close();
    }
}
