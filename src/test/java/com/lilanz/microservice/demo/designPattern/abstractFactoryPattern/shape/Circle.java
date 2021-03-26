package com.lilanz.microservice.demo.designPattern.abstractFactoryPattern.shape;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("class.Circle,method.draw()");
    }
}
