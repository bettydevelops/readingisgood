package com.example.ReadingIsGood;

import com.example.ReadingIsGood.customer.Customer;
import com.example.ReadingIsGood.customer.CustomerRepository;
import com.example.ReadingIsGood.customer.CustomerRequest;
import com.example.ReadingIsGood.customer.CustomerResponse;
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
class CreateCustomerTest {

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void createCustomer_thenRetrieveCustomerFromDatabase_shouldReturnExpectedCustomer() {

		WebClient webClient = WebClient.create("http://localhost:8090");
		CustomerRequest customerRequest = new CustomerRequest();
		customerRequest.setFirstName("Test Firstname");
		customerRequest.setLastName("Test Lastname");
		customerRequest.setAddress("Test Address");
		SuccessResponse successResponse = webClient.post()
				.uri("/customer")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(customerRequest), CustomerRequest.class)
				.retrieve()
				.bodyToMono(SuccessResponse.class)
				.block();

		CustomerResponse customerResponse = objectMapper.convertValue(successResponse.getData(), CustomerResponse.class);

		Customer customer = customerRepository.findById(customerResponse.getId()).get();
		assertEquals(customerRequest.getFirstName(), customer.getFirstName());
		assertEquals(customerRequest.getLastName(), customer.getLastName());
		assertEquals(customerRequest.getAddress(), customer.getAddress());

	}


}
