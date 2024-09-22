package com.customerServices.micro_serv_customers.service;


import com.customerServices.micro_serv_customers.models.Customer;
import com.customerServices.micro_serv_customers.modelsMock.CustomerMock;
import com.customerServices.micro_serv_customers.repository.CustomerRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    @Order(1)
    public void testGetCustomers(){
        //when
        when(customerRepository.findAll()).thenReturn(CustomerMock.getCustomers());

        //given
        List<Customer> customerList = customerService.getCustomers();

        //then
        assertFalse(customerList.isEmpty());
        assertEquals(4,customerList.size());

        verify(customerRepository).findAll();

    }
}
