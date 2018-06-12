package com.liangyibang.baselibrary.http;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.liangyibang.baselibrary.utils.ConstantsPool;
import com.liangyibang.baselibrary.utils.SharedHelper;
import com.liangyibang.baselibrary.utils.UIUtils;

import java.io.File;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Comers on 2017/10/24.
 * 本app中主要是 get请求 和form 表单 // post 基本咩有
 */

public class FormRequest extends BaseRequest<FormRequest> {

    private final MultipartBody.Builder mBuilder;

    public FormRequest(@NonNull String url) {
        super(url);
        //有可能需要同时传递文件，所以选择这个form
        mBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
    }

    public FormRequest add(String key, String value) {
        if (TextUtils.isEmpty(key)) {
            return this;
        }
        if (TextUtils.isEmpty(value)) {
            mBuilder.addFormDataPart(key, "");
        } else {
            mBuilder.addFormDataPart(key, value);
        }
        return this;
    }

    public FormRequest add(String key, Object value) {
        if (TextUtils.isEmpty(key)) {
            return this;
        }
        if (value == null) {
            mBuilder.addFormDataPart(key, "\"\"");
        } else {
            mBuilder.addFormDataPart(key, String.valueOf(value));
        }
        return this;
    }

    public FormRequest addFile(String fileName,String filePath) {
        if (TextUtils.isEmpty(filePath))
            return this;
        mBuilder.addFormDataPart(fileName, fileName, RequestBody.create(MediaType.parse("image/png"), new File(filePath)));
        return this;
    }

    public FormRequest addFiles(List<String> files,String Name) {
        if (files == null || files.size() == 0) {
            return this;
        }
        String fileName="";
        if(TextUtils.isEmpty(Name)){
            fileName="files";
        }else{
            fileName=Name;
        }
        for (String str : files) {
            mBuilder.addFormDataPart(fileName, fileName, RequestBody.create(MediaType.parse("image/png"), new File(str)));
        }
        return this;
    }

    //异步请求
    public <T> void execute(BaseCallBack<T> callBack) {
        if (initPost()) return;
        //因为本App 目前是这样，这样的设计拓展性不好，头可以抽取来
        final Request request = new Request.Builder()
                .addHeader("Cookie", "token=" + SharedHelper.get(ConstantsPool.TOKEN, ""))
                .addHeader("Cookie", "app=android")
                .addHeader("Cookie", "version=" + UIUtils.getVersionCode())
                .url(mURI)
                .post(mBuilder.build())
                .build();
        perform(request, callBack);
    }

    //同步请求
    public <T> void executeSync(BaseCallBack<T> callBack) {
        if (initPost()) return;
        final Request request = new Request.Builder()
                .addHeader("Cookie", "token=" + SharedHelper.get(ConstantsPool.TOKEN, ""))
                .addHeader("Cookie", "app=android")
                .addHeader("Cookie", "version=" + UIUtils.getVersionCode())
                .url(mURI)
                .post(mBuilder.build())
                .build();
        performSync(request, callBack);
    }

    private boolean initPost() {
        if (TextUtils.isEmpty(mURI)) {
            //提示输入url
            return true;
        }
        for (Map.Entry<String, Object> param : mObjectMaps.entrySet()) {
            if (param.getKey() != null) {
                if (param.getValue() != null) {
                    mBuilder.addFormDataPart(param.getKey(), param.getValue().toString());
                } else {
                    mBuilder.addFormDataPart(param.getKey(), "");
                }
            }
        }
        return false;
    }

}
