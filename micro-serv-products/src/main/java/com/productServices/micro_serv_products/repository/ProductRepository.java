package com.productServices.micro_serv_products.repository;

import com.productServices.micro_serv_products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllById(Iterable<Long> ids);

}
