package com.example.ReadingIsGood.book;

import com.example.ReadingIsGood.order.Order;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import java.util.Set;

@Entity
@Table(schema="BOOKSTORE", name="BOOK")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
public class Book {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  Long id;

  @Column(name = "NAME")
  String name;

  @Column(name = "AUTHOR")
  String author;

  @Min(0)
  @Column(name = "STOCK")
  int stock;

  @Min(0)
  @Column(name = "PRICE")
  double price;

  @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
  Set<Order> orders;

}
