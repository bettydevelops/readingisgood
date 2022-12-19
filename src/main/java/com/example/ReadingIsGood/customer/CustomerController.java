package com.example.ReadingIsGood.customer;

import com.example.ReadingIsGood.order.OrderResponse;
import com.example.ReadingIsGood.shared.SuccessResponse;
import lombok.RequiredArgsConstructor;
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
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
@Validated
public class CustomerController {
  private final CustomerService customerService;

  @PostMapping
  public ResponseEntity<SuccessResponse> createNewCustomer(@Valid @RequestBody CustomerRequest customerRequest) {
    CustomerResponse customerResponse = customerService.createNewCustomer(customerRequest);
    SuccessResponse successResponse = new SuccessResponse(customerResponse, "New customer created.");
    return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
  }

  @GetMapping(path = "/orders/{id}")
  public ResponseEntity<SuccessResponse> getAllOrdersOfCustomer(@PathVariable @Valid @NotNull Long id) {
    List<OrderResponse> orderResponseList = customerService.getAllOrdersOfCustomer(id);
    SuccessResponse successResponse = new SuccessResponse(orderResponseList, "All orders of customer listed.");
    return new ResponseEntity<>(successResponse, HttpStatus.OK);
  }

}
