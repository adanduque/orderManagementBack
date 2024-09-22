package com.customerServices.micro_serv_customers.service.impl;

import com.customerServices.micro_serv_customers.models.Customer;
import com.customerServices.micro_serv_customers.repository.CustomerRepository;
import com.customerServices.micro_serv_customers.service.CustomerService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }


    @Override
    @CircuitBreaker(name = "customerServiceCircuitBreaker", fallbackMethod = "fallbackCustomer")
   // @TimeLimiter(name = "customerServiceTimeLimiter", fallbackMethod = "fallbackCustomer")
       public Customer getCustomerByDocument(String document) {
        if ("999999999".equals(document)) {
            // Simula un error si el documento es 999999999
            throw new RuntimeException("Simulated error for document 999999999");
        }
        return customerRepository.findByDocument(document);
    }

    @Override
    @CircuitBreaker(name = "customerServiceCircuitBreaker", fallbackMethod = "fallbackSaveCustomer")
    //@TimeLimiter(name = "customerServiceTimeLimiter", fallbackMethod = "fallbackSaveCustomer")
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    @CircuitBreaker(name = "customerServiceCircuitBreaker", fallbackMethod = "fallbackGetCustomerById")
   // @TimeLimiter(name = "customerServiceTimeLimiter", fallbackMethod = "fallbackGetCustomerById")
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow();
    }



    @Override
    @CircuitBreaker(name = "customerServiceCircuitBreaker", fallbackMethod = "fallbackUpdateCustomer")
   // @TimeLimiter(name = "customerServiceTimeLimiter", fallbackMethod = "fallbackUpdateCustomer")
    public Customer udapteCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getLastCustomerById() {
        Optional<Customer> customer = customerRepository.findTopByOrderByIdDesc();
        return customer.orElse(null);
    }
    public Customer fallbackCustomer(String document, Throwable throwable) {
        return new Customer();
    }


    public Customer fallbackSaveCustomer(Customer customer, Throwable throwable) {

        return new Customer();
    }

    public Customer fallbackGetCustomerById(Long id, Throwable throwable) {
        return new Customer();
    }

    public Customer fallbackUpdateCustomer(Customer customer, Throwable throwable) {
        return new Customer();
    }
}
