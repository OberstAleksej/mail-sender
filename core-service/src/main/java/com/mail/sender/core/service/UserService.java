package com.mail.sender.core.service;

import com.mail.sender.core.domain.User;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.mail.sender.core.domain.User}.
 */
public interface UserService {

  /**
   * Get all the users by groupId.
   *
   * @return the list of entities.
   */
  List<User> findAllByGroupUsers(Long groupUsers);
}
