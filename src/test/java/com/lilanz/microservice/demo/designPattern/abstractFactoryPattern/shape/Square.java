package com.lilanz.microservice.demo.designPattern.abstractFactoryPattern.shape;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("class.Shape,method.draw()");
    }
}
