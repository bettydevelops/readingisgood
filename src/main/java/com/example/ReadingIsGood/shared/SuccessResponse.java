package com.example.ReadingIsGood.shared;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SuccessResponse {
  boolean success = true;
  Object data;
  String message;

  public SuccessResponse(Object data, String message) {
    this.data = data;
    this.message = message;
  }
}
