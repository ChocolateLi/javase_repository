package com.IO.FileFilter;

import java.io.File;

/*
搜索`D:\TourismData\情感分析算法\` 目录中的`.txt` 文件。

**分析**：
1. 目录搜索，无法判断多少级目录，所以使用递归，遍历所有目录。
2. 遍历目录时，获取的子文件，通过文件名称，判断是否符合条件。

使用过滤器对文件进行过滤
 */
public class FileDemo02 {

    public static void main(String[] args) {
        //创建File对象
        String path_name = "D:\\TourismData\\情感分析算法\\";
        File f = new File(path_name);
        //打印file
//        print_file(f);
        print_file_lambda(f);
    }

    private static void print_file(File dir) {
        //传递一个过滤器
        File[] file_list = dir.listFiles(new MyFileFilter());
        for (File f:file_list){
            if(f.isDirectory()){
                print_file(f);
            }
            else{
                System.out.println(f.getAbsolutePath());
            }
        }
    }

    //使用Lambda表达式
    private static void print_file_lambda(File dir) {
        //传递一个过滤器
        File[] file_list = dir.listFiles((pathname)-> pathname.isDirectory()||pathname.getName().endsWith(".txt"));
        for (File f:file_list){
            if(f.isDirectory()){
                print_file_lambda(f);
            }
            else{
                System.out.println(f.getAbsolutePath());
            }
        }
    }
}
