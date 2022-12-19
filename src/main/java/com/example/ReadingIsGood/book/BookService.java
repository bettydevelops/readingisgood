package com.example.ReadingIsGood.book;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface BookService {

  BookResponse createNewBook(BookRequest bookRequest);

  void updateBookStock(int newStockCount, Long id);

  List<Book> findAllByIdIn(List<Long> idList);
}
