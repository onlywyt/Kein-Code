package javaexample.proxy.DI;

import javaexample.proxy.annotation.SimpleInject;
import javaexample.proxy.annotation.SimpleSingleton;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: source-demo
 * @description:
 * @ClassName：CGLibContainer
 * @author: Mr.Wang
 * @create: 2022-03-14 14:17
 **/
public class CGLibContainer {

    private static Map<Class<?>, Object> instances = new ConcurrentHashMap<>();
    public static <T> T getInstance(Class<T> clazz) throws InstantiationException, IllegalAccessException {
        boolean annotationPresent = clazz.isAnnotationPresent(SimpleSingleton.class);
        if (!annotationPresent){
            return createInstance(clazz);
        }
        Object obj = instances.get(clazz);
        if (obj != null) {
            return (T) obj;
        }
        synchronized (clazz){
            obj = instances.get(clazz);
            if (obj == null){
                obj = createInstance(clazz);
                instances.put(clazz,obj);
            }
        }
        return (T)obj;
    }

    private static <T> T createInstance(Class<T> clazz) throws InstantiationException, IllegalAccessException {
        T obj = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(SimpleInject.class)){
                if (!field.isAccessible()){
                    field.setAccessible(true);
                }
                Class<?> type = field.getType();
                field.set(obj,getInstance(type));
            }
        }
        return obj;
    }
}
