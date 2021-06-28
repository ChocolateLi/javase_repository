package com.Thread.communication;

public class Test {

    public static void main(String[] args) {
        BaoZi baozi = new BaoZi();
        BaoZi_Producer bp = new BaoZi_Producer(baozi);
        BaoZi_Comsumer bc = new BaoZi_Comsumer(baozi);
        bp.start();
        bc.start();
    }
}
