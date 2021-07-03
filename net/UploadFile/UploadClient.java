package com.net.UploadFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;


public class UploadClient {

    public static void main(String[] args) throws Exception {
        //1.创建流对象
        //1.1 创建输入流，读取本地文件
        FileInputStream fis = new FileInputStream("C:\\Users\\95435\\Pictures\\Saved Pictures\\google.jpg");
        BufferedInputStream bis = new BufferedInputStream(fis);
        //1.2 创建输出流，写到服务器上
        Socket s = new Socket("127.0.0.1",5656);
        OutputStream os = s.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        //2.写出数据
        byte[] b = new byte[1024];
        int len=0;
        while ((len=bis.read(b))!=-1){
            bos.write(b,0,len);
        }
        System.out.println("文件发送完毕");
        //3.释放资源
        bos.close();

    }
}
