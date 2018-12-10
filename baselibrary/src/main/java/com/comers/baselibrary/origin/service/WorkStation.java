package com.comers.baselibrary.origin.service;


import com.comers.baselibrary.origin.HttpRequestProvider;
import com.comers.baselibrary.origin.http.HttpRequest;

import java.net.URI;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author nate
 */

public class WorkStation {

    private static final int MAX_REQUEST_SIZE = 10;

    private static final ThreadPoolExecutor sThreadPool = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new ThreadFactory() {

        private AtomicInteger index = new AtomicInteger();

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("http thread name is " + index.getAndIncrement());
            return thread;
        }
    });


    private Deque<DoRequest> mRunning = new ArrayDeque<>();

    private Deque<DoRequest> mCache = new ArrayDeque<>();

    private HttpRequestProvider mRequestProvider;

    public WorkStation() {
        mRequestProvider = new HttpRequestProvider();
    }

    public void add(DoRequest request) {
        if (mRunning.size() > MAX_REQUEST_SIZE) {
            mCache.add(request);
        } else {
            doHttpRequest(request);
        }
    }


    public void doHttpRequest(DoRequest request) {

        HttpRequest httpRequest = null;
        try {
            httpRequest = mRequestProvider.getHttpRequest(URI.create(request.getUrl()), request.getMethod());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(httpRequest!=null){
            sThreadPool.execute(new HttpRunnable(httpRequest, request, this));
        }
    }


    public void finish(DoRequest request) {
        mRunning.remove(request);
        if (mRunning.size() > MAX_REQUEST_SIZE) {
            return;
        }

        if (mCache.size() == 0) {
            return;
        }

        Iterator<DoRequest> iterator = mCache.iterator();

        while (iterator.hasNext()) {
            DoRequest next = iterator.next();
            mRunning.add(next);
            iterator.remove();
            doHttpRequest(next);
        }

    }
}
