package com.Thread.communication;

//包子消费者
public class BaoZi_Comsumer extends Thread{

    private BaoZi baozi;

    public BaoZi_Comsumer(BaoZi baozi){
        this.baozi = baozi;
    }

    @Override
    public void run() {
        while (true){
            synchronized (baozi){

                if (baozi.flag==false){
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("吃包子-->"+baozi.pi+baozi.xian+"包子");
                //吃包子3秒钟
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                baozi.flag = false;
                baozi.notify();
                System.out.println("----------------------------------");
            }
        }
    }
}
