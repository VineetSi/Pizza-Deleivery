package com.niit.PizzaService.domain;

import org.springframework.data.annotation.Id;

public class FoodProduct {

    private String foodName;
    private int price;

    public FoodProduct() {
    }

    public FoodProduct(String foodName, int price) {
        this.foodName = foodName;
        this.price = price;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
