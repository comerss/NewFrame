package com.donews.frame.sdk;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 79653 on 2018/10/22.
 * 描述：
 */
public class JavaActivity {
    public static void main(String[] args) {
        List<RunnableData> mQuene=new ArrayList<>();
        Producter producter=new Producter(mQuene);
        Producter producter1=new Producter(mQuene);
        Producter producter2=new Producter(mQuene);
        Producter producter3=new Producter(mQuene);
        Producter producter4=new Producter(mQuene);
        Consumer consumer=new Consumer(mQuene);
        Consumer consumer1=new Consumer(mQuene);
        Consumer consumer2=new Consumer(mQuene);
        Consumer consumer3=new Consumer(mQuene);
        Consumer consumer4=new Consumer(mQuene);
        ExecutorService service=Executors.newCachedThreadPool();
        service.execute(producter);
        service.execute(producter1);
        service.execute(producter2);
        service.execute(producter3);
        service.execute(producter4);
        service.execute(consumer);
        service.execute(consumer1);
        service.execute(consumer2);
        service.execute(consumer3);
        service.execute(consumer4);
    }

   static class RunnableData {
        public int data;

        public RunnableData(int data) {
            this.data = data;
        }
    }

  static   class Producter implements Runnable {
        List<RunnableData> mDataList;
        Random mRandom = new Random();

        public Producter(List<RunnableData> data) {
            mDataList = data;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        return;
                    }
                    synchronized (mDataList) {
                        if (mDataList != null && mDataList.size() > 10) {
                            mDataList.notifyAll();
                            mDataList.wait();
                        } else {
                            RunnableData data = new RunnableData(mRandom.nextInt());
                            mDataList.add(data);
                            System.out.println("生产者生产了一个数据---------" + data.data);
//                            Log.i("Producter", "生产者生产了一个数据---------" + data.data);
                        }
                    }
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
//                Thread.currentThread().isInterrupted();
            }
        }
    }

  static   class Consumer implements Runnable {
        List<RunnableData> mDataList;

        public Consumer(List<RunnableData> data) {
            mDataList = data;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        return;
                    }
                    synchronized (mDataList) {
                        if (mDataList == null || mDataList.size() == 0) {
                            mDataList.notifyAll();
                            mDataList.wait();
                        }
                        RunnableData data = mDataList.remove(0);
                        System.out.println("消费者消费了一条数据---" + data.data);
//                        Log.i("Consumer", );
                    }
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
