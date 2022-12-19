package com.example.ReadingIsGood.customer;

import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

  public Customer map(CustomerRequest customerRequest) {

    Customer customer = new Customer();
    customer.setFirstName(customerRequest.getFirstName());
    customer.setLastName(customerRequest.getLastName());
    customer.setAddress(customerRequest.getAddress());

    return customer;
  }

  public CustomerResponse map(Customer customer) {
    CustomerResponse customerResponse = new CustomerResponse();
    customerResponse.setId(customer.getId());
    customerResponse.setFirstName(customer.getFirstName());
    customerResponse.setLastName(customer.getLastName());
    customerResponse.setAddress(customer.getAddress());
    return customerResponse;
  }
}
