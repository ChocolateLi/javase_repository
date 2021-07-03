package com.net.TCPDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        //创建ServerSocket对象
        ServerSocket serversocket = new ServerSocket(5656);
        //通过accept()方法获取到socket对象
        Socket accept = serversocket.accept();
        //获取inputstream对象，读取客户端的数据
        InputStream is = accept.getInputStream();
        byte[] b = new byte[1024];
        int len = 0;
        while ((len=is.read(b))!=-1){
            System.out.println(new String(b,0,len));
        }
        //获取outputstream对象，返回数据给客户端
        OutputStream os = accept.getOutputStream();
        os.write("你好，已经收到你的信息了".getBytes());
        //关闭服务器
        accept.close();
        serversocket.close();
    }
}
