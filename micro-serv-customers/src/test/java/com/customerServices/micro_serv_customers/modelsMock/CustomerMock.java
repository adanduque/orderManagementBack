package com.customerServices.micro_serv_customers.modelsMock;


import com.customerServices.micro_serv_customers.models.Customer;

import java.util.List;

public class CustomerMock {


    public static Customer getCustomerSave(){
        return Customer.builder()
                .age(16)
                .phone("96684578")
                .email("smith.asda87@gmail.com")
                .address("Calle parinas 343 aahh 9 de cotubre")
                .firstName("Pepe")
                .lastName("Duque Aquino")
                .typeDocument(1)
                .numDocument("123456789")
                .build();
    }
    public static Customer getCustomer(){
        return Customer.builder()
                .id(1L)
                .age(16)
                .phone("96684578")
                .email("smith.asda87@gmail.com")
                .address("Calle parinas 343 aahh 9 de cotubre")
                .firstName("Adan Smith")
                .lastName("Duque Aquino")
                .typeDocument(1)
                .numDocument("123456789")
                .build();
    }

    public static Customer getCustomerUpdated(){
        return Customer.builder()
                .id(1L)
                .age(16)
                .phone("999999999")
                .email("smith.asda87@gmail.com")
                .address("Calle parinas 343 aahh 9 de cotubre")
                .firstName("Adan Smith")
                .lastName("Duque Aquino")
                .typeDocument(1)
                .numDocument("123456789")
                .build();
    }
    public static List<Customer> getCustomers(){
        return List.of(
                Customer.builder()
                        .id(1L)
                        .age(16)
                        .phone("933474242")
                        .email("smith.asda87@gmail.com")
                        .address("Calle parinas 343 aahh 9 de cotubre")
                        .firstName("Adan Smith")
                        .lastName("Duque Aquino")
                        .typeDocument(1)
                        .numDocument("71985781")
                        .build(),
                Customer.builder()
                        .id(2L)
                        .age(18)
                        .phone("933474242")
                        .email("smith.asda87@gmail.com")
                        .address("Calle parinas 343 aahh 9 de cotubre")
                        .firstName("Tomas")
                        .lastName("Nunes Martinez")
                        .numDocument("71985781")
                        .typeDocument(1)
                        .build(),
                Customer.builder()
                        .id(3L)
                        .age(26)
                        .phone("933474242")
                        .email("smith.asda87@gmail.com")
                        .address("Calle parinas 343 aahh 9 de cotubre")
                        .firstName("Miguel")
                        .lastName("Perez Roque")
                        .typeDocument(2)
                        .numDocument("71985781")
                        .build(),
                Customer.builder()
                        .id(4L)
                        .age(54)
                        .phone("933474242")
                        .email("smith.asda87@gmail.com")
                        .address("Calle parinas 343 aahh 9 de cotubre")
                        .firstName("Felipe")
                        .lastName("Martinez Sandoval")
                        .numDocument("71985781")
                        .typeDocument(1)
                        .build()

        );
    }


}
