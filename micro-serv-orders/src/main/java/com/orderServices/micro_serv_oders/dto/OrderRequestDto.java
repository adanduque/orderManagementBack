package com.orderServices.micro_serv_oders.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {
    private String customerId;
    private List<OrderDetail> orderDetail;
    private String address;
    private String orderDate;
}