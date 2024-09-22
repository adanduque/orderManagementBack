package com.productServices.micro_serv_products.service;


import com.productServices.micro_serv_products.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    Product createProduct(Product product);
    void deleteProduct(Long id);
    List<Product> getProductsByIds(List<Long> ids);

}