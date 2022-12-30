package com.niit.PizzaService.controller;

import com.niit.PizzaService.domain.FoodProduct;
import com.niit.PizzaService.domain.Order;
import com.niit.PizzaService.domain.User;
import com.niit.PizzaService.exception.UserAlreadyFoundException;
import com.niit.PizzaService.exception.UserNotFoundException;
import com.niit.PizzaService.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class PizzaController {

    PizzaService pizzaService;

    ResponseEntity responseEntity;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyFoundException {
        return new ResponseEntity<>(pizzaService.registerUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<?> saveOrderForUser(@PathVariable String userId,@RequestBody FoodProduct food) throws UserNotFoundException {
        return new ResponseEntity<>(pizzaService.addOrderToUser(userId,food),HttpStatus.CREATED);
    }
    @DeleteMapping("/user/{foodName}/{userId}")
    public ResponseEntity<?> deleteFoodFromUser(@PathVariable String foodName,@PathVariable String userId) throws UserNotFoundException {
        return new ResponseEntity<>(pizzaService.deleteFoodItemsFromList(userId,foodName),HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getOrderFromUser(@PathVariable String userId) throws UserNotFoundException {
        return new ResponseEntity<>(pizzaService.displayOrderFromUser(userId),HttpStatus.OK);
    }
}
