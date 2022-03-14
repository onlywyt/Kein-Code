package com.concurrent.source.thread.safety;


import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;

/**
 * @program: source-demo
 * @description:
 * @ClassName：MyInheritableThreadLocal
 * @author: Mr.Wang
 * @create: 2022-03-13 16:46
 **/
public class MyInheritableThreadLocal<T> extends InheritableThreadLocal<T>{
    @Override
    protected T childValue(T parentValue) {
        String s = JSONObject.toJSONString(parentValue);
        return (T) JSONObject.parseObject(s, parentValue.getClass());
    }
}
