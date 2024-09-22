package com.orderServices.micro_serv_oders.model;

import com.orderServices.micro_serv_oders.dto.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    private String customerId;
    private List<OrderDetailDb> orderDetails;
    private Double totalAmount;
    private LocalDateTime orderDate;
    private String status;
    private String address;

}