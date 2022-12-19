package com.example.ReadingIsGood.statistics;

import com.example.ReadingIsGood.shared.SuccessResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Validated
@RequestMapping("/statistics")
public class StatisticsController {

  StatisticsService statisticsService;

  @GetMapping
  public ResponseEntity<SuccessResponse> findStatistics(@NotNull @Valid @RequestParam Long customerId) {
    StatisticsResponse statisticsResponse = statisticsService.findStatistics(customerId);
    SuccessResponse successResponse = new SuccessResponse(statisticsResponse, "Statistics found.");
    return new ResponseEntity<>(successResponse, HttpStatus.OK);
  }

}
