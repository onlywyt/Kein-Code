package com.concurrent.source.thread.safety.threadlocaldemo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @program: source-demo
 * @description:
 * @ClassName：MyTransmittableThreadLocal
 * @author: Mr.Wang
 * @create: 2022-03-14 15:47
 **/
public class MyTransmittableThreadLocal<T> extends TransmittableThreadLocal<T> {
    @Override
    public Object copy(Object parentValue) {
        String jsonString = JSONObject.toJSONString(parentValue);
        return (T)JSONObject.parseObject(jsonString, parentValue.getClass());
    }
}
