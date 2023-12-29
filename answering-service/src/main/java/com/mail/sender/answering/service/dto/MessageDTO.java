package com.mail.sender.answering.service.dto;

import com.mail.sender.answering.domain.enumeration.FileType;
import com.mail.sender.answering.domain.enumeration.MessageStatus;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * A DTO for the {@link com.mail.sender.answering.domain.Message} entity.
 */
public class MessageDTO implements Serializable {

  private String uniqueMessage;

  private Long groupUsers;

  private String templateId;

  private String file;

  private FileType typeFile;

  private Set<TagDTO> tags = new HashSet<>();

  private String messageText;

  private Instant date;

  private MessageStatus status;

  private Instant dateStatus;

  private String errors;

  public String getUniqueMessage() {
    return uniqueMessage;
  }

  public void setUniqueMessage(String uniqueMessage) {
    this.uniqueMessage = uniqueMessage;
  }

  public Long getGroupUsers() {
    return groupUsers;
  }

  public void setGroupUsers(Long groupUsers) {
    this.groupUsers = groupUsers;
  }

  public String getFile() {
    return file;
  }

  public void setFile(String file) {
    this.file = file;
  }

  public FileType getTypeFile() {
    return typeFile;
  }

  public void setTypeFile(FileType typeFile) {
    this.typeFile = typeFile;
  }

  public String getMessageText() {
    return messageText;
  }

  public void setMessageText(String messageText) {
    this.messageText = messageText;
  }

  public Instant getDate() {
    return date;
  }

  public void setDate(Instant date) {
    this.date = date;
  }

  public MessageStatus getStatus() {
    return status;
  }

  public void setStatus(MessageStatus status) {
    this.status = status;
  }

  public Instant getDateStatus() {
    return dateStatus;
  }

  public void setDateStatus(Instant dateStatus) {
    this.dateStatus = dateStatus;
  }

  public String getErrors() {
    return errors;
  }

  public void setErrors(String errors) {
    this.errors = errors;
  }

  public Set<TagDTO> getTags() {
    return tags;
  }

  public void setTags(Set<TagDTO> tags) {
    this.tags = tags;
  }

  public String getTemplateId() {
    return templateId;
  }

  public void setTemplateId(String templateId) {
    this.templateId = templateId;
  }

  @Override
  public String toString() {
    return "MessageDTO{" +
        "uniqueMessage='" + uniqueMessage + '\'' +
        ", groupUsers=" + groupUsers +
        ", file='" + file + '\'' +
        ", typeFile=" + typeFile +
        ", messageText='" + messageText + '\'' +
        ", date=" + date +
        ", status=" + status +
        ", dateStatus=" + dateStatus +
        ", errors='" + errors + '\'' +
        ", tags=" + tags +
        ", templateId='" + templateId + '\'' +
        '}';
  }
}
