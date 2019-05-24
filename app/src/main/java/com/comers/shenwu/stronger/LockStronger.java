package com.comers.shenwu.stronger;

import java.util.concurrent.locks.ReentrantLock;

public class LockStronger {
    public static void main(String[] args){
        final LockHelper stronger=new LockHelper();
       Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                stronger.doIt();
            }
        });
       t1.setName("t1");
        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                stronger.doIt();
            }
        });
        t2.setName("t2");

        t1.start();
        t2.start();
    }
    public synchronized void doIt(){
        try {
            Thread.sleep(1000);
        System.out.println("ooo00000000");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void doItMore(){
        try {
            Thread.sleep(100);
            System.out.println("1111111");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
