package javaexample.proxy.staticProxy;

/**
 * @program: source-demo
 * @description: 静态代理
 * @ClassName：SimpleStaticProxyDemo
 * @author: Mr.Wang
 * @create: 2022-03-14 10:22
 **/
public class SimpleStaticProxyDemo {

    interface IService{
        void sayHello();
    }

    /**
     * 实际对象
     */
    static class RealService implements IService{
        @Override
        public void sayHello() {
            System.out.println("hello");
        }
    }

    /**
     * 代理对象
     */
    static class TraceProxy implements IService{
        //IService的成员变量，指向实际对象，在构造方法中被初始化
        private IService realService;
        public TraceProxy(IService realService){
            this.realService = realService;
        }

        @Override
        public void sayHello() {
            System.out.println("entering sayHello");
            this.realService.sayHello();
            System.out.println("leaving sayHello");
        }
    }

    public static void main(String[] args) {
        IService rawService = new RealService();
        IService proxyService = new TraceProxy(rawService);
        proxyService.sayHello();
    }

}
