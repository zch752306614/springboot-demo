package com.lilanz.microservice.demo.designPattern.abstractFactoryPattern;

import com.lilanz.microservice.demo.designPattern.abstractFactoryPattern.Color.Color;
import com.lilanz.microservice.demo.designPattern.abstractFactoryPattern.shape.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor(String colorType);
    public abstract Shape getShape(String shapeType);
}
