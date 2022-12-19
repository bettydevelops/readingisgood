package com.example.ReadingIsGood.customer;

import com.example.ReadingIsGood.order.Order;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerResponse {

  Long id;
  String firstName;
  String lastName;
  String address;
  Set<Order> orderSet;

}

