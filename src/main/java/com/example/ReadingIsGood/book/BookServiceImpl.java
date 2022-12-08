package com.example.ReadingIsGood.book;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

  BookRepository bookRepository;
  @Override
  public BookResponse newBook(BookRequest bookRequest) {

    BookModel book = new BookModel();
    book.setName(bookRequest.getName());
    book.setAuthor(bookRequest.getAuthor());
    book.setStock(bookRequest.getStock());

    bookRepository.save(book);
    BookResponse bookResponse = new BookResponse();
    bookResponse.setId(book.getId());
    bookResponse.setName(book.getName());
    bookResponse.setAuthor(book.getAuthor());
    bookResponse.setStock(book.getStock());

    return bookResponse;
  }

  @Override
  public void updateBookStock(BookRequest bookRequest) {

  }

}
