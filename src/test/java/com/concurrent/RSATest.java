package com.concurrent;

import cn.hutool.core.codec.Base64;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * @program: source-demo
 * @description:
 * @ClassName：RSATest
 * @author: Mr.Wang
 * @create: 2022-02-21 16:41
 **/
@Log4j2
public class RSATest {

    @Test
    public void generateKeyBytes() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        //生成公钥私钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey aPublic = (RSAPublicKey)keyPair.getPublic();
        RSAPrivateKey aPrivate = (RSAPrivateKey) keyPair.getPrivate();
        log.info("private key:[{}]", Base64.encode(aPrivate.getEncoded()));
        log.info("public key:[{}]", Base64.encode(aPublic.getEncoded()));

    }

    //如果两个引用指向同一个对象，用 == 表示它们是相等的。如果两个引用指向不同的对象，用 == 表示它们是不相等的，即使它们的内容相同。
    @Test
    public void IntegerTest(){
        Integer a = 1000,b = 1000;
        Integer a1 = 100,b1 = 100;
        System.out.println(a == b);
        System.out.println(a1 == b1);



    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class cache = Integer.class.getDeclaredClasses()[0];
        Field myCache = cache.getDeclaredField("cache");
        myCache.setAccessible(true);
        Integer[] newCache = (Integer[]) myCache.get(cache);
        newCache[132] = newCache[134];
        int a = 2;
        int b = a + a;
        System.out.printf("%d + %d = %d", a, a, b);
    }
}
