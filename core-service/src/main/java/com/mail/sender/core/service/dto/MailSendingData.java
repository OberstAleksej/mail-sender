package com.mail.sender.core.service.dto;

import java.io.Serializable;
import java.util.List;

public class MailSendingData implements Serializable {

  private List<String> emails;

  private String body;

  private String uniqueMessage;

  public MailSendingData() {
  }

  public List<String> getEmails() {
    return emails;
  }

  public void setEmails(List<String> emails) {
    this.emails = emails;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getUniqueMessage() {
    return uniqueMessage;
  }

  public void setUniqueMessage(String uniqueMessage) {
    this.uniqueMessage = uniqueMessage;
  }

  public MailSendingData(List<String> emails, String body, String uniqueMessage) {
    this.emails = emails;
    this.body = body;
    this.uniqueMessage = uniqueMessage;
  }

  @Override
  public String toString() {
    return "MailSendingData{" +
        "emails=" + emails +
        ", body='" + body + '\'' +
        '}';
  }
}
