package com.lilanz.microservice.demo.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Alice
 * @version 1.0
 * @date 2021/3/26 9:40
 */
public class JDKProxy implements InvocationHandler {
    private Object target;

    public JDKProxy(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {
        doSomethingBefore();
        Object ret = method.invoke(target, objects);
        doSomethingAfter();
        return ret;
    }

    private void doSomethingBefore() {
        System.out.println("准备...");
    }

    private void doSomethingAfter() {
        System.out.println("善后...");
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

}
