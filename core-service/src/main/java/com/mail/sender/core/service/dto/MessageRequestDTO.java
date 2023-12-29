package com.mail.sender.core.service.dto;

import com.mail.sender.core.domain.enumeration.FileType;
import com.mail.sender.core.domain.enumeration.MessageStatus;
import java.io.Serializable;
import java.util.Set;

public class MessageRequestDTO implements Serializable {

  private String uniqueMessage;

  private Long groupUsers;

  private Long templateId;

  private String file;

  private FileType typeFile;

  private Set<TagRequestDTO> tags;

  private MessageStatus messageStatus;

  public MessageRequestDTO() {
  }

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

  public Long getTemplateId() {
    return templateId;
  }

  public void setTemplateId(Long templateId) {
    this.templateId = templateId;
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

  public Set<TagRequestDTO> getTags() {
    return tags;
  }

  public void setTags(Set<TagRequestDTO> tags) {
    this.tags = tags;
  }

  public MessageStatus getMessageStatus() {
    return messageStatus;
  }

  public void setMessageStatus(MessageStatus messageStatus) {
    this.messageStatus = messageStatus;
  }
}