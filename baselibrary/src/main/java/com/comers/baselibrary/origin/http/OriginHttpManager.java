package com.comers.baselibrary.origin.http;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.comers.baselibrary.http.JsonParseHelper;
import com.comers.baselibrary.origin.service.DoRequest;
import com.comers.baselibrary.origin.service.ICallBack;
import com.comers.baselibrary.origin.service.WorkStation;
import com.comers.baselibrary.origin.service.WrapperResponse;
import com.comers.baselibrary.origin.service.convert.Convert;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author dddd
 * Created by 79653 on 2018/8/29.
 * 描述：
 */
public class OriginHttpManager {
    private OriginHttpManager() {
    }

    public static OriginHttpManager INSTANCE = new OriginHttpManager();
    private static WorkStation sWorkStation = new WorkStation();

    private static final List<Convert> sConverts = new ArrayList<>();

    public <T> void doPost(String url, Map<String, Object> params, ICallBack<T> ICallBack) {
        doRequest(url, params, HttpMethod.POST, ICallBack);
    }

    public <T> void doForm(String url, Map<String, Object> params, ICallBack<T> ICallBack) {
        doRequest(url, params, HttpMethod.FORM, ICallBack);
    }

    public <T> void doPost(String url, ICallBack<T> ICallBack) {
        doRequest(url, new HashMap<String, Object>(), HttpMethod.POST, ICallBack);
    }

    public <T> void doGet(String url, Map<String, Object> params, ICallBack<T> ICallBack) {
        doRequest(url, params, HttpMethod.GET, ICallBack);
    }

    public <T> void doGet(String url, ICallBack<T> ICallBack) {
        doRequest(url, new HashMap<String, Object>(), HttpMethod.GET, ICallBack);
    }

    public <T> void download(String url, String path, ICallBack<File> fileICallBack) {
        if (TextUtils.isEmpty(path)) {
            throw new IllegalArgumentException("save path can't be null");
        }
        addTask(url, new HashMap<String, Object>(), HttpMethod.FORM, path, fileICallBack);
    }

    //如果网络设置有代理的情况下不进行网络请求，这个多个地方进行校验，确保安全性  有必要的进行的ＡＥＳ加密传输！
    private <T> void doRequest(String url, Map<String, Object> params, HttpMethod method, ICallBack<T> iCallBack) {
        addTask(url, params, method, "", iCallBack);
    }

    private <T> void addTask(String url, Map<String, Object> params, HttpMethod method, String path, ICallBack<T> iCallBack) {
        DoRequest request = new DoRequest();
        WrapperResponse wrapperResponse = new WrapperResponse(iCallBack, sConverts);
        request.setUrl(url);
        if (method == HttpMethod.GET) {
            request.setUrl(getUrl(url, params));
        } else if (method == HttpMethod.POST) {
            request.setUrl(url);
            request.setData(JsonParseHelper.obj2Json(params).getBytes());
        } else if (method == HttpMethod.FORM) {
            request.setUrl(url);
            request.setData(getStringBuffer(params).toString().getBytes());
        }
        request.mMethod = method;
        request.setResponse(wrapperResponse);
        sWorkStation.add(request);
    }

    private String getUrl(String url, Map<String, Object> mObjectMaps) {
        StringBuffer argument = getStringBuffer(mObjectMaps);
        return url + "?" + argument.toString();
    }

    @NonNull
    private StringBuffer getStringBuffer(Map<String, Object> mObjectMaps) {
        StringBuffer argument = new StringBuffer();
        //最优选择是buffer
        for (Map.Entry<String, Object> param : mObjectMaps.entrySet()) {
            if (param.getKey() != null) {
                if (TextUtils.isEmpty(argument)) {
                    if (null != param.getValue() && !TextUtils.isEmpty(param.getValue().toString())) {
                        argument.append(param.getKey() + "=" + param.getValue());
                    } else {
                        argument.append(param.getKey() + "=" + "");
                    }
                } else {
                    if (null != param.getValue() && !TextUtils.isEmpty(param.getValue().toString())) {
                        argument.append("&" + param.getKey() + "=" + param.getValue());
                    } else {
                        argument.append("&" + param.getKey() + "=" + "");
                    }
                }
            }
        }
        return argument;
    }
}
