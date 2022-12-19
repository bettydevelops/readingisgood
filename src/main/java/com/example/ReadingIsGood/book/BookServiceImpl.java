package com.example.ReadingIsGood.book;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
public class BookServiceImpl implements BookService {

  BookRepository bookRepository;
  BookMapper bookMapper;


  @Override
  public BookResponse createNewBook(BookRequest bookRequest) {

    Book book = bookMapper.map(bookRequest);
    bookRepository.save(book);
    return bookMapper.map(book);
  }

  @Override
  public void updateBookStock(int newStockCount, Long id) {
    bookRepository.updateBookStockById(newStockCount, id);
  }

  public List<Book> findAllByIdIn(List<Long> idList) {
    return bookRepository.findAllById(idList);
  }

}
