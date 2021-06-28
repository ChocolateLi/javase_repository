package com.Thread.create;

//实现Callable接口，重写call()方法

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class My_Callable implements Callable{

    @Override
    public Object call() throws Exception {
        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
        return null;
    }
}

public class ThreadDemo_three {
    public static void main(String[] args) {

        //创建线程,并执行
        //创建Callable对象
        Callable my_callable = new My_Callable();
        //使用FutureTask类包装Callable对象
        FutureTask my_task = new FutureTask(my_callable);
        //将FutureTask传递给Thread类
        Thread t = new Thread(my_task);
        t.start();

        //主线程的执行
        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+ ":" + i);
        }
    }
}
