package com.mail.sender.core.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.mail.sender.core.domain.Template} entity.
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
    if (!(o instanceof TemplateDTO)) {
      return false;
    }

    TemplateDTO templateDTO = (TemplateDTO) o;
    if (this.id == null) {
      return false;
    }
    return Objects.equals(this.id, templateDTO.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id);
  }

  // prettier-ignore
  @Override
  public String toString() {
    return "TemplateDTO{" +
        "id=" + getId() +
        ", body='" + getBody() + "'" +
        "}";
  }
}
