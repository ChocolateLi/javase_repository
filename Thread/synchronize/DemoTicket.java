package com.Thread.synchronize;

public class DemoTicket {

    public static void main(String[] args) {
//        Sell_Ticket st = new Sell_Ticket();
//        Sell_Ticket_Synchronized_one st = new Sell_Ticket_Synchronized_one();
//        Sell_Ticket_Synchronized_two st = new Sell_Ticket_Synchronized_two();
        Sell_Ticket_Synchronized_three st = new Sell_Ticket_Synchronized_three();
        Thread t1 = new Thread(st);
        Thread t2 = new Thread(st);
        Thread t3 = new Thread(st);
        t1.start();
        t2.start();
        t3.start();
    }
}

