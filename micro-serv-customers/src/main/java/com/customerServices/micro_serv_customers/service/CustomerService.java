package com.customerServices.micro_serv_customers.service;

import com.customerServices.micro_serv_customers.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

import java.util.List;
import java.util.Optional;

public interface CustomerService {


    public List<Customer> getCustomers();


    public Customer getCustomerByDocument(String document);

    public Customer saveCustomer(Customer customer);

    public Customer getCustomerById(Long id);

    public Customer udapteCustomer(Customer customer);

    public Customer getLastCustomerById();
}
