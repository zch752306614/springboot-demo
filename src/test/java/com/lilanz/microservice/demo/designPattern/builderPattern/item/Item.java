package com.lilanz.microservice.demo.designPattern.builderPattern.item;

import com.lilanz.microservice.demo.designPattern.builderPattern.packing.Packing;

public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
