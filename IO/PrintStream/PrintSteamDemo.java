package com.IO.PrintStream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintSteamDemo {
    public static void main(String[] args) throws FileNotFoundException {
        //改变打印流的方向
        demo01();
    }

    private static void demo01() throws FileNotFoundException {
        System.out.println("我在控制台输出");
        PrintStream ps = new PrintStream("D:\\test\\print.txt");
        System.setOut(ps);
        ps.println("我在文件里输出");
    }
}
