package com.lilanz.microservice.demo.proxy.staticProxy;

import com.lilanz.microservice.demo.proxy.GirlService;

/**
 * @author Alice
 * @version 1.0
 * @date 2021/3/26 9:40
 */
public class StaticProxy implements GirlService {
    private GirlService girlService;

    public StaticProxy(GirlService girlService) {
        this.girlService = girlService;
    }

    @Override
    public void date() {
        System.out.println("开始约会！");
        girlService.date();
        System.out.println("约会结束！");
    }

    @Override
    public void watchMovie() {
        System.out.println("开始看电影！");
        girlService.watchMovie();
        System.out.println("电影结束！");
        girlService.paPaPa();
    }

    @Override
    public void paPaPa() {

    }
}
