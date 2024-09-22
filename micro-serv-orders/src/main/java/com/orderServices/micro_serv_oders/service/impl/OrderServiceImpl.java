package com.orderServices.micro_serv_oders.service.impl;

import com.orderServices.micro_serv_oders.client.CustomerClient;
import com.orderServices.micro_serv_oders.client.ProductClient;
import com.orderServices.micro_serv_oders.client.clientModel.Customer;
import com.orderServices.micro_serv_oders.client.clientModel.Product;
import com.orderServices.micro_serv_oders.dto.OrderDetail;
import com.orderServices.micro_serv_oders.dto.OrderRequestDto;
import com.orderServices.micro_serv_oders.mapper.OrderMapper;
import com.orderServices.micro_serv_oders.model.Order;
import com.orderServices.micro_serv_oders.model.OrderDetailDb;
import com.orderServices.micro_serv_oders.repository.OrderRepository;
import com.orderServices.micro_serv_oders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductClient productClient;

    @Override
    public Flux<Order> getAllOrders() {
        // Se recuperan todas las órdenes desde el repositorio de forma reactiva
        return orderRepository.findAll();
    }

    @Override
    public Mono<Order> getOrderById(String id) {
        // Recupera una orden por su ID utilizando el repositorio reactivo
        return orderRepository.findById(id);
    }

    @Override
    public Mono<Order> createOrder(OrderRequestDto orderDto) {
        String customerId = orderDto.getCustomerId();

        Customer customer = customerClient.getCustomerById(Long.valueOf(customerId));

        Order orderSave = new Order();
        orderSave.setCustomerId(customerId);
        orderSave.setAddress(orderDto.getAddress());
        orderSave.setOrderDate(LocalDateTime.now());
        orderSave.setStatus("Pending");

        List<OrderDetail> orderDetailsList = orderDto.getOrderDetail();

        return productClient.getProductsByIds(
                orderDetailsList.stream()
                        .map(OrderDetail::getProductId)
                        .collect(Collectors.toList())
        ).flatMap(products -> {
            List<OrderDetailDb> orderDetailDbs = new ArrayList<>();
            double totalAmount = 0.0;

            for (OrderDetail orderDetails : orderDetailsList) {
                Product product = products.stream()
                        .filter(p -> p.getId().equals(orderDetails.getProductId()))
                        .findFirst()
                        .orElse(null);

                if (product != null) {
                    double price = product.getPrice();
                    OrderDetailDb orderDetailDb = new OrderDetailDb(orderDetails.getProductId(), orderDetails.getQuantity(), price);
                    orderDetailDbs.add(orderDetailDb); // Agregar a la lista de detalles de la orden
                    totalAmount += price * orderDetails.getQuantity();
                }
            }

            orderSave.setOrderDetails(orderDetailDbs); // Establecer detalles en la orden
            orderSave.setTotalAmount(totalAmount);

            return orderRepository.save(orderSave);
        });
    }

    public Mono<Void> deleteOrder(String id) {
        return orderRepository.deleteById(id);
    }
}