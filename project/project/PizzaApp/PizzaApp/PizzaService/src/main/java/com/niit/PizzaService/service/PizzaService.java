package com.niit.PizzaService.service;

import com.niit.PizzaService.domain.FoodProduct;
import com.niit.PizzaService.domain.Order;
import com.niit.PizzaService.domain.User;
import com.niit.PizzaService.exception.UserAlreadyFoundException;
import com.niit.PizzaService.exception.UserNotFoundException;

import java.util.List;

public interface PizzaService {
    public User registerUser(User user) throws UserAlreadyFoundException;

    public User addOrderToUser(String userId, FoodProduct foodProduct) throws UserNotFoundException;

    public Order deleteFoodItemsFromList(String userId, String foodName) throws UserNotFoundException;

    public Order displayOrderFromUser(String userId) throws UserNotFoundException;
}