package com.comers.shenwu.stronger;

public class LockHelper {
    Integer integer=new Integer(1);
    public  void doIt(){
        synchronized (integer){
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName()+"ooo00000000----"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        }
    }
    public  void doItMore(){
        synchronized (integer){
        try {
            Thread.sleep(100);
            System.out.println("1111111");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        }
    }
}
