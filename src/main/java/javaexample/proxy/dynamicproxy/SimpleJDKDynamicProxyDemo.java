package javaexample.proxy.dynamicproxy;

import java.lang.reflect.*;

/**
 * @program: source-demo
 * @description:  JDK的动态代理
 * @ClassName：SimpleJDKDynamicProxyDemo
 * @author: Mr.Wang
 * @create: 2022-03-14 10:30
 **/
public class SimpleJDKDynamicProxyDemo {

    static interface IService{
        void sayHello();
    }

    static class RealService implements IService{
        @Override
        public void sayHello() {
            System.out.println("DynamicProxy Hello");
        }
    }

    static class SimpleInvocationHandler implements InvocationHandler {
        private Object readlOBJ;
        //构造方法接收一个被代理的对象
        public SimpleInvocationHandler(Object readlOBJ){
            this.readlOBJ = readlOBJ;
        }

        /**
         * invoke方法处理所有的接口调用
         * @param proxy 表示代理对象本身，需要注意他不是被代理的对象，一般意义不大
         * @param method 表示被调用的方法
         * @param args 表示方法参数
         * @return
         * @throws Throwable
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("entering:" + method.getName());
            //传递实际对象realOBJ作为参数
            Object result = method.invoke(readlOBJ, args);
            System.out.println("leaving:" + method.getName());
            return result;
        }

    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        IService realService = new RealService();
        //java.lang.reflect包中的Proxy类的静态方法newProxyInstance来创建代理对象
        /**
         * 它有三个参数，具体如下。
         * 1）loader表示类加载器，例子使用和IService一样的类加载器。
         * 2）interfaces表示代理类要实现的接口列表，是一个数组，元素的类型只能是接口，不能是普通的类，
         * 例子中只有一个IService。
         * 3）h的类型为InvocationHandler，它是一个接口，也定义在java.lang.reflect包中，
         * 它只定义了一个方法invoke，对代理接口所有方法的调用都会转给该方法。
         */
//        IService proxy = (IService)Proxy.newProxyInstance(
//                IService.class.getClassLoader(),
//                new Class<?>[]{IService.class},
//                new SimpleInvocationHandler(realService)
//        );
//        proxy.sayHello();
        /*
            Proxy.getProxyClass需要两个参数：一个是ClassLoader；另一个是接口数组。它会动态生成一个类，类名以$Proxy开头，后跟一个数字。
         */
        //1）通过Proxy.getProxyClass创建代理类定义，类定义会被缓存；
        Class<?> proxyClass = Proxy.getProxyClass(IService.class.getClassLoader(), new Class[]{IService.class});
        //2）获取代理类的构造方法，构造方法有一个InvocationHandler类型的参数；
        Constructor<?> constructor = proxyClass.getConstructor(new Class[]{InvocationHandler.class});
        //3）创建InvocationHandler对象，创建代理类对象。
        SimpleInvocationHandler simpleInvocationHandler = new SimpleInvocationHandler(realService);
        IService o =  (IService)constructor.newInstance(simpleInvocationHandler);
        o.sayHello();
    }


}


