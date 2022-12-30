package com.niit.PizzaService.domain;

import org.springframework.data.annotation.Id;

import java.util.List;


public class Order {

    int orderId;
    List<FoodProduct> foodProducts;

    public Order(int orderId, List<FoodProduct> foodProducts) {
        this.orderId = orderId;
        this.foodProducts = foodProducts;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<FoodProduct> getFoodProducts() {
        return foodProducts;
    }

    public void setFoodProducts(List<FoodProduct> foodProducts) {
        this.foodProducts = foodProducts;
    }

    public Order() {
    }
}
