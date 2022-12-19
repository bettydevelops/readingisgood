package com.example.ReadingIsGood.order;

import com.example.ReadingIsGood.book.BookMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderMapper {

      BookMapper bookMapper;

      public List<OrderResponse> map(Set<Order> orderSet) {
        return orderSet.stream().map(order -> map(order)).collect(Collectors.toList());
      }

      public List<OrderResponse> map(List<Order> orderList) {
        return orderList.stream().map(order -> map(order)).collect(Collectors.toList());
      }

      public OrderResponse map(Order order) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(order.getId());
        orderResponse.setOrderDate(order.getOrderDate());
        orderResponse.setBooks(bookMapper.map(order.getBooks()));
        orderResponse.setCustomerId(order.getCustomer().getId());
        return orderResponse;
      }
}
