package com.mail.sender.core.service;

import com.mail.sender.core.domain.Template;
import java.util.Optional;

public interface TemplateService {

  /**
   * Get the "id" template.
   *
   * @param id the id of the entity.
   * @return the entity.
   */
  Optional<Template> findOne(Long id);
}
