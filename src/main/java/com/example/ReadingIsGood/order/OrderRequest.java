package com.example.ReadingIsGood.order;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequest {

  @NotNull
  @NotEmpty
  List<Long> bookIdList;
  @NotNull
  Long customerId;
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  LocalDate orderDate;

}
