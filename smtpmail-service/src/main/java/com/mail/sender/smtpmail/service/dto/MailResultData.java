package com.mail.sender.smtpmail.service.dto;

import java.io.Serializable;

public class MailResultData implements Serializable {

  private String email;

  private SendingStatus sendingStatus;

  private String uniqueMessage;

  public MailResultData() {
  }

  public MailResultData(String email, SendingStatus sendingStatus, String uniqueMessage) {
    this.email = email;
    this.sendingStatus = sendingStatus;
    this.uniqueMessage = uniqueMessage;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public SendingStatus getSendingStatus() {
    return sendingStatus;
  }

  public void setSendingStatus(SendingStatus sendingStatus) {
    this.sendingStatus = sendingStatus;
  }

  public String getUniqueMessage() {
    return uniqueMessage;
  }

  public void setUniqueMessage(String uniqueMessage) {
    this.uniqueMessage = uniqueMessage;
  }
}
