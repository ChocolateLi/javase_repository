package com.Thread.synchronize;

//使用同步代码块实现线程安全问题
/*
synchronized(同步锁){
        需要同步操作的代码
}
同步锁：
1、可以是任意对象
2、多个线程对象，需要使用同一把锁
*/

public class Sell_Ticket_Synchronized_one implements Runnable{

    private int ticket = 100;
    //创建一个锁对象
    Object obj = new Object();
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj){
                if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"-->正在卖第"+ticket+"张票");
                    ticket--;
                }
            }
        }
    }
}
