package com.net.UploadFileOptimize;

import java.io.*;
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
        // 关闭输出流,通知服务端,写出数据完毕
        s.shutdownOutput();
        System.out.println("文件发送完毕");
        //解析服务器端的信息
        InputStream is = s.getInputStream();
        is.read(b);
        System.out.println(new String(b));

        //3.释放资源
        is.close();
        bos.close();
        s.close();
        bis.close();

    }
}
