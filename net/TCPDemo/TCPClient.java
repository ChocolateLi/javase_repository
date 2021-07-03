package com.net.TCPDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1、创建Socker对象连接
        Socket s = new Socket("127.0.0.1",5656);
        //2、获取outputstream对象，向服务器发送数据
        OutputStream os = s.getOutputStream();
        os.write("你好呀！".getBytes());
        //任何先前写出的数据将被发送，随后终止输出流
        s.shutdownOutput();
        //3、获取inputstream对象，读取服务器返回的数据
        InputStream is = s.getInputStream();
        byte[] b = new byte[1024];
        int len = is.read(b);
        System.out.println(new String(b,0,len));
        //4、关闭资源
        s.close();
    }
}
