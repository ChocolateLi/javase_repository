package com.IO.Buffer;

import java.io.*;

public class BufferStreamDemo {
    public static void main(String[] args) throws IOException {
        //文件复制
        //demo01();
        //字符输入流
        //demo02();
        //字符输出流
        demo03();
    }

    private static void demo03() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\test\\j.txt"));
        String s = "学习大数据技术";
        for (int i=0;i<5;i++){
            bw.write(s);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static void demo02() throws IOException {
        FileReader fd = new FileReader("D:\\test\\g.txt");
        BufferedReader br = new BufferedReader(fd);
        String line = null;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
        br.close();
    }

    private static void demo01() throws IOException {
        //输入流
        FileInputStream fi = new FileInputStream("C:\\Users\\95435\\Pictures\\Saved Pictures\\google.jpg");
        BufferedInputStream bi = new BufferedInputStream(fi);
        //输出流
        FileOutputStream fo = new FileOutputStream("D:\\test\\google2.jpg");
        BufferedOutputStream bo =new BufferedOutputStream(fo);
        int len=0;
        byte[] b = new byte[1024];
        while((len=bi.read(b))!=-1){
            bo.write(b,0,len);
        }
        bo.flush();
        bo.close();
        bi.close();
    }
}
