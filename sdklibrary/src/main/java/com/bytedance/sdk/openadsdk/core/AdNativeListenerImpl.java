/*     */
package com.bytedance.sdk.openadsdk.core;
/*     */
/*     */

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.ffff.SplashAdLoadManager;
import com.bytedance.sdk.openadsdk.core.nibuguan.f;
import com.bytedance.sdk.openadsdk.ggg.LogUtils;
import com.bytedance.sdk.openadsdk.ggg.PhoneUtils;
import com.bytedance.sdk.openadsdk.ggg.e;
import com.bytedance.sdk.openadsdk.ggg.q;

import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*     */ public class AdNativeListenerImpl implements AdNativeListener<com.bytedance.sdk.openadsdk.dddd.a>
        /*     */ {
    /*     */   private final Context a;
    /*     */   private final boolean b;
    public Context mContext;
    /*  98 */   private ExecutorService c = Executors.newFixedThreadPool(1);
    /*     */   private String d;

    /*     */
    /*     */   AdNativeListenerImpl(Context paramContext) {
        /* 102 */
        this.a = paramContext;
        mContext = paramContext;
        /* 103 */
        this.b = k();
        /* 104 */
        this.d = c();
        /*     */
    }
    /*     */
    /*     */

    private JSONObject a(AdSlot var1, int var2) {
        JSONObject var3 = new JSONObject();

        try {
            var3.put("id", var1.getCodeId());
            var3.put("adtype", var2);
            var3.put("pos", AdSlot.getPosition(var2));
            this.a(var3, "accepted_size", var1.getImgAcceptedWidth(), var1.getImgAcceptedHeight());
            var3.put("is_support_dpl", var1.isSupportDeepLink());
            int var4 = var1.getAdCount();
            if (var4 < 1) {
                var4 = 1;
            }

            if (var4 > 3) {
                var4 = 3;
            }

            var3.put("ad_count", var4);
        } catch (JSONException var5) {
            ;
        }

        return var3;
    }

    private JSONObject doParam(AdSlot var1, com.bytedance.sdk.openadsdk.core.nibuguan.i var2, int var3) {
        JSONObject var4 = new JSONObject();

        try {
            JSONObject var5 = new JSONObject();
            String var6 = var2 != null && !TextUtils.isEmpty(var2.a) ? var2.a : com.bytedance.sdk.openadsdk.ggg.r.f();
            var5.put("request_id", var6);
            var5.put("ad_sdk_version", "1.9.2");
            var5.put("source_type", "app");
            var5.put("app", this.d());
            JSONObject var7 = com.bytedance.sdk.openadsdk.ggg.d.d(this.a);
            if (var7 != null) {
                var7.put("orientation", var1.getOrientation());
            }

            var5.put("device", var7);
            var5.put("user", this.f());
            var5.put("ua", com.bytedance.sdk.openadsdk.core.r.a);
            var5.put("ip", this.h());
            JSONArray var8 = new JSONArray();
            var8.put(this.a(var1, var3));
            var5.put("adslots", var8);
            Log.i("Look", "get_ads参数--->" + var5.toString());
            String var9 = asa.a(var5.toString(), "b0458c2b262949b8");
            if (this.b(var9)) {
                var4.put("message", var9);
                var4.put("cipher", 1);
            } else {
                var4.put("message", var5.toString());
                var4.put("cipher", 0);
            }

            var4.put("ad_sdk_version", "1.9.2");
        } catch (JSONException var10) {
            ;
        }

        return var4;
    }

    /*     */
    /*     */
    public void getAds(AdSlot var1, com.bytedance.sdk.openadsdk.core.nibuguan.i var2, int var3, final OnAdLoad var4) {
        if (var4 != null) {
            if (this.a(var1.getCodeId())) {
                var4.onError(-8, ApiException.a(-8));
            } else {
                final JSONObject var5 = this.doParam(var1, var2, var3);
                if (var5 == null) {
                    var4.onError(-9, ApiException.a(-9));
                } else {
                    AQuery var6 = new AQuery(this.a);
                    AjaxCallback var7 = new AjaxCallback<String>() {
                        public void a(String var1, String var2, AjaxStatus var3) {
                            if (var3.getCode() == 200) {
                                if (TextUtils.isEmpty(var2)) {
                                    aaaa(var4);
                                    asasas(var3.getCode(), -1, var5.toString(), var2);
                                    return;
                                }

                                try {
                                    aClass var4x = aClass.a(new JSONObject(var2));
                                    if (!TextUtils.isEmpty(var4x.e) && !var4x.e.equals(com.bytedance.sdk.openadsdk.core.i.a(AdNativeListenerImpl.this.a))) {
                                        com.bytedance.sdk.openadsdk.core.i.a(AdNativeListenerImpl.this.a, var4x.e);
                                    }

                                    if (var4x.b != 20000) {
                                        var4.onError(var4x.b, ApiException.a(var4x.b));
                                        asasas(var3.getCode(), var4x.b, var5.toString(), var2);
                                        return;
                                    }

                                    if (var4x.d == null) {
                                        asasas(var3.getCode(), -1, var5.toString(), var2);
                                        aaaa(var4);
                                        return;
                                    }

                                    var4x.d.c(var2);
                                    var4.onSuccess(var4x.d);
                                } catch (JSONException var5x) {
                                    aaaa(var4);
                                    asasas(var3.getCode(), -1, var5.toString(), var2);
                                }
                            } else if (var3.getCode() > 0) {
                                var4.onError(var3.getCode(), var3.getMessage());
                                asasas(var3.getCode(), -1, var5.toString(), var2);
                            } else {
                                var4.onError(-2, ApiException.a(-2));
                                asasas(var3.getCode(), -2, var5.toString(), var2);
                            }

                        }
                    };
                    var7.timeout(1000000000);
                    AjaxCallback.setAgent(com.bytedance.sdk.openadsdk.core.r.a);
                    var6.post("https://i.snssdk.com/api/ad/union/sdk/get_ads/", var5, String.class, var7);
                }
            }
        }
    }

    /*     */
    /*     */
    /*     */
    /*     */
    private boolean a(String paramString)
    /*     */ {
        /* 147 */
       /* if (SslHepler.OnResult.Result()) {
            return true;
        }
        if (com.bytedance.sdk.openadsdk.core.cdsss.SslHepler.SslHepler().SslHepler(paramString)) {
            String str = com.bytedance.sdk.openadsdk.core.cdsss.SslHepler.SslHepler().cdsss();
            com.bytedance.sdk.openadsdk.LocationUtils.cdsss.SslHepler(this.SslHepler, str, System.currentTimeMillis());
            return true;
        }*/
        return false;
    }

    /*
    /*
    /*
    /*     */
    private int b(int paramInt) {
        /* 229 */
        return (paramInt == 3) || (paramInt == 4) ? 2000 : 10000;
        /*     */
    }

    /*     */
    /*     */
    private boolean b(String paramString) {
        /* 233 */
        return !q.a(paramString);
        /*     */
    }

    /*     */
    /*     */
    @WorkerThread
    /*     */ public com.bytedance.sdk.openadsdk.dddd.g a(List<com.bytedance.sdk.openadsdk.dddd.a> paramList)
    /*     */ {
        /* 239 */
        JSONObject localJSONObject = new JSONObject();
        /*     */
        try {
            /* 241 */
            localJSONObject.put("header", j());
            /* 242 */
            JSONArray localJSONArray = new JSONArray();
            /* 243 */
            for (Iterator localObject = paramList.iterator(); ((Iterator) localObject).hasNext(); ) {
                com.bytedance.sdk.openadsdk.dddd.a locala = (com.bytedance.sdk.openadsdk.dddd.a) ((Iterator) localObject).next();
                /* 244 */
                localJSONArray.put(locala.b);
                /*     */
            }
            /* 246 */
            localJSONObject.put("event", localJSONArray);
            /* 247 */
            localJSONObject.put("_gen_time", System.currentTimeMillis());
            /*     */
        }
        /*     */ catch (JSONException localJSONException) {
        }
        /*     */
        /* 251 */
        AjaxCallback localAjaxCallback = new AjaxCallback();
        /* 252 */
        localAjaxCallback.url("https://extlog.snssdk.com/service/2/app_log/");
        /* 253 */
        localAjaxCallback.type(String.class);
        /* 254 */
        localAjaxCallback.timeout(10000);
        /* 255 */
        AjaxCallback.setAgent(r.a);
        /* 256 */
        localAjaxCallback.method(1);
        /* 257 */
        Object localObject = SslHepler.a(localJSONObject.toString(), "a0497c2b26294048");
        /* 258 */
        LogUtils.b("adevent", "adevent is :" + localJSONObject.toString());
        /*     */
        try {
            /* 260 */
            if (!b((String) localObject)) {
                /* 261 */
                localAjaxCallback.param("%entity", new StringEntity(localJSONObject.toString(), "UTF-8"));
                /*     */
            } else {
                /* 263 */
                localAjaxCallback.param("%entity", new StringEntity((String) localObject, "UTF-8"));
                /*     */
            }
            /*     */
        }
        /*     */ catch (UnsupportedEncodingException localUnsupportedEncodingException) {
        }
        /*     */
        /* 268 */
        Map localMap = c((String) localObject);
        /* 269 */
        localAjaxCallback.headers(localMap);
        /* 270 */
        AQuery localAQuery = new AQuery(this.a);
        /* 271 */
        localAQuery.sync(localAjaxCallback);
        /* 272 */
        AjaxStatus localAjaxStatus = localAjaxCallback.getStatus();
        /* 273 */
        boolean bool1 = d((String) localAjaxCallback.getResult());
        /*     */
        /* 275 */
        boolean bool2 = false;
        /* 276 */
        String str;
        if ((localAjaxStatus.getCode() == 200) && (!bool1)) {
            /* 277 */
            str = "server say not success";
            /* 278 */
            bool2 = true;
            /*     */
        } else {
            /* 280 */
            str = localAjaxStatus.getMessage();
            /*     */
        }
        /* 282 */
        return new com.bytedance.sdk.openadsdk.dddd.g((localAjaxStatus.getCode() == 200) && (bool1), localAjaxStatus
/* 283 */.getCode(), str, bool2);
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void a(@NonNull com.bytedance.sdk.openadsdk.core.nibuguan.h paramh)
    /*     */ {
        /* 290 */
        JSONObject localJSONObject = b(paramh);
        /* 291 */
        if (localJSONObject == null) {
            /* 292 */
            return;
            /*     */
        }
        /* 294 */
        AjaxCallback localAjaxCallback = new AjaxCallback();
        /* 295 */
        localAjaxCallback.timeout(10000);
        /* 296 */
        AQuery localAQuery = new AQuery(this.a);
        /* 297 */
        localAQuery.post("https://i.snssdk.com/api/ad/union/dislike_event/", localJSONObject, String.class, localAjaxCallback);
        /*     */
    }

    /*     */
    /*     */
    @Nullable
    /*     */ private JSONObject b(@NonNull com.bytedance.sdk.openadsdk.core.nibuguan.h paramh) {
        /* 302 */
        JSONObject localJSONObject1 = new JSONObject();
        /* 303 */
        com.bytedance.sdk.openadsdk.ggg.a locala = com.bytedance.sdk.openadsdk.ggg.b.a(this.a);
        /*     */
        try {
            /* 305 */
            JSONObject localJSONObject2 = new JSONObject();
            /* 306 */
            localJSONObject2.put("action", "TTAdDislikeImpl");
            /* 307 */
            localJSONObject2.put("timestamp", System.currentTimeMillis());
            /* 308 */
            localJSONObject2.put("ad_sdk_version", "1.9.0");
            /* 309 */
            if (locala != null) {
                /* 310 */
                localJSONObject2.put("latitude", locala.a);
                /* 311 */
                localJSONObject2.put("longitude", locala.b);
                /*     */
            }
            /* 313 */
            localJSONObject2.put("extra", paramh.o());
            /* 314 */
            localJSONObject2.put("filter_words", c(paramh));
            /*     */
            /* 316 */
            JSONArray localJSONArray = new JSONArray();
            /* 317 */
            localJSONArray.put(localJSONObject2);
            /* 318 */
            localJSONObject1.put("actions", localJSONArray);
            /*     */
        }
        /*     */ catch (JSONException localJSONException) {
        }
        /* 321 */
        return localJSONObject1;
        /*     */
    }

    /*     */
    /*     */
    private void asasas(int paramInt1, int paramInt2, String paramString1, String paramString2) {
        /* 325 */
        JSONObject localJSONObject1 = new JSONObject();
        /* 326 */
        JSONArray localJSONArray = new JSONArray();
        /* 327 */
        JSONObject localJSONObject2 = new JSONObject();
        /*     */
        /*     */
        /*     */
        try
            /*     */ {
            /* 332 */
            localJSONObject1.putOpt("http_code", Integer.valueOf(paramInt1)).putOpt("client_code", Integer.valueOf(paramInt2)).putOpt("request_data", paramString1).putOpt("response_data", paramString2);
            /* 333 */
            localJSONArray.put(localJSONObject1);
            /* 334 */
            localJSONObject2.put("logs", localJSONArray);
            /* 335 */
            AjaxCallback localAjaxCallback = new AjaxCallback();
            /* 336 */
            localAjaxCallback.timeout(10000);
            /* 337 */
            AQuery localAQuery = new AQuery(this.a);
            /* 338 */
            localAQuery.post("https://is.snssdk.com/api/ad/union/sdk/upload/log/", localJSONObject2, String.class, localAjaxCallback);
            /*     */
        }
        /*     */ catch (Exception localException) {
        }
        /*     */
    }

    /*     */
    /*     */
    private JSONArray c(com.bytedance.sdk.openadsdk.core.nibuguan.h paramh) {
        /* 344 */
        if (paramh == null) {
            /* 345 */
            return null;
            /*     */
        }
        /* 347 */
        List localList = paramh.q();
        /* 348 */
        JSONArray localJSONArray = new JSONArray();
        /* 349 */
        if ((localList != null) && (!localList.isEmpty()))
            /*     */ {
            /* 351 */
            for (int i = 0; i < localList.size(); i++) {
                /* 352 */
                f localf = (f) localList.get(i);
                /* 353 */
                if (localf.c()) {
                    /* 354 */
                    localJSONArray.put(localf.a());
                    /*     */
                }
                /*     */
            }
            /*     */
        }
        /* 358 */
        return localJSONArray;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    @NonNull
    /*     */ private Map<String, String> c(String paramString)
    /*     */ {
        /* 365 */
        HashMap localHashMap = new HashMap();
        /* 366 */
        localHashMap.put("Content-Type", "application/json; charset=utf-8");
        /* 367 */
        if (b(paramString)) {
            /* 368 */
            localHashMap.put("Content-Encoding", "union_sdk_encode");
            /*     */
        }
        /* 370 */
        return localHashMap;
        /*     */
    }

    /*     */
    /*     */
    private boolean d(String paramString) {
        /* 374 */
        if (!TextUtils.isEmpty(paramString)) {
            /*     */
            try {
                /* 376 */
                JSONObject localJSONObject = new JSONObject(paramString);
                /* 377 */
                return localJSONObject.optString("message").equalsIgnoreCase("success");
                /*     */
            }
            /*     */ catch (JSONException localJSONException) {
            }
            /*     */
        }
        /* 381 */
        return false;
        /*     */
    }

    /*     */
    /*     */
    private void aaaa(OnAdLoad parama)
    /*     */ {
        /* 386 */
        parama.onError(-1, ApiException.a(-1));
        /*     */
    }

    /*     */
    /*     */
    private void aaaa(AdNativeListener.b paramb) {
        /* 390 */
        paramb.a(-1, ApiException.a(-1));
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    private String d()
    /*     */ {
        /* 399 */
        return UUID.randomUUID().toString();
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    private JSONObject e()
    /*     */ {
        /* 408 */
        JSONObject localJSONObject = new JSONObject();
        /*     */
        try {
            /* 410 */
            localJSONObject.put("appid", h.a().b());
            /* 411 */
            localJSONObject.put("name", h.a().c());
            /* 412 */
            a(localJSONObject);
            /* 413 */
            b(localJSONObject);
            /* 414 */
            localJSONObject.put("is_paid_app", h.a().d());
            /*     */
        }
        /*     */ catch (JSONException localJSONException) {
        }
        /* 417 */
        return localJSONObject;
        /*     */
    }

    /*     */
    /*     */
    private String f() {
        /* 421 */
        return com.bytedance.sdk.openadsdk.ggg.d.b();
        /*     */
    }

    /*     */
    /*     */
    private JSONObject g() {
        /* 425 */
        JSONObject localJSONObject = new JSONObject();
        /*     */
        try {
            /* 427 */
            localJSONObject.put("gender", h.a().f());
            /* 428 */
            if (h.a().e() > 0) {
                /* 429 */
                localJSONObject.put("age", h.a().e());
                /*     */
            }
            /* 431 */
            a(localJSONObject, "phone_nub", h());
            /* 432 */
            a(localJSONObject, "keywords", h.a().g());
            /* 433 */
            JSONArray localJSONArray = com.bytedance.sdk.openadsdk.ggg.i.a(this.a, this.c);
            /* 434 */
            if (localJSONArray != null) {
                /* 435 */
                localJSONObject.put("app_list", localJSONArray);
                /*     */
            }
            /* 437 */
            a(localJSONObject, "data", h.a().h());
            /*     */
        }
        /*     */ catch (JSONException localJSONException) {
        }
        /* 440 */
        return localJSONObject;
        /*     */
    }

    /*     */
    /*     */
    private void a(JSONObject paramJSONObject, String paramString1, String paramString2) throws JSONException
    /*     */ {
        /* 445 */
        if (!TextUtils.isEmpty(paramString2)) {
            /* 446 */
            paramJSONObject.put(paramString1, paramString2);
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    @SuppressLint("MissingPermission")
    private String h()
    /*     */ {
        /*     */
        try {
            /* 453 */
            @SuppressLint("WrongConstant") TelephonyManager localTelephonyManager = (TelephonyManager) this.a.getSystemService("phone");
            /* 454 */
            return localTelephonyManager.getLine1Number();
            /*     */
        } catch (Throwable localThrowable) {
        }
        /* 456 */
        return null;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void a(JSONObject paramJSONObject)
    /*     */ {
        /*     */
        try
            /*     */ {
            /* 499 */
            String str = this.a.getPackageName();
            /* 500 */
            paramJSONObject.put("package_name", str);
            /* 501 */
            paramJSONObject.put("version", this.a.getPackageManager().getPackageInfo(str, 0).versionCode + "");
            /*     */
        } catch (JSONException | PackageManager.NameNotFoundException localJSONException) {
            /* 503 */
            localJSONException.printStackTrace();
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    private void b(JSONObject paramJSONObject)
    /*     */ {
        /* 513 */
        com.bytedance.sdk.openadsdk.ggg.a locala = com.bytedance.sdk.openadsdk.ggg.b.a(this.a);
        /* 514 */
        if (locala != null) {
            /*     */
            try {
                /* 516 */
                JSONObject localJSONObject = new JSONObject();
                /* 517 */
                localJSONObject.put("latitude", locala.a);
                /* 518 */
                localJSONObject.put("longitude", locala.b);
                /* 519 */
                paramJSONObject.put("geo", localJSONObject);
                /*     */
            }
            /*     */ catch (JSONException localJSONException) {
            }
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    private String i() {
        /* 526 */
        return com.bytedance.sdk.openadsdk.ggg.d.a(true);
        /*     */
    }

    /*     */
    /*     */
    private JSONObject b(AdSlot paramAdSlot, int paramInt) {
        /* 530 */
        JSONObject localJSONObject = new JSONObject();
        /*     */
        try {
            /* 532 */
            localJSONObject.put("id", paramAdSlot.getCodeId());
            /* 533 */
            localJSONObject.put("adtype", paramInt);
            /* 534 */
            localJSONObject.put("pos", AdSlot.getPosition(paramInt));
            /* 535 */
            a(localJSONObject, "accepted_size", paramAdSlot.getImgAcceptedWidth(), paramAdSlot.getImgAcceptedHeight());
            /* 536 */
            localJSONObject.put("is_support_dpl", paramAdSlot.isSupportDeepLink());
            /* 537 */
            int i = paramAdSlot.getAdCount();
            /* 538 */
            if (i < 1) {
                /* 539 */
                i = 1;
                /*     */
            }
            /* 541 */
            if (i > 3) {
                /* 542 */
                i = 3;
                /*     */
            }
            /* 544 */
            localJSONObject.put("ad_count", i);
            /*     */
        }
        /*     */ catch (JSONException localJSONException) {
        }
        /* 547 */
        return localJSONObject;
        /*     */
    }

    /*     */
    /*     */
    private void a(JSONObject paramJSONObject, String paramString, int paramInt1, int paramInt2) {
        /* 551 */
        if ((paramInt1 > 0) && (paramInt2 > 0)) {
            /* 552 */
            JSONObject localJSONObject = new JSONObject();
            /* 553 */
            JSONArray localJSONArray = new JSONArray();
            /*     */
            try {
                /* 555 */
                localJSONObject.put("width", paramInt1);
                /* 556 */
                localJSONObject.put("height", paramInt2);
                /* 557 */
                localJSONArray.put(localJSONObject);
                /* 558 */
                paramJSONObject.put(paramString, localJSONArray);
                /*     */
            }
            /*     */ catch (JSONException localJSONException) {
            }
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    private JSONObject j() {
        /* 565 */
        JSONObject localJSONObject = new JSONObject();
        /*     */
        try {
            /* 567 */
            localJSONObject.put("ua", r.a);
            /* 568 */
            localJSONObject.put("udid", i.d(this.a));
            /* 569 */
            localJSONObject.put("openudid", i.c(this.a));
            /* 570 */
            localJSONObject.put("ad_sdk_version", 1);
            /* 571 */
            localJSONObject.put("sim_op", a(this.a));
            /* 572 */
            localJSONObject.put("root", this.b ? 1 : 0);
            /* 573 */
            localJSONObject.put("timezone", b());
            /* 574 */
            localJSONObject.put("access", PhoneUtils.netState(this.a));
            /* 575 */
            localJSONObject.put("os", "Android");
            /* 576 */
            localJSONObject.put("os_version", Build.VERSION.RELEASE);
            /* 577 */
            localJSONObject.put("os_api", Build.VERSION.SDK_INT);
            /* 578 */
            localJSONObject.put("device_type", this.d);
            /* 579 */
            localJSONObject.put("device_model", Build.MODEL);
            /* 580 */
            localJSONObject.put("device_brand", Build.BRAND);
            /* 581 */
            localJSONObject.put("device_manufacturer", Build.MANUFACTURER);
            /* 582 */
            localJSONObject.put("language", Locale.getDefault().getLanguage());
            /* 583 */
            DisplayMetrics localDisplayMetrics = this.a.getResources().getDisplayMetrics();
            /* 584 */
            localJSONObject.put("resolution", localDisplayMetrics.heightPixels + "x" + localDisplayMetrics.widthPixels);
            /* 585 */
            localJSONObject.put("display_density", a(localDisplayMetrics.densityDpi));
            /* 586 */
            localJSONObject.put("density_dpi", localDisplayMetrics.densityDpi);
            /* 587 */
            localJSONObject.put("mc", f());
            /* 588 */
            localJSONObject.put("device_id", i.a(this.a));
            /* 589 */
            localJSONObject.put("aid", 1181);
            /* 590 */
            localJSONObject.put("rom", a());
            /* 591 */
            localJSONObject.put("cpu_abi", Build.CPU_ABI);
            /* 592 */
            localJSONObject.put("build_serial", Build.SERIAL);
            /*     */
        }
        /*     */ catch (JSONException localJSONException) {
        }
        /* 595 */
        return localJSONObject;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    private static boolean k()
    /*     */ {
        /* 604 */
        boolean bool = false;
        /*     */
        try {
            /* 606 */
            if ((!new File("/system/bin/su").exists()) && (!new File("/system/xbin/su").exists())) {
                /* 607 */
                bool = false;
                /*     */
            } else {
                /* 609 */
                bool = true;
                /*     */
            }
            /*     */
        }
        /*     */ catch (Exception localException) {
        }
        /*     */
        /* 614 */
        return bool;
        /*     */
    }

    /*     */
    /*     */
    static String a(Context paramContext)
    /*     */ {
        /*     */
        try {
            /* 620 */
            @SuppressLint("WrongConstant") TelephonyManager localTelephonyManager = (TelephonyManager) paramContext.getSystemService("phone");
            /* 621 */
            return localTelephonyManager.getSimOperator();
            /*     */
        } catch (Throwable localThrowable) {
        }
        /* 623 */
        return "";
        /*     */
    }

    /*     */
    /*     */
    static String a()
    /*     */ {
        /* 628 */
        StringBuilder localStringBuilder = new StringBuilder();
        /*     */
        /*     */
        /*     */
        try
            /*     */ {
            /* 633 */
            if (com.bytedance.sdk.openadsdk.ggg.r.c()) {
                /* 634 */
                localStringBuilder.append("MIUI-");
                /* 635 */
            } else if (com.bytedance.sdk.openadsdk.ggg.r.d()) {
                /* 636 */
                localStringBuilder.append("FLYME-");
                /*     */
            } else {
                /* 638 */
                String str = com.bytedance.sdk.openadsdk.ggg.r.b();
                /* 639 */
                if (com.bytedance.sdk.openadsdk.ggg.r.a(str)) {
                    /* 640 */
                    localStringBuilder.append("EMUI-");
                    /*     */
                }
                /* 642 */
                if (!TextUtils.isEmpty(str)) {
                    /* 643 */
                    localStringBuilder.append(str).append("-");
                    /*     */
                }
                /*     */
            }
            /* 646 */
            localStringBuilder.append(Build.VERSION.INCREMENTAL);
            /*     */
        }
        /*     */ catch (Throwable localThrowable) {
        }
        /* 649 */
        return localStringBuilder.toString();
        /*     */
    }

    /*     */
    /*     */
    static String a(int paramInt) {
        /*     */
        String str;
        /* 654 */
        switch (paramInt) {
            /*     */
            case 120:
                /* 656 */
                str = "ldpi";
                /* 657 */
                break;
            /*     */
            case 240:
                /* 659 */
                str = "hdpi";
                /* 660 */
                break;
            /*     */
            case 160:
                /* 662 */
                str = "mdpi";
                /* 663 */
                break;
            /*     */
            case 320:
                /* 665 */
                str = "xhdpi";
                /* 666 */
                break;
            /*     */
            case 480:
                /* 668 */
                str = "xxhdpi";
                /* 669 */
                break;
            /*     */
            case 640:
                /* 671 */
                str = "xxxhdpi";
                /* 672 */
                break;
            /*     */
            default:
                /* 674 */
                str = "mdpi";
                /*     */
        }
        /*     */
        /* 677 */
        return str;
        /*     */
    }

    /*     */
    /*     */
    static int b() {
        /* 681 */
        TimeZone localTimeZone = TimeZone.getDefault();
        /* 682 */
        int i = localTimeZone.getRawOffset() / 3600000;
        /* 683 */
        if (i < -12)
            /* 684 */ i = -12;
        /* 685 */
        if (i > 12)
            /* 686 */ i = 12;
        /* 687 */
        return i;
        /*     */
    }

    /*     */
    /*     */
    public String c() {
        /* 691 */    /* if (LocationUtils.Result(this.SslHepler))
         *//* 692 *//*       return "tv";
         *//* 693 *//*     if (LocationUtils.SslHepler(this.SslHepler)) {
         *//* 694 *//*       return "android_pad";
         *//*     *//*     }*/
        /* 696 */
        return "android";
        /*     */
    }

    /*     */
    /*     */
    /*     */   public static class aClass
            /*     */ {
        /*     */     final int a;
        /*     */     final int b;
        /*     */     final String c;
        /*     */
        @Nullable
        /*     */ public final com.bytedance.sdk.openadsdk.core.nibuguan.a d;
        /*     */     final String e;

        /*     */
        /*     */
        private aClass(String paramString1, int paramInt1, int paramInt2, String paramString2, @Nullable com.bytedance.sdk.openadsdk.core.nibuguan.a parama)
        /*     */ {
            /* 711 */
            this.a = paramInt1;
            /* 712 */
            this.b = paramInt2;
            /* 713 */
            this.c = paramString2;
            /* 714 */
            this.d = parama;
            /* 715 */
            this.e = paramString1;
            /*     */
        }

        /*     */
        /*     */
        public static aClass a(JSONObject paramJSONObject) {
            /* 719 */
            String str1 = paramJSONObject.optString("did");
            /* 720 */
            int i = paramJSONObject.optInt("processing_time_ms");
            /* 721 */
            int j = paramJSONObject.optInt("status_code");
            /* 722 */
            String str2 = paramJSONObject.optString("request_id");
            /* 723 */
            com.bytedance.sdk.openadsdk.core.nibuguan.a locala = com.bytedance.sdk.openadsdk.core.b.a(paramJSONObject);
            /* 724 */
            if (locala != null)
                /*     */ {
                /* 726 */
                locala.a(paramJSONObject.optLong("request_after"));
                /*     */
            }
            /* 728 */
            return new aClass(str1, i, j, str2, locala);
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    public void a(JSONObject paramJSONObject, final AdNativeListener.b paramb)
    /*     */ {
        /* 734 */
        if ((paramJSONObject == null) || (paramb == null)) {
            /* 735 */
            return;
            /*     */
        }
        /* 737 */
        final JSONObject localJSONObject = c(paramJSONObject);
        /* 738 */
        AQuery localAQuery = new AQuery(this.a);
        new AjaxCallback() {
        };
        /* 739 */
        AjaxCallback local2 = new AjaxCallback()
                /*     */ {
            /*     */
            public void a(String paramAnonymousString1, String paramAnonymousString2, AjaxStatus paramAnonymousAjaxStatus) {
                /* 742 */
                if (paramAnonymousAjaxStatus.getCode() == 200) {
                    /* 743 */
                    if (TextUtils.isEmpty(paramAnonymousString2)) {
                        /* 744 */
                        aaaa(paramb);
                        /* 745 */
                        asasas(paramAnonymousAjaxStatus.getCode(), -1, localJSONObject.toString(), paramAnonymousString2);
                        /* 746 */
                        return;
                        /*     */
                    }
                    /*     */
                    try {
                        /* 749 */
                        cdsss localc = AdNativeListenerImpl.cdsss.a(new JSONObject(paramAnonymousString2));
                        /*     */
                        /* 751 */
                        if (localc.a != 20000) {
                            /* 752 */
                            paramb.a(localc.a, ApiException.a(localc.a));
                            /* 753 */
                            asasas(paramAnonymousAjaxStatus.getCode(), localc.a, localJSONObject.toString(), paramAnonymousString2);
                            /* 754 */
                            return;
                            /*     */
                        }
                        /* 756 */
                        if (localc.c == null) {
                            /* 757 */
                            asasas(paramAnonymousAjaxStatus.getCode(), -1, localJSONObject.toString(), paramAnonymousString2);
                            /* 758 */              /* 744 */
                            aaaa(paramb);
                            /* 759 */
                            return;
                            /*     */
                        }
                        /* 761 */
                        paramb.a(localc);
                        /*     */
                    } catch (JSONException localJSONException) {
                        /* 763 */
                        aaaa(paramb);
                        /* 764 */
                        asasas(paramAnonymousAjaxStatus.getCode(), -1, localJSONObject.toString(), paramAnonymousString2);
                        /*     */
                    }
                    /*     */
                }
                /* 767 */
                if (paramAnonymousAjaxStatus.getCode() > 0)
                    /*     */ {
                    /* 769 */
                    paramb.a(paramAnonymousAjaxStatus.getCode(), paramAnonymousAjaxStatus.getMessage());
                    /* 770 */
                    asasas(paramAnonymousAjaxStatus.getCode(), -1, localJSONObject.toString(), paramAnonymousString2);
                    /*     */
                }
                /*     */
                else {
                    /* 773 */
                    paramb.a(-2, ApiException.a(-2));
                    /* 774 */
                    asasas(paramAnonymousAjaxStatus.getCode(), -2, localJSONObject.toString(), paramAnonymousString2);
                    /*     */
                }
                /*     */
                /*     */
            }
            /* 778 */
        };
        /* 779 */
        local2.timeout(10000);
        /* 780 */
        localAQuery.post("https://is.snssdk.com/api/ad/union/sdk/reward_video/reward/", localJSONObject, String.class, local2);
        /*     */
    }

    /*     */
    /*     */
    private JSONObject c(JSONObject paramJSONObject) {
        /* 784 */
        JSONObject localJSONObject = new JSONObject();
        /*     */
        try {
            /* 786 */
            String str = SslHepler.a(paramJSONObject.toString(), "b0458c2b262949b8");
            /* 787 */
            if (b(str)) {
                /* 788 */
                localJSONObject.put("cipher", 1);
                /* 789 */
                localJSONObject.put("message", str);
                /*     */
            } else {
                /* 791 */
                localJSONObject.put("cipher", 0);
                /* 792 */
                localJSONObject.put("message", paramJSONObject.toString());
                /*     */
            }
            /*     */
        }
        /*     */ catch (JSONException localJSONException) {
        }
        /* 796 */
        return localJSONObject;
        /*     */
    }

    /*     */
    /*     */   public static class cdsss {
        /*     */     public final int a;
        /*     */     public final boolean b;
        /*     */     public final com.bytedance.sdk.openadsdk.core.nibuguan.l c;

        /*     */
        /*     */
        private cdsss(int paramInt, boolean paramBoolean, com.bytedance.sdk.openadsdk.core.nibuguan.l paramj) {
            /* 805 */
            this.a = paramInt;
            /* 806 */
            this.b = paramBoolean;
            /* 807 */
            this.c = paramj;
            /*     */
        }

        /*     */
        /*     */
        public static cdsss a(JSONObject paramJSONObject) {
            /* 811 */
            if (paramJSONObject == null) {
                /* 812 */
                return null;
                /*     */
            }
            /* 814 */
            int i = paramJSONObject.optInt("code");
            /* 815 */
            boolean bool = paramJSONObject.optBoolean("verify");
            /* 816 */
            JSONObject localJSONObject = paramJSONObject.optJSONObject("data");
            /* 817 */
            com.bytedance.sdk.openadsdk.core.nibuguan.l localj = new com.bytedance.sdk.openadsdk.core.nibuguan.l();
            /*     */
            try {
                /* 819 */
                if (localJSONObject != null) {
                    /* 820 */
                    localj.a(localJSONObject.optInt("reason"));
                    /* 821 */
                    localj.b(localJSONObject.optInt("corp_type"));
                    /* 822 */
                    localj.c(localJSONObject.optInt("reward_amount"));
                    /* 823 */
                    localj.a(localJSONObject.optString("reward_name"));
                    /*     */
                }
                /*     */
            } catch (Throwable localThrowable) {
                /* 826 */
                localThrowable.printStackTrace();
                /*     */
            }
            /* 828 */
            return new cdsss(i, bool, localj);
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    public void a(int paramInt, String paramString1, String paramString2, Bitmap paramBitmap)
    /*     */ {
        /* 834 */
        HashMap localHashMap = new HashMap();
        /* 835 */
        localHashMap.put("rit", Integer.valueOf(paramInt));
        /* 836 */
        localHashMap.put("req_id", paramString1);
        /* 837 */
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        /* 838 */
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 50, localByteArrayOutputStream);
        /* 839 */
        localHashMap.put("image", localByteArrayOutputStream.toByteArray());
        /*     */
        try {
            /* 841 */
            localByteArrayOutputStream.close();
            /*     */
        } catch (IOException localIOException) {
            /* 843 */
            localIOException.printStackTrace();
            /*     */
        }
        /* 845 */
        localHashMap.put("ad_id", paramString2);
        /* 846 */
        localHashMap.put("sign", e.b(paramString1 + ":" + paramInt));
        /* 847 */
        AjaxCallback local3 = new AjaxCallback()
                /*     */ {
            /*     */
            public void a(String paramAnonymousString1, String paramAnonymousString2, AjaxStatus paramAnonymousAjaxStatus) {
                /* 850 */
                super.callback(paramAnonymousString1, paramAnonymousString2, paramAnonymousAjaxStatus);
                /*     */
            }
            /*     */
            /* 853 */
        };
        /* 854 */
        local3.url("https://i.snssdk.com/union/service/sdk/upload/");
        /* 855 */
        local3.type(String.class);
        /* 856 */
        local3.timeout(10000);
        /* 857 */
        local3.method(1);
        /* 858 */
        local3.params(localHashMap);
        /* 859 */
        AQuery localAQuery = new AQuery(this.a);
        /* 860 */
        localAQuery.ajax(local3);
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    private JSONObject a(String paramString1, String paramString2)
    /*     */ {
        /* 886 */
        JSONObject localJSONObject = new JSONObject();
        /*     */
        try {
            /* 888 */
            String str1 = SslHepler.a(paramString1, "b0458c2b262949b8");
            /* 889 */
            int i = (int) (System.currentTimeMillis() / 1000L);
            /* 890 */
            StringBuffer localStringBuffer = new StringBuffer("id=");
            /* 891 */
            localStringBuffer.append(str1 + "&timestamp=");
            /* 892 */
            localStringBuffer.append(i + "&ext=");
            /* 893 */
            localStringBuffer.append(paramString2);
            /* 894 */
            String str2 = e.a(localStringBuffer.toString()).toUpperCase();
            /* 895 */
            localJSONObject.put("id", str1);
            /* 896 */
            localJSONObject.put("timestamp", i);
            /* 897 */
            localJSONObject.put("sign", str2);
            /* 898 */
            localJSONObject.put("ext", paramString2);
            /*     */
        }
        /*     */ catch (Exception localException) {
        }
        /* 901 */
        return localJSONObject;
        /*     */
    }

    /*     */
    /*     */
    public void a(String paramString1, String paramString2, final SplashAdLoadManager.a parama)
    /*     */ {
        /* 906 */
        if ((paramString1 == null) || (paramString2 == null) || (parama == null)) {
            /* 907 */
            return;
            /*     */
        }
        /* 909 */
        JSONObject localJSONObject = a(paramString1, paramString2);
        /* 910 */
        AQuery localAQuery = new AQuery(this.a);
        /* 911 */
        AjaxCallback local4 = new AjaxCallback()
                /*     */ {
            /*     */
            public void a(String paramAnonymousString1, String paramAnonymousString2, AjaxStatus paramAnonymousAjaxStatus) {
                /* 914 */
                if (paramAnonymousAjaxStatus.getCode() == 200) {
                    /* 915 */
                    if (TextUtils.isEmpty(paramAnonymousString2)) {
                        /* 916 */
                        parama.a(true);
                        /* 917 */
                        return;
                        /*     */
                    }
                    /*     */
                    try {
                        /* 920 */
                        Result localb = Result.a(new JSONObject(paramAnonymousString2));
                        /* 921 */
                        if ((localb.a == 0) && (!localb.b)) {
                            /* 922 */
                            parama.a(false);
                            /* 923 */
                            return;
                            /*     */
                        }
                        /*     */
                    }
                    /*     */ catch (JSONException localJSONException) {
                    }
                    /*     */
                }
                /*     */
                /* 929 */
                parama.a(true);
                /*     */
            }
            /* 931 */
        };
        /* 932 */
        local4.timeout(800);
        /* 933 */
        localAQuery.post("https://is.snssdk.com/api/ad/union/sdk/material/check/", localJSONObject, String.class, local4);
        /*     */
    }

    /*     */
    /*     */   public static class Result {
        /*     */     public final int a;
        /*     */     public final boolean b;

        /*     */
        /*     */
        private Result(int paramInt, boolean paramBoolean) {
            /* 941 */
            this.a = paramInt;
            /* 942 */
            this.b = paramBoolean;
            /*     */
        }

        /*     */
        /*     */
        public static Result a(JSONObject paramJSONObject) {
            /* 946 */
            if (paramJSONObject == null) {
                /* 947 */
                return null;
                /*     */
            }
            /* 949 */
            int i = paramJSONObject.optInt("error_code");
            /* 950 */
            boolean bool = paramJSONObject.optBoolean("Result");
            /* 951 */
            return new Result(i, bool);
            /*     */
        }
        /*     */
    }
    /*     */
}


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\mP.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */