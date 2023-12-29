package com.mail.sender.core.service.impl;

import com.mail.sender.core.domain.Tag;
import com.mail.sender.core.repository.TagRepository;
import com.mail.sender.core.service.TagService;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Tag}.
 */
@Service
@Transactional
public class TagServiceImpl implements TagService {

  private final Logger log = LoggerFactory.getLogger(TagServiceImpl.class);

  private final TagRepository tagRepository;

  public TagServiceImpl(TagRepository tagRepository) {
    this.tagRepository = tagRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public Set<Tag> findAllByNames(Set<String> names) {
    log.debug("Request to get Tags by names : {}", names);
    return tagRepository.findAllByNames(names);
  }
}
