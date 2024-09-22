package com.customerServices.micro_serv_customers.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentType {

    private Integer id;
    private String code;
    private String name;

}
