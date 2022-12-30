package com.niit.PizzaService.service;

import com.niit.PizzaService.domain.FoodProduct;
import com.niit.PizzaService.domain.Order;
import com.niit.PizzaService.domain.User;
import com.niit.PizzaService.exception.UserAlreadyFoundException;
import com.niit.PizzaService.exception.UserNotFoundException;
import com.niit.PizzaService.proxy.UserProxy;
import com.niit.PizzaService.repository.PizzaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class PizzaServiceImpl implements PizzaService {

    PizzaOrderRepository orderRepository;

    UserProxy userProxy;

    @Autowired
    public PizzaServiceImpl(PizzaOrderRepository orderRepository,UserProxy userProxy) {
        this.orderRepository = orderRepository;
        this.userProxy=userProxy;
    }

    @Override
    public User registerUser(User user) throws UserAlreadyFoundException {
        if (orderRepository.findById(user.getUserId()).isPresent()) {
            throw new UserAlreadyFoundException();
        }
        ResponseEntity responseEntity=userProxy.saveUser(user);
        return orderRepository.save(user);
    }

    @Override
    public User addOrderToUser(String userId, FoodProduct foodProduct) throws UserNotFoundException {
        if (orderRepository.findById(userId).isEmpty()) {
            throw new UserNotFoundException();
        }
        User user = orderRepository.findById(userId).get();
        Random random = new Random();

        if (user.getOrder() == null) {
            Order order = new Order();
            order.setOrderId(random.nextInt(100));
            List<FoodProduct> foodProductList = new ArrayList<>();
            foodProductList.add(foodProduct);
            order.setFoodProducts(foodProductList);
            user.setOrder(order);
        } else {
            Order order = user.getOrder();
            List<FoodProduct> foodList = order.getFoodProducts();
            foodList.add(foodProduct);
            order.setFoodProducts(foodList);
            user.setOrder(order);
        }
        return orderRepository.save(user);
    }

    @Override
    public Order deleteFoodItemsFromList(String userId, String foodName) throws UserNotFoundException {
        if (orderRepository.findById(userId).isEmpty()) {
            throw new UserNotFoundException();
        }
        User user = orderRepository.findById(userId).get();
        Order order = user.getOrder();
        List<FoodProduct> foodList = order.getFoodProducts();
        foodList.removeIf(p -> p.getFoodName().equals(foodName));
        order.setFoodProducts(foodList);
        user.setOrder(order);
        orderRepository.save(user);
        return order;

    }

    @Override
    public Order displayOrderFromUser(String userId) throws UserNotFoundException {
        if (orderRepository.findById(userId).isEmpty()) {
            throw new UserNotFoundException();
        }
        User user = orderRepository.findById(userId).get();
        return user.getOrder();
    }
}
