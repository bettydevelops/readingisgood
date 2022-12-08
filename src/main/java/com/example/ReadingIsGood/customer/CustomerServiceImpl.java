package com.example.ReadingIsGood.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
  private final CustomerRepository customerRepository;

  public CustomerServiceImpl(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public CustomerResponse newCustomer(CustomerRequest customerRequest) {

    CustomerModel customer = new CustomerModel();
    customer.setFirstName(customerRequest.getFirstName());
    customer.setLastName(customerRequest.getLastName());
    customer.setAddress(customerRequest.getAddress());

    customerRepository.save(customer);
    CustomerResponse customerResponse = new CustomerResponse();
    customerResponse.setFirstName(customer.getFirstName());
    customerResponse.setLastName(customer.getLastName());
    customerResponse.setAddress(customer.getAddress());
    return customerResponse;
  }
}
