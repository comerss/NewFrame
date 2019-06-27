package com.comers.shenwu.stronger;

import java.util.concurrent.locks.ReentrantLock;

public class LockStronger {
    public static void main(String[] args) {
        final LockHelper stronger = new LockHelper();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                stronger.doIt();
            }
        });
        t1.setName("t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                stronger.doItMore();
//                stronger.doIt();
            }
        });
        t2.setName("t2");

        t1.start();
        t2.start();
    }
}
