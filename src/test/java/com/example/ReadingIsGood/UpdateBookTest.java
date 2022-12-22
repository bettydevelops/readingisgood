package com.example.ReadingIsGood;

import com.example.ReadingIsGood.book.Book;
import com.example.ReadingIsGood.book.BookRepository;
import com.example.ReadingIsGood.book.BookRequest;
import com.example.ReadingIsGood.customer.CustomerResponse;
import com.example.ReadingIsGood.shared.SuccessResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class UpdateBookTest {

  @Autowired
  ObjectMapper objectMapper;
  @Autowired
  private BookRepository bookRepository;

  @Test
  public void createBook_thenUpdateBookStock_shouldReturnCorrectStockCount() {

    WebClient webClient = WebClient.create("http://localhost:8090");
    Book book = new Book();
    book.setName("The History Behind Getir's Success");
    book.setAuthor("Elif Nurdag");
    book.setStock(150);
    book.setPrice(210);
    Book newlySavedBook = bookRepository.save(book);

    long bookId = newlySavedBook.getId();
    int newStockCount = 120;

    SuccessResponse successResponse = webClient.patch()
        .uri(uriBuilder -> uriBuilder
            .path("/book/" + bookId)
            .queryParam("newStockCount", newStockCount)
            .build())
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .retrieve()
        .bodyToMono(SuccessResponse.class)
        .block();

    Book updatedBook = bookRepository.findById(bookId).get();
    assertEquals(newStockCount, updatedBook.getStock());
  }

  @Test
  public void createBook_thenUpdateBookStockAsNegative_shouldThrowException() throws Exception {

    WebClient webClient = WebClient.create("http://localhost:8090");
    /*Book book = new Book();
    book.setName("Once Upon A Time");
    book.setAuthor("Bsta Ysglam");
    book.setStock(315);
    book.setPrice(420);
    Book newlySavedBook = bookRepository.save(book);

    long bookId = newlySavedBook.getId();
    int newStockCount = -5;*/

    BookRequest bookRequest = new BookRequest();
    bookRequest.setName("Once Upon A Time");
    bookRequest.setAuthor("Bsta Ysglam");
    bookRequest.setStock(315);
    bookRequest.setPrice(420);
    SuccessResponse successResponse = webClient.post()
        .uri("/book")
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .body(Mono.just(bookRequest), BookRequest.class)
        .retrieve()
        .bodyToMono(SuccessResponse.class)
        .block();

    CustomerResponse customerResponse = objectMapper.convertValue(successResponse.getData(), CustomerResponse.class);

    long bookId = customerResponse.getId();
    int newStockCount = -5;

    try {
      String errorResponse = webClient.patch()
          .uri(uriBuilder -> uriBuilder
              .path("/book/" + bookId)
              .queryParam("newStockCount", newStockCount)
              .build())
          .retrieve()
          .onStatus(
              HttpStatus.BAD_REQUEST::equals,
              response -> response.bodyToMono(String.class).map(Exception::new))
          .bodyToMono(String.class)
          .block();
    } catch(Exception ex) {
      assertTrue(ex.getCause().getLocalizedMessage().contains("Validation Failed"));
      assertTrue(ex.getLocalizedMessage().contains("updateBookStock.newStockCount: must be greater than or equal to 0"));
    }
  }

}
