package com.mail.sender.answering.service.impl;

import com.mail.sender.answering.domain.Message;
import com.mail.sender.answering.repository.MessageRepository;
import com.mail.sender.answering.service.MessageService;
import com.mail.sender.answering.service.ProducerService;
import com.mail.sender.answering.service.dto.MessageDTO;
import com.mail.sender.answering.service.dto.MessageRequestDTO;
import com.mail.sender.answering.service.mapper.MessageMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Message}.
 */
@Service
public class MessageServiceImpl implements MessageService {

  private final Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);

  private final MessageRepository messageRepository;

  private final ProducerService producerService;
  private final MessageMapper messageMapper;

  public MessageServiceImpl(MessageRepository messageRepository, ProducerService producerService,
      MessageMapper messageMapper) {
    this.messageRepository = messageRepository;
    this.producerService = producerService;
    this.messageMapper = messageMapper;
  }

  @Override
  public void save(MessageRequestDTO message) {
    log.debug("Request to send MessageRequestDTO : {}", message);
    producerService.sendMessage(message);
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<MessageDTO> findByUniqueMessage(String uniqueMessage) {
    log.debug("Request to get Message : {}", uniqueMessage);
    return messageRepository.findByUniqueMessage(uniqueMessage).map(messageMapper::toDto);
  }
}
