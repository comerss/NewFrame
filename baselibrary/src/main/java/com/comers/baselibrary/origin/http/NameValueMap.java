package com.comers.baselibrary.origin.http;

import java.util.Map;

/**
 * @author nate
 */
public interface NameValueMap<K, V> extends Map<K, V> {

    String get(String name);

    void set(String name, String value);

    void setAll(Map<String, String> map);
}
