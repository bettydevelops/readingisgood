package com.example.ReadingIsGood.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {


  @Modifying
  @Query(value = "UPDATE Book B SET B.stock = :newStockCount WHERE B.id = :id")
  void updateBookStockById(int newStockCount, Long id);

}
