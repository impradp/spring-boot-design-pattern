package com.example.template.util;

import java.util.Map;

public interface IAuthenticatedUserService {
  Long getUserId();

  Map<String, Object> getAttributes();
}
