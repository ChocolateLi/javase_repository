package com.net.UploadFile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadServer {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动");
        //1.创建ServerSocket对象
        ServerSocket s = new ServerSocket(5656);
        //2.建立连接
        Socket accept = s.accept();
        //3.创建对象流
        //3.1获取输入流读取文件
        BufferedInputStream brs = new BufferedInputStream(accept.getInputStream());
        //3.2创建输出流，保存到本地
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\test\\1.jpg"));
        //4.读写数据
        byte[] b = new byte[1024];
        int len=0;
        while ((len=brs.read(b))!=-1){
            bos.write(b,0,len);
        }
        //5.关闭资源
        bos.close();
        brs.close();
        accept.close();
        s.close();
        System.out.println("文件已保存");
    }
}
