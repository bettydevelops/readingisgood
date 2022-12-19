package com.example.ReadingIsGood.customer;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequest {

  @NotNull
  @Size(min = 2, max = 30)
  String firstName;
  @NotNull
  @Size(min = 2, max = 30)
  String lastName;
  @NotNull
  @Size(min = 10, max = 70)
  String address;

}
