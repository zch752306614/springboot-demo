package com.lilanz.microservice.demo.designPattern.abstractFactoryPattern.Color;

public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("class.Green,method.fill()");
    }
}
