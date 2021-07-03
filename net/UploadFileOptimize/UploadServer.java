package com.net.UploadFileOptimize;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class UploadServer {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动...");
        //1.创建ServerSocket对象
        ServerSocket s = new ServerSocket(5656);

        //2.循环接收，建立连接
        while (true){
            Socket accept = s.accept();
            //3. Socket对象交给子线程处理
            new Thread(()->{
                try {
                    //3.1获取输入流读取文件
                    BufferedInputStream brs = new BufferedInputStream(accept.getInputStream());
                    //3.2创建输出流，保存到本地
                    File f = new File("D:\\test");
                    if (!f.exists()){
                        f.mkdir();
                    }
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f.getAbsoluteFile()+"\\"+System.currentTimeMillis() + new Random().nextInt(99999) +".jpg"));
                    //4.读写数据
                    byte[] b = new byte[1024];
                    int len=0;
                    while ((len=brs.read(b))!=-1){
                        bos.write(b,0,len);
                    }
                    //信息回写
                    OutputStream os = accept.getOutputStream();
                    os.write("文件上传成功".getBytes());
                    //5.关闭资源
                    bos.close();
                    brs.close();
                    accept.close();
                    System.out.println("文件已保存");

                }catch (Exception e){
                    e.printStackTrace();
                }
            }).start();
        }


    }
}
