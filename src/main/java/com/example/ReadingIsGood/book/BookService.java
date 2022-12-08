package com.example.ReadingIsGood.book;

public interface BookService {

  BookResponse newBook(BookRequest bookRequest);

  void updateBookStock(BookRequest bookRequest);


}
