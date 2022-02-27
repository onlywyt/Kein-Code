package com.wangwenjun.concurrent.chapter10;

import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @program: source-demo
 * @description: 自定义类加载器；基于磁盘
 * @ClassName：MyClassLoader
 * @author: Mr.Wang
 * @create: 2022-02-25 10:45
 **/
public class MyClassLoader extends ClassLoader {


    //定义默认的class存放路径
    private final static Path DEFAULT_CLASS_PATH = Paths.get("/Users/yingtaowang/Desktop/classloader1");
    private final Path classDir;

    //使用默认的class路径
    public MyClassLoader() {
        super();
        this.classDir = DEFAULT_CLASS_PATH;
    }

    //允许传递指定的class路径
    public MyClassLoader(Path classDir){
        super();
        this.classDir = Paths.get(String.valueOf(classDir));;
    }

    //允许传递指定的class路径和父类加载器
    public MyClassLoader(Path classDir, ClassLoader parent){
        super();
        this.classDir = Paths.get(String.valueOf(classDir));;
    }

    /**
     *  根据类的全名称转换成文件的全路径重写findClass方法
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classBytes = this.readClassBytes(name);
        //为null则抛出异常
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
