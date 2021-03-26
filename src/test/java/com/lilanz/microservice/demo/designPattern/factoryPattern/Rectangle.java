package com.lilanz.microservice.demo.designPattern.factoryPattern;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("class.Rectangle,method.draw()");
    }
}
