package com.example.ReadingIsGood.statistics;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/statistics")
public class StatisticsController {
  private final StatisticsService statisticsService;

}
