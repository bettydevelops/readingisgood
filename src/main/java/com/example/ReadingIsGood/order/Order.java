package com.example.ReadingIsGood.order;

import com.example.ReadingIsGood.book.Book;
import com.example.ReadingIsGood.customer.Customer;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(schema="BOOKSTORE", name="ORDERS")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  Long id;

  @Column(name = "ORDERDATE")
  LocalDate orderDate;

  @Column
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(schema = "BOOKSTORE",
      name = "BOOKORDERS",
      joinColumns = @JoinColumn(name = "ORDERID"),
      inverseJoinColumns = @JoinColumn(name = "BOOKID"))
  Set<Book> books;

  @ManyToOne
  @JoinColumn(name = "CUSTOMERID")
  Customer customer;
}