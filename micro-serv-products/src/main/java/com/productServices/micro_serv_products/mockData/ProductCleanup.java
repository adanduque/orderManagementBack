package com.productServices.micro_serv_products.mockData;

import com.productServices.micro_serv_products.repository.ProductRepository;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProductCleanup {

    @Autowired
    private ProductRepository productRepository;

    @PreDestroy
    public void cleanup() {
        productRepository.deleteAll();
    }
}
