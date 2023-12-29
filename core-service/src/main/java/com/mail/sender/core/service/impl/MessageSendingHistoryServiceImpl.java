package com.mail.sender.core.service.impl;

import com.mail.sender.core.domain.MessageSendingHistory;
import com.mail.sender.core.repository.MessageSendingHistoryRepository;
import com.mail.sender.core.service.MessageSendingHistoryService;
import com.mail.sender.core.service.dto.MailResultData;
import com.mail.sender.core.service.mapper.MessageSendingHistoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link MessageSendingHistory}.
 */
@Service
@Transactional
public class MessageSendingHistoryServiceImpl implements MessageSendingHistoryService {

  private final Logger log = LoggerFactory.getLogger(MessageSendingHistoryServiceImpl.class);

  private final MessageSendingHistoryRepository messageSendingHistoryRepository;

  private final MessageSendingHistoryMapper messageSendingHistoryMapper;

  public MessageSendingHistoryServiceImpl(
      MessageSendingHistoryRepository messageSendingHistoryRepository,
      MessageSendingHistoryMapper messageSendingHistoryMapper
  ) {
    this.messageSendingHistoryRepository = messageSendingHistoryRepository;
    this.messageSendingHistoryMapper = messageSendingHistoryMapper;
  }

  @Override
  public void save(MailResultData mailResult) {
    log.debug("Request to save MessageSendingHistory : {}", mailResult);
    MessageSendingHistory messageSendingHistory = messageSendingHistoryMapper.toEntity(mailResult);
    messageSendingHistoryRepository.save(messageSendingHistory);
  }
}
