package com.example.ReadingIsGood.order;

import com.example.ReadingIsGood.shared.SuccessResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Validated
public class OrderController {
  OrderService orderService;

  @PostMapping
  public ResponseEntity<SuccessResponse> createNewOrder(@Valid @RequestBody OrderRequest orderRequest) {
    OrderResponse orderResponse = orderService.createNewOrder(orderRequest);
    SuccessResponse successResponse = new SuccessResponse(orderResponse, "New order created.");
    return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<SuccessResponse> findOrderById(@NotNull @Valid @PathVariable Long id) {
    OrderResponse orderResponse = orderService.findOrderById(id);
    SuccessResponse successResponse = new SuccessResponse(orderResponse, "Orders listed.");
    return new ResponseEntity<>(successResponse, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<SuccessResponse> findOrdersBetweenDates(
      @Valid @NotNull @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
      @Valid @NotNull @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
    List<OrderResponse> orderResponseList = orderService.findOrdersBetweenDates(startDate, endDate);
    SuccessResponse successResponse = new SuccessResponse(orderResponseList, "Orders listed by dates.");
    return new ResponseEntity<>(successResponse, HttpStatus.OK);
  }

}
