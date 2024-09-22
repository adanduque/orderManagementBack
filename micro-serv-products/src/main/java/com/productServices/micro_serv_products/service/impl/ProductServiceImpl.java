package com.productServices.micro_serv_products.service.impl;

import com.productServices.micro_serv_products.model.Product;
import com.productServices.micro_serv_products.repository.ProductRepository;
import com.productServices.micro_serv_products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl  implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    public List<Product> getProductsByIds(List<Long> ids) {
        return productRepository.findAllById(ids);
    }

}