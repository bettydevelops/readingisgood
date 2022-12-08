package com.example.ReadingIsGood.customer;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="BOOKSTORE", name="CUSTOMER")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
public class CustomerModel {

  @Id
  @Column(name = "ID")
  Long id;

  @Column(name = "FIRSTNAME")
  String firstName;

  @Column(name = "LASTNAME")
  String lastName;

  @Column(name = "ADDRESS")
  String address;
}

//TODO connect order table with customer

