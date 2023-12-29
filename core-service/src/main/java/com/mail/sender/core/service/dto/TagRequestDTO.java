package com.mail.sender.core.service.dto;

import java.io.Serializable;

public class TagRequestDTO implements Serializable {

  private String name;

  private String replaceText;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getReplaceText() {
    return replaceText;
  }

  public void setReplaceText(String replaceText) {
    this.replaceText = replaceText;
  }
}
