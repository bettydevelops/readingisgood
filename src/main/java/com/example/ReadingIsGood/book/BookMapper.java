package com.example.ReadingIsGood.book;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BookMapper {

  public List<BookResponse> map(Set<Book> bookSet) {
    return bookSet.stream().map(this::map).collect(Collectors.toList());
  }

  public BookResponse map(Book book) {
    BookResponse bookResponse = new BookResponse();
    bookResponse.setId(book.getId());
    bookResponse.setName(book.getName());
    bookResponse.setAuthor(book.getAuthor());
    bookResponse.setStock(book.getStock());
    bookResponse.setPrice(book.getPrice());
    return bookResponse;
  }

  public Book map(BookRequest bookRequest) {
    Book book = new Book();
    book.setName(bookRequest.getName());
    book.setAuthor(bookRequest.getAuthor());
    book.setStock(bookRequest.getStock());
    book.setPrice(bookRequest.getPrice());
    return book;
  }
}
