package com.niit.PizzaService.repository;

import com.niit.PizzaService.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PizzaOrderRepository extends MongoRepository<User,String> {
}
