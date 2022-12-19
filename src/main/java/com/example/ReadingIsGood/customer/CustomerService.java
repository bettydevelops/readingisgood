package com.example.ReadingIsGood.customer;

import com.example.ReadingIsGood.order.OrderResponse;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface CustomerService {

  CustomerResponse createNewCustomer(CustomerRequest customerRequest);

  List<OrderResponse> getAllOrdersOfCustomer(Long id);

  Customer findById(Long id);
}
