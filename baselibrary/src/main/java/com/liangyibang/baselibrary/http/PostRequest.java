package com.liangyibang.baselibrary.http;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.liangyibang.baselibrary.utils.ConstantsPool;
import com.liangyibang.baselibrary.utils.SharedHelper;
import com.liangyibang.baselibrary.utils.UIUtils;

import java.util.Map;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Comers on 2017/10/24.
 */

public class PostRequest extends BaseRequest<PostRequest> {
    public PostRequest(@NonNull String url) {
        super(url);
    }

    public PostRequest add(String key, Object value) {
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

    public <T> void execute(String jsonBody, BaseCallBack<T> callBack) {
        if (TextUtils.isEmpty(mURI)) {
            //提示输入URL
            return;
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonBody);
        final Request request = new Request.Builder()
                .url(mURI)
                .addHeader("Cookie", "token=" + SharedHelper.get(ConstantsPool.TOKEN, ""))
                .addHeader("Cookie", "app=android")
                .addHeader("Cookie", "version=" + UIUtils.getVersionCode())
                .post(body)
                .build();
        perform(request, callBack);
    }
    public <T> void execute(BaseCallBack<T> callBack) {
        if (TextUtils.isEmpty(mURI)) {
            //提示输入URL
            return;
        }
        String json = JsonParseHelper.parse(mObjectMaps);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        final Request request = new Request.Builder()
                .url(mURI)
                .addHeader("Cookie", "token=" + SharedHelper.get(ConstantsPool.TOKEN, ""))
                .addHeader("Cookie", "app=android")
                .addHeader("Cookie", "version=" + UIUtils.getVersionCode())
                .post(body)
                .build();
        perform(request, callBack);
    }

    public <T> void executeSync(BaseCallBack<T> callBack) {
        if (TextUtils.isEmpty(mURI)) {
            //提示输入URL
            return;
        }
        String json = JsonParseHelper.parse(mObjectMaps);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        final Request request = new Request.Builder()
                .url(mURI)
                .addHeader("Cookie", "token=" + SharedHelper.get(ConstantsPool.TOKEN, ""))
                .addHeader("Cookie", "app=android")
                .addHeader("Cookie", "version=" + UIUtils.getVersionCode())
                .post(body)
                .build();
        performSync(request, callBack);
    }

    private String getFixUrl(String url, Map<String, Object> mObjectMaps) {
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
        return url + "?" + argument.toString();
    }
}
