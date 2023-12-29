package com.mail.sender.answering.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mail.sender.answering.domain.enumeration.FileType;
import com.mail.sender.answering.domain.enumeration.MessageStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * A Message.
 */

@Entity
@Table(name = "message")
public class Message implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
  @SequenceGenerator(name = "sequenceGenerator")
  private Long id;

  @Column(name = "unique_message")
  private String uniqueMessage;

  @Column(name = "group_users")
  private Long groupUsers;

  @Column(name = "file")
  private String file;

  @Enumerated(EnumType.STRING)
  @Column(name = "type_file")
  private FileType typeFile;

  @Column(name = "message_text")
  private String messageText;

  @Column(name = "date")
  private Instant date;

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private MessageStatus status;

  @Column(name = "date_status")
  private Instant dateStatus;

  @Column(name = "errors")
  private String errors;

  @ManyToMany
  @JoinTable(name = "rel_message__tag", joinColumns = @JoinColumn(name = "message_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
  @JsonIgnoreProperties(value = {"names"}, allowSetters = true)
  private Set<Tag> tags = new HashSet<>();

  @Column(name = "template_id")
  private Long templateId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public Set<Tag> getTags() {
    return tags;
  }

  public void setTags(Set<Tag> tags) {
    this.tags = tags;
  }

  public Long getTemplateId() {
    return templateId;
  }

  public void setTemplateId(Long templateId) {
    this.templateId = templateId;
  }
}
