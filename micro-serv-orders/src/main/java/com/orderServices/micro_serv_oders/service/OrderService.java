package com.orderServices.micro_serv_oders.service;

import com.orderServices.micro_serv_oders.dto.OrderRequestDto;
import com.orderServices.micro_serv_oders.model.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderService {
    Mono<Order> createOrder(OrderRequestDto order);
    Mono<Order> getOrderById(String id);
    Mono<Void> deleteOrder(String id);
    Flux<Order> getAllOrders();
}