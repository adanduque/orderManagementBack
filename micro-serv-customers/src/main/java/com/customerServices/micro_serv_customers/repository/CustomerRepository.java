package com.customerServices.micro_serv_customers.repository;

import com.customerServices.micro_serv_customers.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {


    @Query("SELECT c FROM Customer c WHERE c.numDocument = :numDocument")
    Customer findByDocument(@Param("numDocument") String numDocument);

    Optional<Customer> findTopByOrderByIdDesc();

}
