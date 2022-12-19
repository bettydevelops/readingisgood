package com.example.ReadingIsGood.book;

import com.example.ReadingIsGood.shared.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
@Validated
public class BookController {

  private final BookService bookService;

  @PostMapping
  public ResponseEntity<SuccessResponse> createNewBook(@Valid @RequestBody BookRequest bookRequest) {
    BookResponse bookResponse = bookService.createNewBook(bookRequest);
    SuccessResponse successResponse = new SuccessResponse(bookResponse, "New book created.");
    return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
  }

  @PatchMapping(path = "/{id}")
  public ResponseEntity<SuccessResponse> updateBookStock(@Valid @NotNull @PositiveOrZero @RequestParam(value = "newStockCount") Integer newStockCount,
                                                         @Valid @NotNull @PathVariable Long id) {
    bookService.updateBookStock(newStockCount, id);
    SuccessResponse successResponse = new SuccessResponse(null, "Book stock updated.");
    return new ResponseEntity<>(successResponse, HttpStatus.OK);
  }

}

