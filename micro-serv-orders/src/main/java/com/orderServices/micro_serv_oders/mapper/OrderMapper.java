package com.orderServices.micro_serv_oders.mapper;

import com.orderServices.micro_serv_oders.client.CustomerClient;
import com.orderServices.micro_serv_oders.client.ProductClient;
import com.orderServices.micro_serv_oders.client.clientModel.Customer;
import com.orderServices.micro_serv_oders.dto.ProductDto;
import com.orderServices.micro_serv_oders.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderMapper {

        @Autowired
        private  CustomerClient customerClient;

        @Autowired
        private  ProductClient productClient;


       /* public Mono<OrderCreateDto> toOrderDTO(Order order) {

          Mono<String> customerNameMono = Mono.fromCallable(() -> {
                Customer customer = customerClient.getCustomerById(Long.parseLong(order.getCustomerId()));
                return customer.getFirstName();
            });

            Flux<ProductDto> productsFlux = Flux.fromIterable(order.getProductIds())
                    .flatMap(productId -> productClient.getProductById(Long.parseLong(productId))
                            .map(product -> new ProductDto(
                                    product.getId(),
                                    product.getName(),
                                    product.getPrice()
                            ))
                    );

            return Mono.zip(customerNameMono, productsFlux.collectList())
                    .map(tuple -> new OrderCreateDto(
                            order.getId(),
                            tuple.getT1(),
                            tuple.getT2(),
                            order.getTotalAmount(),
                            order.getOrderDate().toString()
                    ));
        }*/
    }

