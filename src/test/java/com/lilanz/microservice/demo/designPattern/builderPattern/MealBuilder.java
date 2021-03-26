package com.lilanz.microservice.demo.designPattern.builderPattern;

import com.lilanz.microservice.demo.designPattern.builderPattern.item.burger.ChickenBurger;
import com.lilanz.microservice.demo.designPattern.builderPattern.item.coldDrink.Coke;
import com.lilanz.microservice.demo.designPattern.builderPattern.item.coldDrink.Pepsi;
import com.lilanz.microservice.demo.designPattern.builderPattern.item.burger.VegBurger;

public class MealBuilder {
    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
