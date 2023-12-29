package com.mail.sender.answering.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.mail.sender.answering.domain.Template} entity.
 */
public class TemplateDTO implements Serializable {

  private Long id;

  private String body;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemplateDTO that = (TemplateDTO) o;
    return Objects.equals(id, that.id) && Objects.equals(body, that.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, body);
  }

  @Override
  public String toString() {
    return "TemplateDTO{" +
        "id=" + id +
        ", body='" + body + '\'' +
        '}';
  }
}
