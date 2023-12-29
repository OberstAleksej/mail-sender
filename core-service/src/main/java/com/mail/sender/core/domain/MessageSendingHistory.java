package com.mail.sender.core.domain;

import com.mail.sender.core.domain.enumeration.SendingStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 * A MessageSendingHistory.
 */
@Entity
@Table(name = "message_sending_history")
public class MessageSendingHistory implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
  @SequenceGenerator(name = "sequenceGenerator")
  private Long id;

  @Column(name = "unique_message")
  private String uniqueMessage;

  @Column(name = "email")
  private String email;

  @Enumerated(EnumType.STRING)
  @Column(name = "sending_status")
  private SendingStatus sendingStatus;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public MessageSendingHistory id(Long id) {
    this.id = id;
    return this;
  }

  public String getUniqueMessage() {
    return uniqueMessage;
  }

  public void setUniqueMessage(String uniqueMessage) {
    this.uniqueMessage = uniqueMessage;
  }

  public SendingStatus getSendingStatus() {
    return this.sendingStatus;
  }

  public MessageSendingHistory sendingStatus(SendingStatus sendingStatus) {
    this.sendingStatus = sendingStatus;
    return this;
  }

  public void setSendingStatus(SendingStatus sendingStatus) {
    this.sendingStatus = sendingStatus;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MessageSendingHistory that = (MessageSendingHistory) o;
    return Objects.equals(id, that.id) && Objects.equals(uniqueMessage, that.uniqueMessage)
        && Objects.equals(email, that.email) && sendingStatus == that.sendingStatus;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, uniqueMessage, email, sendingStatus);
  }

  @Override
  public String toString() {
    return "MessageSendingHistory{" +
        "id=" + id +
        ", uniqueMessage='" + uniqueMessage + '\'' +
        ", email='" + email + '\'' +
        ", sendingStatus=" + sendingStatus +
        '}';
  }
}
