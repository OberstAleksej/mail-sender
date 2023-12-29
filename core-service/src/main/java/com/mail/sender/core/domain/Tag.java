package com.mail.sender.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Tag.
 */
@Entity
@Table(name = "tag")
public class Tag implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
  @SequenceGenerator(name = "sequenceGenerator")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "replace_text")
  private String replaceText;

  @ManyToMany(mappedBy = "tags")
  @JsonIgnoreProperties(value = {"tags", "template"}, allowSetters = true)
  private Set<Message> names = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  public Set<Message> getNames() {
    return names;
  }

  public void setNames(Set<Message> names) {
    this.names = names;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tag tag = (Tag) o;
    return Objects.equals(id, tag.id) && Objects.equals(name, tag.name) && Objects.equals(
        replaceText, tag.replaceText) && Objects.equals(names, tag.names);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, replaceText, names);
  }

  @Override
  public String toString() {
    return "Tag{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", replaceText='" + replaceText + '\'' +
        ", names=" + names +
        '}';
  }
}
