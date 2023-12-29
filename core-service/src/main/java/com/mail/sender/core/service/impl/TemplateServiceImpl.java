package com.mail.sender.core.service.impl;

import com.mail.sender.core.domain.Template;
import com.mail.sender.core.repository.TemplateRepository;
import com.mail.sender.core.service.TemplateService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Template}.
 */
@Service
@Transactional
public class TemplateServiceImpl implements TemplateService {

  private final Logger log = LoggerFactory.getLogger(TemplateServiceImpl.class);

  private final TemplateRepository templateRepository;

  public TemplateServiceImpl(TemplateRepository templateRepository) {
    this.templateRepository = templateRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Template> findOne(Long id) {
    log.debug("Request to get Template : {}", id);
    return templateRepository.findById(id);
  }
}
