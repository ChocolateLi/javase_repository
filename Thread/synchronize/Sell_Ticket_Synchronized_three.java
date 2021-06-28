package com.Thread.synchronize;

//使用锁对象实现线程安全问题

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sell_Ticket_Synchronized_three implements Runnable{

    private int ticket = 100;
    //创建锁对象
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            //加锁
            lock.lock();
            try {
                Thread.sleep(10);
                if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"-->正在卖第"+ticket+"张票");
                    ticket--;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                //释放锁
                lock.unlock();
            }


        }
    }

}
