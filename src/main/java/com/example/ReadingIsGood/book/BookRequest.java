package com.example.ReadingIsGood.book;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class BookRequest {

  @NotNull
  String name;
  @NotNull
  String author;
  @NotNull
  @PositiveOrZero
  int stock;
  @NotNull
  @PositiveOrZero
  double price;

}
