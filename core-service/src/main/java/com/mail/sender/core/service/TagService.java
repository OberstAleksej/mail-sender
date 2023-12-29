package com.mail.sender.core.service;

import com.mail.sender.core.domain.Tag;
import java.util.Set;

/**
 * Service Interface for managing {@link com.mail.sender.core.domain.Tag}.
 */
public interface TagService {

  /**
   * Get all the tags by namess.
   *
   * @return the set of entities.
   */
  Set<Tag> findAllByNames(Set<String> names);
}
