package com.mail.sender.answering.web.rest.exception;

import org.springframework.http.HttpHeaders;

/**
 * Utility class for HTTP headers creation.
 */
public final class HeaderUtil {

  private HeaderUtil() {
  }

  public static HttpHeaders createAlert(String message, String param) {
    HttpHeaders headers = new HttpHeaders();
    headers.add("-alert", message);
    headers.add("-params", param);
    return headers;
  }
}
