package com.lilanz.microservice.demo.proxy.JDKProxy;

import com.lilanz.microservice.demo.proxy.GirlService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Alice
 * @version 1.0
 * @date 2021/3/26 9:40
 */
public class GirlServiceJDKProxy implements InvocationHandler {
    private GirlService girlService;

    public GirlServiceJDKProxy(GirlService girlService) {
        super();
        this.girlService = girlService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doSomethingBefore();
        Object ret = method.invoke(girlService, args);
        doSomethingAfter();
        return ret;
    }

    private void doSomethingBefore() {
        System.out.println("准备...");
    }

    private void doSomethingAfter() {
        girlService.paPaPa();
        System.out.println("善后...");
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(girlService.getClass().getClassLoader(), girlService.getClass().getInterfaces(), this);
    }

}
