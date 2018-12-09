package com.comers.sdk.utils;

import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;
import java.util.Map;

public class HttpUtils {

    private static final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case RESULT_SUCCESS:
                    HttpRequestWrap aRequest = null;
                    synchronized (arrRequestList) {
                        if (arrRequestList.size() > 0) {
                            aRequest = arrRequestList.remove(0);
                        }
                    }
                    if (aRequest != null && aRequest.aCallBack != null) {
                        aRequest.aCallBack.result(aRequest.aUrl, true, msg.obj.toString().trim());
                    }
                    synchronized (arrRequestList) {
                        if (arrRequestList.size() > 0) {
                            aRequest = arrRequestList.get(0);
                            if (aRequest.aParams == null) {
                                DataService.reset();
                                DataService.get(aRequest.aUrl, handler, RESULT_SUCCESS, RESULT_FAIL);
                            } else {
                                DataService.reset();
                                DataService.post(aRequest.aUrl, aRequest.aParams, handler, RESULT_SUCCESS, RESULT_FAIL);
                            }
                        }
                    }
                    break;

                case RESULT_FAIL:
                    HttpRequestWrap aRequest1 = null;
                    synchronized (arrRequestList) {
                        if (arrRequestList.size() > 0) {
                            aRequest1 = arrRequestList.remove(0);
                        }
                    }
                    if (aRequest1 != null && aRequest1.aCallBack != null) {
                        aRequest1.aCallBack.result(aRequest1.aUrl, false, "异常");
                    }
                    synchronized (arrRequestList) {
                        if (arrRequestList.size() > 0) {
                            aRequest1 = arrRequestList.get(0);
                            if (aRequest1.aParams == null) {
                                DataService.reset();
                                DataService.get(aRequest1.aUrl, handler, RESULT_SUCCESS, RESULT_FAIL);
                            } else {
                                DataService.reset();
                                DataService.post(aRequest1.aUrl, aRequest1.aParams, handler, RESULT_SUCCESS, RESULT_FAIL);
                            }
                        }
                    }
                    break;

                case 12345:
                    HttpRequestWrap aRequest2 = null;
                    synchronized (arrRequestList) {
                        if (arrRequestList.size() > 0) {
                            aRequest2 = arrRequestList.remove(0);
                        }
                    }
                    if (aRequest2 != null && aRequest2.aCallBack != null) {
                        aRequest2.aCallBack.result(aRequest2.aUrl, false, "异常");
                    }
                    synchronized (arrRequestList) {
                        if (arrRequestList.size() > 0) {
                            aRequest2 = arrRequestList.get(0);
                            if (aRequest2.aParams == null) {
                                DataService.reset();
                                DataService.get(aRequest2.aUrl, handler, RESULT_SUCCESS, RESULT_FAIL);
                            } else {
                                DataService.reset();
                                DataService.post(aRequest2.aUrl, aRequest2.aParams, handler, RESULT_SUCCESS, RESULT_FAIL);
                            }
                        }
                    }
                    break;
            }

        }
    };

    /**
     * 主要功能:数据的封装,存储1.回调方法,2.url,3.Map<S,S>参数
     */
    private static class HttpRequestWrap {
        public HttpResultCallback aCallBack;
        public String aUrl;
        public Map<String, Object> aParams;

        //
        public HttpRequestWrap(HttpResultCallback callback, String url, Map<String, Object> params) {
            aCallBack = callback;
            aUrl = url;
            aParams = params;
        }
    }

    /**
     * 存取请求数据的ArrayLIst的数组,以便处理多个请求  @YJ.2015.10.28
     */
    private static ArrayList<HttpRequestWrap> arrRequestList = new ArrayList<HttpRequestWrap>();

    private static void doHttpAction(HttpRequestWrap aRequest) {
        synchronized (arrRequestList) {
            arrRequestList.add(aRequest); // 将请求的数据加入到List数组中
            if (arrRequestList.size() == 1) {
                if (aRequest.aParams == null) {
                    DataService.get(aRequest.aUrl, handler, RESULT_SUCCESS, RESULT_FAIL);
                } else {
                    DataService.post(aRequest.aUrl, aRequest.aParams, handler, RESULT_SUCCESS, RESULT_FAIL);
                }
            }
        }
    }

    /**
     * Get请求数据 @YJ.2015.10.28
     */
    public static void startHttpGet(String url, HttpResultCallback callback) {
        boolean cando = System.getProperty("http.proxyPort") == null;
        if (cando) {//防止抓包
            HttpRequestWrap aRequest = new HttpRequestWrap(callback, url, null);
            doHttpAction(aRequest);
        }
    }

    /**
     * Post请求数据 @YJ.2015.10.28
     */
    public static void startHttpPost(String url, Map<String, Object> params, HttpResultCallback callback) {
        boolean cando = System.getProperty("http.proxyPort") == null;
        if (cando) {
            HttpRequestWrap aRequest = new HttpRequestWrap(callback, url, params);
            doHttpAction(aRequest);
        }
    }

    /**
     * 获得数据的回调方法,主要用到接受网络数据  @YJ.2015.10.28
     */
    public  interface HttpResultCallback {
        public void result(String url, boolean isResult, String jsonStr);
    }

    private static final int RESULT_SUCCESS = 1;
    private static final int RESULT_FAIL = 0;
}
