package com.donews.frame.camera;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;

import com.comers.baselibrary.base.CrashHelper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.GZIPOutputStream;

import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;


/**
 * Created by 79653 on 2018/7/2.
 * 描述：
 */
public class JavaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CrashHelper.getDefault().init(this);
        initData();
    }

    private void initData() {
//        sendReport();
//        ex();
    }

    private void ex() {
        Single.just("999")
                .subscribe(new Consumer<String>() {
                               @Override
                               public void accept(String s) throws Exception {

                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                            }
                        }
                );

    }

    private void sendReport() {

    }

    public void uploadlog() {
        String username = "cm9vdA==";
        String password = "ZG9uZXdzMTIz";
        /*
        oss_userinfo
        https://api.g.com.cn/oss_userinfo?appid&version
        default:
        {username: "cm9vdA==", password = "ZG9uZXdzMTIz", uploadaddress =  http://minio-db.xy.huijitrans.com/put"}
        */
        byte[] busername = Base64.decode(username, Base64.DEFAULT);
        byte[] bpasword = Base64.decode(password, Base64.DEFAULT);
        final String name = new String(busername);
        final String passwd = new String(bpasword);

        OkHttpClient client = new OkHttpClient.Builder()
                .authenticator(new Authenticator() {
                    @Override
                    public Request authenticate(Route route, Response response) throws IOException {
                        String credential = Credentials.basic(name, passwd, Charset.forName("UTF-8"));
                        return response.request().newBuilder().header("Authorization", credential).build();
                    }
                })
                .build();

        StringBuilder sb = null;
        try {
            sb = new StringBuilder();
            for (int n = 0; n < 1000; n++) {
                sb.append(n);
                sb.append(",");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Response response = null;
        try {
            //压缩一下，效果更好
            //Gzip
            byte[] buffer = gzip(sb.toString());
            RequestBody body = RequestBody.create(MediaType.parse("application/octet-stream"), buffer);//file 可以上传一个文件
            Request request = new Request.Builder()
                    .url("http://minio-db.xy.huijitrans.com/put/yinli/2199777/log_yyyyMMddhhmmssSSS.txt")
                    .put(body)
                    .build();
            response = client.newCall(request).execute();
            Log.i("TAG", response.code() + ":" + response.body().string());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {

            }
        }
    }

    public static byte[] gzip(String unGzipStr) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream(baos);
            gzip.write(unGzipStr.getBytes());
            gzip.close();
            byte[] encode = baos.toByteArray();
            baos.flush();
            baos.close();
            return encode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
