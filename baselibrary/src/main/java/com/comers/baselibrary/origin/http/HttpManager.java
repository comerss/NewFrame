package com.comers.baselibrary.origin.http;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.donews.sdk.base.JsonParseHelper;
import com.donews.sdk.origin.service.DoRequest;
import com.donews.sdk.origin.service.ICallBack;
import com.donews.sdk.origin.service.WorkStation;
import com.donews.sdk.origin.service.WrapperResponse;
import com.donews.sdk.origin.service.convert.Convert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by 79653 on 2018/8/29.
 * 描述：
 */
public enum HttpManager {
    INSTANCE;

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
    public <T> void doGet(String url,  ICallBack<T> ICallBack) {
        doRequest(url, new HashMap<String, Object>(), HttpMethod.GET, ICallBack);
    }

    private  <T> void doRequest(String url, Map<String, Object> params, HttpMethod method, ICallBack<T> ICallBack) {
        DoRequest request = new DoRequest();
        WrapperResponse wrapperResponse = new WrapperResponse(ICallBack, sConverts);
        request.setUrl(url);
        if (method == HttpMethod.GET) {
            request.setUrl(getUrl(url, params));
        } else if(method==HttpMethod.POST){
            request.setUrl(url);
            request.setData(JsonParseHelper.parse(params).getBytes());
        }else if(method==HttpMethod.FORM){
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
