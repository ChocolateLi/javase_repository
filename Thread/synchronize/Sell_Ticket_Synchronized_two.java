package com.Thread.synchronize;

//使用同步方法实现线程安全问题
/*
同步方法的锁对象就是它自己this
 */


public class Sell_Ticket_Synchronized_two implements Runnable{

    private int ticket = 100;
    @Override
    public void run() {
        while (true){
            sell_ticket();
        }
    }

    private synchronized void sell_ticket(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(ticket>0){
            System.out.println(Thread.currentThread().getName()+"-->正在卖第"+ticket+"张票");
            ticket--;
        }

    }
}
