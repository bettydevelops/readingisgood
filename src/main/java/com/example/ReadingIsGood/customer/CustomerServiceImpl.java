package com.example.ReadingIsGood.customer;

import com.example.ReadingIsGood.order.Order;
import com.example.ReadingIsGood.order.OrderMapper;
import com.example.ReadingIsGood.order.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService{

  private final CustomerRepository customerRepository;
  private final OrderMapper orderMapper;
  private final CustomerMapper customerMapper;


  public CustomerResponse createNewCustomer(CustomerRequest customerRequest) {

    Customer customer = customerMapper.map(customerRequest);
    customerRepository.save(customer);
    return customerMapper.map(customer);
  }

  public List<OrderResponse> getAllOrdersOfCustomer(Long id) {
    Customer customer = findById(id);
    Set<Order> orderSet = customer.getOrderSet();
    return orderMapper.map(orderSet);
  }

  public Customer findById(Long id) {
    return customerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Customer with id: " + id + " is not found."));
  }
}
