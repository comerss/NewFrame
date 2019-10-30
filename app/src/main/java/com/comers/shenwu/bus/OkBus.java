package com.comers.shenwu.bus;

import com.comers.baselibrary.http.PublicParamsIntercepter;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OkBus {
    public static OkBus Instance = new OkBus();
    Map<Class, HomeInterface> obs = new HashMap<>();
    Map<Class, List<MethodInfo>> methods = new HashMap<>();

    public void regist(HomeInterface object) {
        obs.put(object.getClass(), object);
    }

    public void post(String str) {
        List<HomeInterface> list = (List<HomeInterface>) obs.values();
        for (int i = 0; i < list.size(); i++) {
            List<MethodInfo> infos = methods.get(list.get(i));
            for (MethodInfo info:infos){
                if(info.getParamType().equals(str.getClass())){
                    list.get(i).postString(str);
                }
            }
        }
    }
}
