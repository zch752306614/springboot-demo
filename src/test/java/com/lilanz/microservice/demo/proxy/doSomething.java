package com.lilanz.microservice.demo.proxy;

import com.lilanz.microservice.demo.proxy.cglibProxy.CglibProxy;
import com.lilanz.microservice.demo.proxy.jdkProxy.JDKProxy;
import com.lilanz.microservice.demo.proxy.staticProxy.StaticProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Alice
 * @version 1.0
 * @date 2021/3/26 9:45
 */
public class doSomething {
    public static void staticProxy() {
        GirlService girlService = new GirlServiceImpl();
        System.out.println("=======================================");
        System.out.println("静态代理开始");
        GirlService proxy = new StaticProxy(girlService);
        proxy.date();
        System.out.println("中场休息...");
        proxy.watchMovie();
        System.out.println("静态代理结束");
        System.out.println("=======================================");
    }

    public static void jdkProxy() {
        GirlService girlService = new GirlServiceImpl();
        System.out.println("JDK动态代理开始");
        System.out.println("=======================================");
        System.out.println("方法一：");
        JDKProxy JDKProxy = new JDKProxy(girlService);
        GirlService girl = (GirlService) JDKProxy.getProxyInstance();
        girl.date();
        System.out.println("中场休息...");
        girl.watchMovie();
        System.out.println("方法一结束");
        System.out.println("=======================================");
        System.out.println("=======================================");
        System.out.println("方法二：");
        JDKProxy invoke = new JDKProxy(girlService);
        GirlService proxy = (GirlService) Proxy.newProxyInstance(girlService.getClass().getClassLoader(), girlService.getClass().getInterfaces(), invoke);
        proxy.date();
        System.out.println("中场休息...");
        proxy.watchMovie();
        System.out.println("方法二结束");
        System.out.println("=======================================");
        System.out.println("=======================================");
        System.out.println("方法三：");
        GirlService target = (GirlService) Proxy.newProxyInstance(girlService.getClass().getClassLoader(), girlService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("准备");
                Object ret = method.invoke(girlService, args);
                System.out.println("善后");
                return ret;
            }
        });
        target.date();
        System.out.println("中场休息...");
        target.watchMovie();
        System.out.println("方法三结束");
        System.out.println("=======================================");
        System.out.println("JDK动态代理结束");
    }

    public static void cglibProxy() {
        GirlService girlService = new GirlServiceImpl();
        System.out.println("Cglib代理开始");
        System.out.println("=======================================");
        CglibProxy cglibProxy = new CglibProxy(girlService);
        GirlService proxy = (GirlService) cglibProxy.getProxyInstance();
        proxy.date();
        System.out.println("中场休息...");
        proxy.watchMovie();
        System.out.println("Cglib代理结束");
        System.out.println("=======================================");
    }

    public static void main(String[] args) {
        staticProxy();
        jdkProxy();
        cglibProxy();
    }

}
