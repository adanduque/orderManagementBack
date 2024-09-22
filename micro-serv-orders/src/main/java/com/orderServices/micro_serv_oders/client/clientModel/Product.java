package com.orderServices.micro_serv_oders.client.clientModel;

import lombok.Data;

@Data
public class Product {

    private Long id;
    private String name;
    private String description;
    private double price;

}