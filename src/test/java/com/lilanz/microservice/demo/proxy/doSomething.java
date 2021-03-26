package com.lilanz.microservice.demo.proxy;

import com.lilanz.microservice.demo.proxy.JDKProxy.GirlServiceJDKProxy;
import com.lilanz.microservice.demo.proxy.staticProxy.GirlServiceProxy;

/**
 * @author Alice
 * @version 1.0
 * @date 2021/3/26 9:45
 */
public class doSomething {
    public static void main(String[] args) {
        GirlService girlService = new GirlServiceImpl();

        System.out.println("=======================================");
        System.out.println("静态代理开始");
        GirlService proxy = new GirlServiceProxy(girlService);
        proxy.date();
        System.out.println("中场休息...");
        proxy.watchMovie();
        System.out.println("静态代理结束");
        System.out.println("=======================================");

        System.out.println("JDK动态代理开始");
        GirlServiceJDKProxy girlServiceJDKProxy = new GirlServiceJDKProxy(girlService);
        GirlService girl = (GirlService) girlServiceJDKProxy.getProxyInstance();
        girl.date();
        System.out.println("中场休息...");
        girl.watchMovie();
        System.out.println("JDK动态代理结束");
        System.out.println("=======================================");
    }
}
