package com.example.ReadingIsGood.customer;

import com.example.ReadingIsGood.shared.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
  private final CustomerService customerService;

  public ResponseEntity<SuccessResponse> newCustomer(CustomerRequest customerRequest) {
    return null;
  }

}
