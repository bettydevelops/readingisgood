package com.example.ReadingIsGood.book;

import com.example.ReadingIsGood.shared.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
  private final BookService bookService;

  public ResponseEntity<SuccessResponse> newBook(BookRequest bookRequest) {
   BookResponse bookResponse = bookService.newBook(bookRequest);
   SuccessResponse successResponse = new SuccessResponse(bookResponse, "New book created.");
   return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
  }

  public ResponseEntity<SuccessResponse> updateBook(BookRequest bookRequest) {
    //TODO discuss what parameters will be given to method
    //return ResponseEntity.ok(bookService.updateBook(book));
return null;
  }

  }

