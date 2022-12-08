package com.example.ReadingIsGood.shared;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SuccessResponse {
  boolean success = true;
  Object data;
  String message;
}
