package com.comers.shenwu.sdk;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Run {
    public static void main(String[] args) {

        ExecutorService executors = Executors.newScheduledThreadPool(5);
        Future future = executors.submit(new Runnable() {
            @Override
            public void run() {

            }
        });

        //不会阻塞
        future.isDone();

        //一下两个都会阻塞，第二个可以是在第一个基础上设置了超时时间
        try {
            future.get();
            future.get(1000, TimeUnit.SECONDS);
        } catch (InterruptedException | TimeoutException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Future<Object> future1 = executors.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                String str = "00000000";
                return str;
            }
        });
        try {
            future1.get();

            future1.isDone();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        String str = "";
        final FutureTask task = new FutureTask(new Runnable() {
            @Override
            public void run() {

            }
        }, str);

        task.run();

        new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                String str = "";
                return str;
            }
        });

        //线程池原理
        new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

    }


}
