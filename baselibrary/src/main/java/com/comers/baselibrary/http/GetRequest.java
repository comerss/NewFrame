package com.comers.baselibrary.http;

import android.text.TextUtils;

import com.comers.baselibrary.utils.UIUtils;

import java.util.Map;

import okhttp3.Request;

/**
 * Created by Comers on 2017/10/24.
 */

public class GetRequest extends BaseRequest<GetRequest> {
    public GetRequest(String url) {
        super(url);
    }

    public GetRequest add(String key, Object value) {
        if (TextUtils.isEmpty(key)) {
            return this;
        }
        if (value == null) {
            mObjectMaps.put(key, "");
        } else {
            mObjectMaps.put(key, value);
        }
        return this;
    }

    public <T> void execute(BaseCallBack<T> callBack) {
        if (TextUtils.isEmpty(mURI)) {
           showToast("Url不能为空");
            return;
        }

        String url = getFixUrl(mURI);
        final Request request = new Request.Builder()
                .url(url)
                .build();
        perform(request, callBack);
        if (mShowFirstTime) {
            mShowDialog = false;
        }
    }

    public <T> void executeSync(BaseCallBack<T> callBack) {
        if (TextUtils.isEmpty(mURI)) {
            //提示输入URL
            return;
        }
        String url = getFixUrl(mURI);
        final Request request = new Request.Builder()
                .url(url)
                .build();
        performSync(request, callBack);
    }

    private String getFixUrl(String url) {
        StringBuffer argument = new StringBuffer();
        //最优选择是buffer
        for (Map.Entry<String, Object> param : mObjectMaps.entrySet()) {
            if (param.getKey() != null) {
                if (TextUtils.isEmpty(argument)) {
                    if (null != param.getValue() && !TextUtils.isEmpty(param.getValue().toString())) {
                        argument.append( param.getKey() + "=" + param.getValue());
                    } else {
                        argument.append( param.getKey() + "=" + "");
                    }
                } else {
                    if (null != param.getValue() && !TextUtils.isEmpty(param.getValue().toString())) {
                        argument.append(  "&" + param.getKey() + "=" + param.getValue());
                    } else {
                        argument.append(  "&" + param.getKey() + "=" + "");
                    }
                }
            }
        }
        return url + "?" + argument.toString();
    }
}
