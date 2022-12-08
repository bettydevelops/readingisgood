package com.example.ReadingIsGood.book;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(schema="BOOKSTORE", name="BOOK")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
public class BookModel {


  @Id
  @Column(name = "ID")
  Long id;

  @Column(name = "NAME")
  String name;

  @Column(name = "AUTHOR")
  String author;

  @Column(name = "STOCK")
  int stock;

}
