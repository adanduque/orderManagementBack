package com.orderServices.micro_serv_oders.client;

import com.orderServices.micro_serv_oders.client.clientModel.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

@FeignClient(name = "customer-service", url = "http://localhost:8085/customers")
public interface CustomerClient {
    @GetMapping("/{id}")
    Customer getCustomerById(@PathVariable("id") Long id);
}
