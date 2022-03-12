package com.wangwenjun.concurrent.chapter10;


import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @program: source-demo
 * @description: /Users/yingtaowang/Desktop/classloader2/com/wangwenjun/concurrent/chapter10/SimpleClass.class
 * @ClassName：BrokerDelegateClassLoader
 * @author: Mr.Wang
 * @create: 2022-02-25 14:13
 **/
public class BrokerDelegateClassLoader extends ClassLoader {


    private final Path classDir;


    public BrokerDelegateClassLoader(Path classDir, ClassLoader parent){

        this.classDir = Paths.get(String.valueOf(classDir));;
    }


    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return loadClass(name, false);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            Class<?> klass = findLoadedClass(name);
            if (klass == null){
             if (name.startsWith("java") || name.startsWith("javax")){
                    try {
                        klass = getSystemClassLoader().loadClass(name);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        klass = this.findClass(name);
                    } catch (Exception e) {

                    }
                }
            }else {
                    try {
                        klass = this.findClass(name);
                    } catch (Exception e) {

                    }
                    if (klass == null){
                        if (getParent() != null) {
                            klass = getParent().loadClass(name);
                        } else {
                            klass = getSystemClassLoader().loadClass(name);
                        }
                    }
            }
            if (null == klass) {
                throw new ClassNotFoundException(name);
            }
            if (resolve){
                resolveClass(klass);
            }
            return klass;
        }
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classBytes = this.readClassBytes(name);
        if(null == classBytes || classBytes.length == 0){
            throw new ClassNotFoundException("Cant not load the calss" + name);
        }
        return this.defineClass(name,classBytes,0,classBytes.length);
    }
    //将class文件读入内存
    private byte[] readClassBytes(String name) throws ClassNotFoundException {
        String calassPath = name.replace(".","/");
        Path classFullPath = classDir.resolve(Paths.get(calassPath + ".class"));
        if (!classFullPath.toFile().exists()){
            throw new ClassNotFoundException("The class " + name + "not found");
        }
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            Files.copy(classFullPath,baos);
            return baos.toByteArray();
        } catch (Exception e) {
            throw new ClassNotFoundException("load the class " + name + "occur error.",e);
        }

    }
}
