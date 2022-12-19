package com.example.ReadingIsGood.order;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Transactional
public interface OrderService {

  OrderResponse createNewOrder(OrderRequest orderRequest);

  OrderResponse findOrderById(long id);

  List<OrderResponse> findOrdersBetweenDates(LocalDate startDate, LocalDate endDate);
}
