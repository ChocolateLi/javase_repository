package com.Thread.create;

//使用线程池

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class My_runnable implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}

public class ThreadDemp_four {

    public static void main(String[] args) {

        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //创建Runnable对象
        Runnable me = new My_runnable();
        //从线程池中获取线程对象，把Runnable对象传递过去
        executorService.submit(me);
        //关闭线程池。生产环境是不关的
        executorService.shutdown();

        //主线程的执行
        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+ ":" + i);
        }
    }

}
