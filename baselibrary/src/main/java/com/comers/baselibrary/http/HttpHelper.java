package com.comers.baselibrary.http;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Comers on 2017/10/24.
 */

public class HttpHelper {

    private static HttpHelper mSingleton;


    public static Activity mContext;

    public static HttpHelper getInstance() {
        if (mSingleton == null) {
            synchronized (HttpHelper.class) {
                if (mSingleton == null) {
                    mSingleton = new HttpHelper();
                }
            }
        }
        return mSingleton;
    }

    public static FormRequest doForm(@NonNull String url) {
        return new FormRequest(url);
    }

    public static PostRequest doPost(@NonNull String url) {
        return new PostRequest(url);
    }

    public static GetRequest doGet(@NonNull String url) {
        return new GetRequest(url);
    }

    public static PostRequest doPostStr(String url, String content) {
        return new PostRequest(url, content);
    }

    public void init(String baseUrl) {
        HttpConfig.baseUrl = baseUrl;
    }



    public static void downLoad(String url, final String filePath, final ProgressResponseListener listener) {
        if (listener == null)
            throw new IllegalArgumentException("ProgressResponseListener may not be null");
        if (TextUtils.isEmpty(filePath) || TextUtils.isEmpty(url)) {
            throw new IllegalArgumentException("url or filePath  may not be null");
        }
        final File destination = new File(filePath);
        long startPoint = 0;
        if (destination.exists()) {
            startPoint = destination.length();
        }
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(url)
                .addHeader("RANGE", "bytes=" + startPoint + "-")
                .build();
        final long finalStartPoint = startPoint;
        Call call = ProgressHelper.addProgressResponseListener(listener).newCall(request);
        UrlManager.INSTANCE.addCall(url, call);
        listener.onStart();
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.onFail(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(call.isCanceled()){
                    listener.onPause();
                }
                ResponseBody body = response.body();
                InputStream in = body.byteStream();
                FileChannel channelOut = null;
                // 随机访问文件，可以指定断点续传的起始位置
                RandomAccessFile randomAccessFile = null;
                try {
                    randomAccessFile = new RandomAccessFile(destination, "rwd");
                    //Chanel NIO中的用法，由于RandomAccessFile没有使用缓存策略，直接使用会使得下载速度变慢，亲测缓存下载3.3秒的文件，用普通的RandomAccessFile需要20多秒。
                    channelOut = randomAccessFile.getChannel();
                    // 内存映射，直接使用RandomAccessFile，是用其seek方法指定下载的起始位置，使用缓存下载，在这里指定下载位置。
                    MappedByteBuffer mappedBuffer = channelOut.map(FileChannel.MapMode.READ_WRITE, finalStartPoint, body.contentLength());
                    byte[] buffer = new byte[2048];
                    int len;
                    while ((len = in.read(buffer)) != -1) {
                        mappedBuffer.put(buffer, 0, len);
                    }
                    if (len == -1) {
                        listener.onLoad(destination);
                    } else {
                        listener.onFail("下载失败");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    listener.onFail("下载失败");
                } finally {
                    try {
                        in.close();
                        if (channelOut != null) {
                            channelOut.close();
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

}
