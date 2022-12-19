package com.example.ReadingIsGood.order;

import com.example.ReadingIsGood.book.Book;
import com.example.ReadingIsGood.book.BookService;
import com.example.ReadingIsGood.customer.Customer;
import com.example.ReadingIsGood.customer.CustomerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
public class OrderServiceImpl implements OrderService{

  OrderRepository orderRepository;
  BookService bookService;
  CustomerService customerService;
  OrderMapper orderMapper;


  public OrderResponse createNewOrder(OrderRequest orderRequest) {

    Order order = new Order();
    order.setOrderDate(orderRequest.getOrderDate());
    Customer customer = customerService.findById(orderRequest.getCustomerId());
    order.setCustomer(customer);
    List<Book> bookList = bookService.findAllByIdIn(orderRequest.getBookIdList());
    bookList.forEach(book -> book.setStock(book.getStock() - 1));
    order.setBooks(new HashSet<>(bookList));
    orderRepository.save(order);

    return orderMapper.map(order);
  }

  @Override
  public OrderResponse findOrderById(long id) {
     Order order = orderRepository.findById(id)
         .orElseThrow(() -> new RuntimeException("Order with id:" + id + " is not found."));
     return orderMapper.map(order);
  }

  @Override
  public List<OrderResponse> findOrdersBetweenDates(LocalDate startDate, LocalDate endDate) {
    List<Order> orderList = orderRepository.findAllByOrderDateBetween(startDate, endDate);
    return orderMapper.map(orderList);
  }

}
