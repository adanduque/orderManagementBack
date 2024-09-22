package com.customerServices.micro_serv_customers.controller;

import com.customerServices.micro_serv_customers.models.Customer;
import com.customerServices.micro_serv_customers.modelsMock.CustomerMock;
import com.customerServices.micro_serv_customers.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Tag("CustomerControllerTest")
@WebMvcTest(CustomerController.class)
public class CustomersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){
        objectMapper = new ObjectMapper();
    }

    @Test
    @Order(1)
    public void getAllCustomers() throws Exception {
        //Give
        when(customerService.getCustomers()).thenReturn(CustomerMock.getCustomers());

        List<Customer> expectCustomer = CustomerMock.getCustomers();

        //When
        MvcResult result = mockMvc.perform(get("/api/v1/customers").contentType(MediaType.APPLICATION_JSON))
        //then
                .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String realResult = result.getResponse().getContentAsString();
        String expectResult = objectMapper.writeValueAsString(expectCustomer);
        assertEquals(expectResult,realResult);
        verify(customerService).getCustomers();
    }

    @Test
    @Order(2)
    public void getCustomerByDocument() throws Exception{
        String document="123456789";
        Customer customerExpected = CustomerMock.getCustomer();

        //When
        when(customerService.getCustomerByDocument(document)).thenReturn(CustomerMock.getCustomer());

        //Given
        MvcResult result =  mockMvc.perform(get("/api/v1/customers/byDocument/"+document).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        //Then
        String realResult = result.getResponse().getContentAsString();
        String expectResult = objectMapper.writeValueAsString(customerExpected);
        assertEquals(expectResult,realResult);

        verify(customerService).getCustomerByDocument(document);
    }

    @Test
    @Order(3)
    public void saveCustomer() throws  Exception{
        //when
    Customer customer = CustomerMock.getCustomerSave();
        when(customerService.saveCustomer(any())).then(
                invocation->{   Customer c = invocation.getArgument(0);
                                c.setId(1L);
                                return c;
                });

        //given

        mockMvc.perform(post("/api/v1/customers").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id",is(1)))
                .andExpect(jsonPath("firstName",is("Pepe")));

        verify(customerService).saveCustomer(any());

    }

    @Test
    @Order(4)
    public void updateCustomer() throws Exception {
        //when
        Customer customerFinding = CustomerMock.getCustomer();
        Customer customerUpdated = CustomerMock.getCustomerUpdated();

        when(customerService.getCustomerById(1L)).thenReturn(customerFinding);

        when(customerService.udapteCustomer(any())).then(invocation -> (Customer) invocation.getArgument(0));

        //then
        mockMvc.perform(put("/api/v1/customers/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customerUpdated)))
                .andExpect(jsonPath("$.id",is(1)))
                .andExpect(jsonPath("$.phone",is("999999999")));

        verify(customerService).getCustomerById(1L);
        verify(customerService).udapteCustomer(any());

    }

}
