package com.mail.sender.answering.service;

import com.mail.sender.answering.service.dto.MessageDTO;
import com.mail.sender.answering.service.dto.MessageRequestDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.mail.sender.answering.domain.Message}.
 */
public interface MessageService {

  /**
   * Send a message.
   *
   * @param message the MessageRequestDTO to save.
   */
  void save(MessageRequestDTO message);

  /**
   * Get the "uniqueMessage" message.
   *
   * @param uniqueMessage the uniqueMessage of the entity.
   * @return the messageDTO.
   */
  Optional<MessageDTO> findByUniqueMessage(String uniqueMessage);
}
