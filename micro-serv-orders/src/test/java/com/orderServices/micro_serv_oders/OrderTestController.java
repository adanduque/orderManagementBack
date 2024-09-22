package com.orderServices.micro_serv_oders;


import com.orderServices.micro_serv_oders.controller.OrderController;
import com.orderServices.micro_serv_oders.dto.OrderRequestDto;
import com.orderServices.micro_serv_oders.service.OrderService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest(OrderController.class)
public class OrderTestController {

    @Autowired
    WebTestClient webTestClient;

    @MockBean
    private OrderService orderService;

    @Test
    public void getAllOrders(){
        webTestClient.get().uri("/orders").exchange().expectStatus().isOk().expectBodyList(OrderRequestDto.class).hasSize(2);
    }
}
