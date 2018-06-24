package com.comers.baselibrary.http;

/**
 * Created by Comers on 2017/10/28.
 */

public class KeyValue {
    public final String key;
    public final Object value;

    public KeyValue(String key, Object value) {
        this.key = key;
        if(value == null){
            this.value = "";
        }else{
            this.value = value;
        }

    }

    public String getValueStr() {
        return value == null ? null : value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KeyValue keyValue = (KeyValue) o;

        return key == null ? keyValue.key == null : key.equals(keyValue.key);

    }

    @Override
    public int hashCode() {
        return key != null ? key.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "KeyValue{" + "key='" + key + '\'' + ", value=" + value + '}';
    }
}
