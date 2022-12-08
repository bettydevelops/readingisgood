package com.example.ReadingIsGood.shared;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorResponse {
  boolean success = false;
  List<String> errorMessages;
  String message;
}
