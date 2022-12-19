package com.example.ReadingIsGood.order;

import com.example.ReadingIsGood.book.BookResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponse {

  Long id;
  List<BookResponse> books;
  @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
  LocalDate orderDate;
  Long customerId;
}
