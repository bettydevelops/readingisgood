package com.example.ReadingIsGood.statistics;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatisticsResponse {

  int totalOrderCount;
  int totalBookCount;
  double totalPurchasedAmount;

}
