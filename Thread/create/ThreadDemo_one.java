package com.Thread.create;

//继承Thread类，重写run()方法
class MyThread extends Thread{

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}

public class ThreadDemo_one {

    public static void main(String[] args) {

        //创建线程,并执行
        Thread my_thread = new MyThread();
        my_thread.start();

        //主线程的执行
        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+ ":" + i);
        }
    }

}
