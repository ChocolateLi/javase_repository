package com.IO.File;

import java.io.File;
import java.io.IOException;

public class FileDemo {

    public static void main(String[] args) {
        //构造方法
        //demo01();

        //获取方法
        //demo02();

        //判断方法
        //demo03();

        //创建删除功能
        demo04();

        //遍历目录
        //demo05();

        //递归遍历目录
//        String path_name = "D:\\TourismData\\情感分析算法\\";
//        File f = new File(path_name);
//        demo06(f);
    }

    //递归遍历目录
    private static void demo06(File dir) {

        File[] files = dir.listFiles();
        for (File file:files){
            if(file.isDirectory()){
                demo06(file);
            }
            else{
                System.out.println(file);
            }
        }

    }

    //遍历目录方法
    private static void demo05() {
        String path_name = "D:\\TourismData\\情感分析算法\\";
        File f = new File(path_name);

        //获取当前文件夹的文件名称。返回的是String数组
        String[] name = f.list();
        for (String file_name : name){
            System.out.println(file_name);
        }

        //获取当前文件的文件。返回的是File数组
        File[] files = f.listFiles();
        for (File file:files){
            System.out.println(file);
        }


    }

    //创建删除方法
    private static void demo04() {
        String path_name = "D:\\TourismData\\情感分析算法\\";
        File f = new File(path_name);

        String text = "a.txt";
        File f1 = new File(f,text);

        String directory = "a";
        File f2 = new File(f,directory);

        //多级文件夹
        String directory1 = "b\\d\\e";
        File f3 = new File(f,directory1);

        //创建文件
        if (f.exists()){
            try {
                f1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //创建文件夹
        if(f.exists()){
            f2.mkdir();
        }

        //创建多级文件夹
        if(f.exists()){
            f3.mkdirs();
        }

        //删除文件
//        f1.delete();
//        f2.delete();
//        f3.delete();//必须空目录才能删除
    }

    //判断方法
    private static void demo03() {
        String path_name = "D:\\TourismData\\情感分析算法\\";
        File f = new File(path_name);

        //判断路径是否存在
        System.out.println(f.exists());
        //判断是否为文件夹
        System.out.println(f.isDirectory());
        //判断是否为文件
        System.out.println(f.isFile());
    }

    //查找方法
    private static void demo02() {
        String path_name = "D:\\TourismData\\情感分析算法\\";
        File f = new File(path_name);

        //获取绝对路径
        System.out.println(f.getAbsolutePath());
        //获取路径
        System.out.println(f.getPath());
        //获取文件夹的名字或文件名
        System.out.println(f.getName());

        //获取文件的长度，以字节为单位
        String file = "result_data.txt";
        File f1 = new File(path_name,file);
        System.out.println(f1.length());
    }

    //构造方法
    private static void demo01() {
        //File(String pathname)
        //通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
        String path_name = "D:\\Study\\Java基础\\06-File类与IO流\\06-File类与IO流\\02 递归";
        File f = new File(path_name);
        System.out.println(f);

        //File(String parent, String child)
        //从父路径名字符串和子路径名字符串创建新的 File实例。
        String parent = "D:\\Study";
        String children = "Java基础\\06-File类与IO流\\06-File类与IO流\\02 递归";
        File f1 = new File(parent,children);
        System.out.println(f1);

        //File(File parent, String child)
        //从父抽象路径名和子路径名字符串创建新的 File实例。
        File parent1 = new File(parent);
        File f2 = new File(parent1,children);
        System.out.println(f2);
    }



}
