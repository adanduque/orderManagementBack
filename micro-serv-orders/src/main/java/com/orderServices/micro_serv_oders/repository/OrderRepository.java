package com.orderServices.micro_serv_oders.repository;

import com.orderServices.micro_serv_oders.model.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface OrderRepository extends ReactiveMongoRepository<Order, String> {
    Flux<Order> findByCustomerId(String customerId);
}