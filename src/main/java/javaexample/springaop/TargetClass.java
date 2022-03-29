package javaexample.springaop;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @program: source-demo
 * @description:
 * @ClassName：TargetClass
 * @author: Mr.Wang
 * @create: 2022-03-15 16:12
 **/
@Component
public class TargetClass {
    public String test(String value){
        System.out.println("目标方法test被执行");
        if (!StringUtils.hasLength(value)){
            throw new RuntimeException("value 不能为null");
        }
        return value;
    }
}
