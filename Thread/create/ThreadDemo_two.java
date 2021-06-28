package com.Thread.create;

//实现Runnable接口，重写run()方法
class My_Runnable implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}

public class ThreadDemo_two {

    public static void main(String[] args) {

        //创建线程,并执行
        //1、创建Runnable对象
        My_Runnable me = new My_Runnable();
        //2、把Runnable对象传递到Thread类中
        Thread t = new Thread(me);
        //3、开启线程
        t.start();

        //主线程的执行
        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+ ":" + i);
        }
    }
}
