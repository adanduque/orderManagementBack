package com.orderServices.micro_serv_oders.controller;

import com.orderServices.micro_serv_oders.client.ProductClient;
import com.orderServices.micro_serv_oders.dto.OrderRequestDto;
import com.orderServices.micro_serv_oders.model.Order;
import com.orderServices.micro_serv_oders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductClient productClient;


    @GetMapping
    public Flux<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Order>> getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id)
                .map(order -> ResponseEntity.ok(order))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Order> createOrder(@RequestBody OrderRequestDto order) {
        return orderService.createOrder(order);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteOrder(@PathVariable String id) {
        return orderService.deleteOrder(id)
                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
    }

}