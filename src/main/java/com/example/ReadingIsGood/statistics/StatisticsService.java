package com.example.ReadingIsGood.statistics;

import javax.transaction.Transactional;

@Transactional
public interface StatisticsService {

  StatisticsResponse findStatistics(Long customerId);
}
