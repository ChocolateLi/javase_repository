package com.IO.Stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        long s = System.currentTimeMillis();
        //输入流
        FileInputStream fs = new FileInputStream("C:\\Users\\95435\\Pictures\\Saved Pictures\\google.jpg");
        //输出流
        FileOutputStream fo = new FileOutputStream("D:\\test\\google.jpg");
        byte[] b = new byte[1024];
        int len=0;
        while((len=fs.read(b))!=-1){
            fo.write(b,0,len);
        }
        fo.close();
        fs.close();
        long e = System.currentTimeMillis();
        System.out.println("复制时长为：" + (e-s) + "毫秒");
    }
}
