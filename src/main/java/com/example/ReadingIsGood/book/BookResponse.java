package com.example.ReadingIsGood.book;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class BookResponse {

  Long id;
  String name;
  String author;
  int stock;
  double price;

}
