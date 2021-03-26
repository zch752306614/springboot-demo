package com.lilanz.microservice.demo.designPattern.abstractFactoryPattern;

import com.lilanz.microservice.demo.designPattern.abstractFactoryPattern.Color.ColorFactory;
import com.lilanz.microservice.demo.designPattern.abstractFactoryPattern.shape.ShapeFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        }
        return null;
    }
}
