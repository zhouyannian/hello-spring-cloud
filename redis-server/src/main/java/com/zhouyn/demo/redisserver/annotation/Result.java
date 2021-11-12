package com.zhouyn.demo.redisserver.annotation;

import java.io.Serializable;

public interface Result<T> extends Serializable {
    String getCode();

    void setCode(String var1);

    String getMsg();

    void setMsg(String var1);

    T getData();

    void setData(T var1);

    default String toJson() {
        return JsonUtils.objectToJson(this);
    }
}

