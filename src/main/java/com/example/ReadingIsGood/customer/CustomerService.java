package com.example.ReadingIsGood.customer;

public interface CustomerService {

  CustomerResponse newCustomer(CustomerRequest customerRequest);

  //TODO List<Order> allOrdersOfCustomer(CustomerRequest customerRequest)
}
