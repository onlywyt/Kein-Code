package com.example.logbackdemo.com.wangwenjun.concurrent.chapter10;

import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @program: source-demo
 * @description: 自定义类加载器
 * @ClassName：MyClassLoader
 * @author: Mr.Wang
 * @create: 2022-02-25 10:45
 **/
public class MyClassLoader extends ClassLoader {


    //定义默认的class存放路径
    private final static Path DEFAULT_CLASS_PATH = Paths.get("/Users/yingtaowang/Documents/个人/code/wyt/source-demo/src/main/java/com/example/logbackdemo/com/wangwenjun/concurrent/chapter10/Hello");

    private final Path classDir;

    public MyClassLoader() {
        this.classDir = DEFAULT_CLASS_PATH;
    }

    public MyClassLoader(Path classDir, ClassLoader parent){

        this.classDir = Paths.get(String.valueOf(classDir));;
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

    @Override
    public String toString() {
        return "MyClassLoader{" +
                "classDir=" + classDir +
                '}';
    }
}
