package com.example.template.util;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;

@Data
public class RestResponse {

  private boolean status;
  private String error;
  private String message;
  private String errorTrace;
  private Map<String, Object> data = new HashMap<>();

  public void addPayload(String key, Object value) {
    this.data.put(key, value);
  }
}
