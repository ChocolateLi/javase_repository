package com.Thread.communication;

//包子铺，表示生产者，生产包子
public class BaoZi_Producer extends Thread{

    private BaoZi baozi;

    public BaoZi_Producer(BaoZi baozi){
        this.baozi = baozi;
    }

    @Override
    public void run() {
        int count = 0;
        //一直生产，用while(true)循环
        while (true){
            synchronized (baozi){
                if (baozi.flag == true){
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //增加趣味性
                if (count%2==0){
                    baozi.pi = "薄皮";
                    baozi.xian = "牛肉馅";
                    System.out.println("包子铺生产包子-->"+baozi.pi+baozi.xian+"包子");
                }else{
                    baozi.pi = "脆皮";
                    baozi.xian = "猪肉馅";
                    System.out.println("包子铺生产包子-->"+baozi.pi+baozi.xian+"包子");
                }
                //做个包子要5秒钟
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
                baozi.flag = true;
                baozi.notify();
            }
        }
    }
}
