package com.example.ReadingIsGood;

import com.example.ReadingIsGood.book.Book;
import com.example.ReadingIsGood.book.BookRepository;
import com.example.ReadingIsGood.book.BookRequest;
import com.example.ReadingIsGood.book.BookResponse;
import com.example.ReadingIsGood.shared.SuccessResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)

public class CreateBookTest {

  @Autowired
  ObjectMapper objectMapper;

  @Autowired
  BookRepository bookRepository;

  @Test
  public void createBook_thenRetrieveBookFromDatabase_shouldReturnExpectedBook() {

    WebClient webClient = WebClient.create("http://localhost:8090");
    BookRequest bookRequest = new BookRequest();
    bookRequest.setName("Clean Code");
    bookRequest.setAuthor("Robert C. Martin\"");
    bookRequest.setStock(210);
    bookRequest.setPrice(560);
    SuccessResponse successResponse = webClient.post()
        .uri("/book")
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .body(Mono.just(bookRequest), BookRequest.class)
        .retrieve()
        .bodyToMono(SuccessResponse.class)
        .block();

    BookResponse bookResponse = objectMapper.convertValue(successResponse.getData(), BookResponse.class);

    Book book = bookRepository.findById(bookResponse.getId()).get();
    assertEquals(bookRequest.getName(), book.getName());
    assertEquals(bookRequest.getAuthor(), book.getAuthor());
    assertEquals(bookRequest.getStock(), book.getStock());
    assertEquals(bookRequest.getPrice(), book.getPrice());

  }
}
