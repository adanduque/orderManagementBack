package com.customerServices.micro_serv_customers.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    // Getters y Setters


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String firstName;

    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String lastName;

    @Email(message = "Enter correct email")
    private String email;

    @NotNull(message = "El nombre no puede ser nulo")
    private String phone;
    private String address;

    @Min(value = 18, message = "The age must be at least 18")
    @Max(value = 120, message = "Age cannot be greater than 120")
    private Integer age;

    @Size(min = 2, max = 9, message = "Ingrese numero de documentos correcto")
    private String  numDocument;

    @Min(value = 1, message = "The typeDocument must be at least 1")
    @Max(value = 10, message = "Age typeDocument be greater than 10")
    private Integer  typeDocument;

}
