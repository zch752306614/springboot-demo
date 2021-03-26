package com.lilanz.microservice.demo.proxy.cglibProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Alice
 * @version 1.0
 * @date 2021/3/26 15:30
 */
public class CglibProxy implements MethodInterceptor {
    private Object object;

    public CglibProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        doSomethingBefore();
        Object ret = method.invoke(object);
        doSomethingAfter();
        return ret;
    }

    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    private void doSomethingBefore() {
        System.out.println("准备...");
    }

    private void doSomethingAfter() {
        System.out.println("善后...");
    }

}
