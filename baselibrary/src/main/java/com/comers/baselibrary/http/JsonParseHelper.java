package com.comers.baselibrary.http;

import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Comers on 2017/10/28.
 */

public class JsonParseHelper {
    public static String parse(Map<String,Object> map){
        if (map == null || map.isEmpty()) {
            return "";
        }
        JSONObject Jsonobject = new JSONObject();
        List<KeyValue> paramList = new ArrayList<KeyValue>();

        for (String key : map.keySet()) {
            paramList.add(new KeyValue(key, map.get(key)));
        }
        try {
            params2Json(Jsonobject, paramList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return String.valueOf(Jsonobject);
    }
    //生成JSONObject 对象
    private static void params2Json(final JSONObject jsonObject, final List<KeyValue> paramList) throws JSONException {
        HashSet<String> arraySet = new HashSet<String>(paramList.size());
        LinkedHashMap<String, JSONArray> tempData = new LinkedHashMap<String, JSONArray>(paramList.size());
        for (int i = 0; i < paramList.size(); i++) {
            KeyValue kv = paramList.get(i);
            final String key = kv.key;
            if (TextUtils.isEmpty(key)) continue;

            JSONArray ja = null;
            if (tempData.containsKey(key)) {
                ja = tempData.get(key);
            } else {
                ja = new JSONArray();
                tempData.put(key, ja);
            }

            ja.put(parseJSONObject(kv.value));

            if (kv instanceof ArrayItem) {
                arraySet.add(key);
            }
        }

        for (Map.Entry<String, JSONArray> entry : tempData.entrySet()) {
            String key = entry.getKey();
            JSONArray ja = entry.getValue();
            if (ja.length() > 1 || arraySet.contains(key)) {
                jsonObject.put(key, ja);
            } else {
                Object value = ja.get(0);
                jsonObject.put(key, value);
            }
        }
    }
    private static final ClassLoader BOOT_CL = String.class.getClassLoader();
    public final static class ArrayItem extends KeyValue {
        public ArrayItem(String key, Object value) {
            super(key, value);
        }
    }
     interface ParseKVListener {
        void onParseKV(String name, Object value);
    }

    /*package*/
    static void parseKV(Object entity, Class<?> type, ParseKVListener listener) {
        if (entity == null || type == null  || type == Object.class) {// || type == RequestParams.class
            return;
        } else {
            ClassLoader cl = type.getClassLoader();
            if (cl == null || cl == BOOT_CL) {
                return;
            }
        }

        Field[] fields = type.getDeclaredFields();
        if (fields != null && fields.length > 0) {
            for (Field field : fields) {
                if (!Modifier.isTransient(field.getModifiers())
                        && field.getType() != Parcelable.Creator.class) {
                    field.setAccessible(true);
                    try {
                        String name = field.getName();
                        Object value = field.get(entity);
                        if (value != null) {
                            listener.onParseKV(name, value);
                        }
                    } catch (IllegalAccessException ex) {
//                        LogUtil.e(ex.getMessage(), ex);
                        ex.getMessage();
                        Log.e("RequestParamsHelper", ex.getMessage());
                    }
                }
            }
        }

        parseKV(entity, type.getSuperclass(), listener);
    }

    /*package*/
    static Object parseJSONObject(Object value) throws JSONException {
        if (value == null) return null;

        Object result = value;
        Class<?> cls = value.getClass();
        if (cls.isArray()) {
            JSONArray array = new JSONArray();
            int len = Array.getLength(value);
            for (int i = 0; i < len; i++) {
                array.put(parseJSONObject(Array.get(value, i)));
            }
            result = array;
        } else if (value instanceof List) {
            JSONArray array = new JSONArray();
            List<?> list = (List<?>) value;
            for (Object item : list) {
                array.put(parseJSONObject(item));
            }
            result = array;
        } else if (value instanceof Map) {
            final JSONObject jo = new JSONObject();
            Map<?, ?> map = (Map<?, ?>) value;
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                Object k = entry.getKey();
                Object v = entry.getValue();
                if (k != null && v != null) {
                    jo.put(String.valueOf(k), parseJSONObject(v));
                }
            }
            result = jo;
        } else {
            ClassLoader cl = cls.getClassLoader();
            if (cl != null && cl != BOOT_CL) {
                final JSONObject jo = new JSONObject();
                parseKV(value, cls, new ParseKVListener() {
                    @Override
                    public void onParseKV(String name, Object value) {
                        try {
                            value = parseJSONObject(value);
                            jo.put(name, value);
                        } catch (JSONException ex) {
                            throw new IllegalArgumentException("parse RequestParams to json failed", ex);
                        }
                    }
                });
                result = jo;
            }
        }

        return result;
    }
}
