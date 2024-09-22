package com.customerServices.micro_serv_customers.controller;

import com.customerServices.micro_serv_customers.models.Customer;
import com.customerServices.micro_serv_customers.service.CustomerService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.type.internal.UserTypeJavaTypeWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/customers")
@Tag(name = "Customers")
//@SecurityRequirement(name = "bearerAuth") security for each control
public class CustomerController {

    Logger LOG = LoggerFactory.getLogger(CustomerController.class);


    @Autowired
    private CustomerService customerService;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @Operation(
            description = "Get endpoint for customers",
            summary = "Get all customers")
    @ApiResponses( value ={
            @ApiResponse(responseCode = "200", description = "Found the customer success"),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    @GetMapping()
    public ResponseEntity<List<Customer>> getCustomers() {
        try {
            return  ResponseEntity.ok(customerService.getCustomers());
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/{id}")
    @Hidden
    public ResponseEntity<Customer> getCustomerById(@Parameter(description = "Document of the customer to be retrieved")
                                                          @PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(customerService.getCustomerById(id));
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping("/byDocument/{document}")
    public ResponseEntity<Customer> getCustomerByDocument(@Parameter(description = "Document of the customer to be retrieved")
                                                          @PathVariable("document") String document){
        try {
            return ResponseEntity.ok(customerService.getCustomerByDocument(document));
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Object> savedCustomer(@Valid @RequestBody Customer customer,BindingResult result){

        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Customer customerSaved = customerService.saveCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/api/customers/" + customerSaved.getId()));

        return new ResponseEntity<>(customerSaved, headers, HttpStatus.CREATED);

    }

    @GetMapping("/last")
    public ResponseEntity<Customer> getLastCustomer() {
        try {
            Customer lastCustomer = customerService.getLastCustomerById();
            return lastCustomer != null ? ResponseEntity.ok(lastCustomer) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
    @PutMapping("/{id}")
    public  ResponseEntity<Object> updateCustomer(@Valid @RequestBody Customer customer,@PathVariable("id") Long id,BindingResult result){

        if(result.hasErrors()){
            return new ResponseEntity<>(result.getAllErrors(),HttpStatus.BAD_REQUEST);
        }

        Customer customerExist = customerService.getCustomerById(id);
        if(customerExist == null){
            return ResponseEntity.notFound().build();
        }

        try {
            customerExist.setAge(customer.getAge());
            customerExist.setAddress(customer.getAddress());
            customerExist.setEmail(customer.getEmail());
            customerExist.setPhone(customer.getPhone());
            customerExist.setFirstName(customer.getFirstName());
            customerExist.setLastName(customer.getLastName());
            customerExist.setNumDocument(customer.getNumDocument());
            customerExist.setTypeDocument(customer.getTypeDocument());
            customerService.udapteCustomer(customer);

        }catch (Exception e){
            return ResponseEntity.internalServerError().build();

        }

        return new ResponseEntity<>(customer, null, HttpStatus.ACCEPTED);

    }

}
