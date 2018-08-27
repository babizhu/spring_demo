package com.bbz.spring.demo.study;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

interface A {
    void a();
}

interface B {
    void b();
}

public class AopStudy {
    public void createObject() {

        /**
         * 三个参数
         * 1、ClassLoader
         * 方法需要动态生成一个类，这个类实现了A和B两个接口，然后创建这个类的对象
         * 需要生成一个类，这个类也需要加载到方法区中，所以我们需要一个ClassLoader来加载该类
         *
         * 2、Class[] interfaces
         * 我们需要代理对象实现的数组
         *
         * 3、InvocationHandler
         * 调用处理器
         */
//        ClassLoader classLoader = this.getClass().getClassLoader();
//        //这里创建一个空实现的调用处理器。
//        InvocationHandler invocationHandler = new InvocationHandler() {
//            @Override
//            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
//                return null;
//            }
//
//
//        };
//        Object obj = Proxy.newProxyInstance(classLoader, new Class[]{A.class, B.class}, invocationHandler);
//        //强转为A和B接口类型，说明生成的代理对象实现了A和B接口
//        A a = (A) obj;
//        B b = (B) obj;
//
//        System.out.println(obj.getClass().getCanonicalName());
    }

    public static void main(String[] args) {
        new AopStudy().createObject();
    }

}
