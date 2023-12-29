package com.mail.sender.core.service.impl;

import com.mail.sender.core.domain.User;
import com.mail.sender.core.repository.UserRepository;
import com.mail.sender.core.service.UserService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link User}.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

  private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public List<User> findAllByGroupUsers(Long groupUsers) {
    log.debug("Request to get all Users by groupUsers : {}", groupUsers);
    return userRepository.findAllByGroupUsers(groupUsers);
  }
}
