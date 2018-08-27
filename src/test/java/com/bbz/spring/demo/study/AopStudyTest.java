package com.bbz.spring.demo.study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopStudyTest {

    @Test
    public void createObject() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        //这里创建一个空实现的调用处理器。
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                return null;
            }


        };
        Object obj = Proxy.newProxyInstance(classLoader, new Class[]{A.class, B.class}, invocationHandler);
        //强转为A和B接口类型，说明生成的代理对象实现了A和B接口
        A a = (A) obj;
        B b = (B) obj;

        System.out.println(obj.getClass().getCanonicalName());
    }
}