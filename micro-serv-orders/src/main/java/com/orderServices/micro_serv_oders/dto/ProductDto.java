package com.orderServices.micro_serv_oders.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String productName;
    private Double price;
}