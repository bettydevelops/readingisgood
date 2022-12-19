package com.example.ReadingIsGood.statistics;

import com.example.ReadingIsGood.book.Book;
import com.example.ReadingIsGood.order.Order;
import com.example.ReadingIsGood.order.OrderRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Transactional
@Service
public class StatisticsServiceImpl implements StatisticsService{

  private final OrderRepository orderRepository;

  public StatisticsServiceImpl(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Override
  public StatisticsResponse findStatistics(Long customerId) {

    StatisticsResponse statisticsResponse = new StatisticsResponse();
    List<Order> orderList = orderRepository.findAllByCustomer_Id(customerId);
    statisticsResponse.setTotalOrderCount(orderList.size());
    int totalBookCount = 0;
    double totalAmount = 0;
    for(Order order: orderList) {
      Set<Book> bookSet=  order.getBooks();
      totalBookCount += bookSet.size();
      for(Book book: bookSet) {
        totalAmount += book.getPrice();
      }
    }
    statisticsResponse.setTotalBookCount(totalBookCount);
    statisticsResponse.setTotalPurchasedAmount(totalAmount);

    return null;
  }
}
