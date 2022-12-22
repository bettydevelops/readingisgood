package com.example.ReadingIsGood.customer;

import com.example.ReadingIsGood.order.Order;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(schema="BOOKSTORE", name="CUSTOMER")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  Long id;

  @Column(name = "FIRSTNAME")
  String firstName;

  @Column(name = "LASTNAME")
  String lastName;

  @Column(name = "ADDRESS")
  String address;

  @OneToMany(mappedBy = "customer")
  Set<Order> orderSet;
}


