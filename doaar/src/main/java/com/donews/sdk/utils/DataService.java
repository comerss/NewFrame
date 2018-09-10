package com.donews.sdk.utils;

import android.os.Handler;
import android.os.Message;

import com.donews.sdk.inveno.AdRequest;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 主要功能: 提交请求 (通过线程池的方法)
 * <br>1. get
 * <br>2. post
 * Created by YJ on 2015/10/28.
 */
public class DataService {

	private static ExecutorService executorService = null;

	public static synchronized void reset() {
	    if (executorService != null) {
            executorService.shutdownNow();
            executorService = null;
        }
	}
	
	/**
	 * 主要功能:通过get请求数据.(通过线程池发送执行)
	 * @param url---------网址
	 * @param handler-----成功后得到通过handler句柄发送成功消息
	 * @param success-----handler成功后的what
	 * @param fail--------handler不成功的what
	 * @annotation YJ.2015.10.28
	 */
	public static synchronized void get(final String url, final Handler handler, final int success, final int fail) {
		if (executorService == null) {
			executorService = Executors.newSingleThreadExecutor(); // 如果
		}
		executorService.submit(new Runnable() {
			public void run() {
				final Message msg = handler.obtainMessage();
				try {
					final String result = HttpService.sendGet(url);
					msg.obj = result;
					msg.what = success;
				} catch (Exception e) {
					msg.what = fail;
				}

				handler.sendMessage(msg);
			}
		});
	}

	public static synchronized void post(final String url, final Map<String, Object> params, final Handler handler, final int success, final int fail) {
		if (executorService == null) {
			executorService = Executors.newSingleThreadExecutor();
		}
		executorService.submit(new Runnable() {
			public void run() {
				final Message msg = handler.obtainMessage();
				try {
					String result=null;
					if(url.contains(AUtils.URL_SERVER)){
						result=HttpService.sendPost(url,params);
					}else if(url.contains(AdRequest.INVENO_AD_URL)){
						result = HttpService.postGzip(url, params);
					}else {
						result = HttpService.post(url, params);
					}
//					final String result = HttpService.sendPost(url, params);
					msg.obj = result;
					msg.what = success;
				} catch (Exception e) {
					msg.what = fail;
				}

				handler.sendMessage(msg);
			}
		});
	}

	public static synchronized void post(final String url, final Map<String, String> params, final String filepath, final Handler handler,
			final int success, final int fail) {
		if (executorService == null) {
			executorService = Executors.newSingleThreadExecutor();
		}
		executorService.submit(new Runnable() {
			public void run() {
				final Message msg = handler.obtainMessage();
				try {
					final String result = HttpService.post(url, params, filepath);
					msg.obj = result;
					msg.what = success;
				} catch (Exception e) {
					msg.what = fail;
				}

				handler.sendMessage(msg);
			}
		});
	}
}
