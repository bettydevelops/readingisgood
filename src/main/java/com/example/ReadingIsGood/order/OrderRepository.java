package com.example.ReadingIsGood.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

  List<Order> findAllByOrderDateBetween(LocalDate startDate, LocalDate endDate);

  List<Order> findAllByCustomer_Id(long customerId);


}
