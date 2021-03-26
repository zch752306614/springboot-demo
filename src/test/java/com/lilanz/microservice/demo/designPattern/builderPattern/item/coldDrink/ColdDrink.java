package com.lilanz.microservice.demo.designPattern.builderPattern.item.coldDrink;

import com.lilanz.microservice.demo.designPattern.builderPattern.item.Item;
import com.lilanz.microservice.demo.designPattern.builderPattern.packing.Bottle;
import com.lilanz.microservice.demo.designPattern.builderPattern.packing.Packing;

public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
