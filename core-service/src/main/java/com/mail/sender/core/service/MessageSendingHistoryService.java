package com.mail.sender.core.service;

import com.mail.sender.core.service.dto.MailResultData;

/**
 * Service Interface for managing {@link com.mail.sender.core.domain.MessageSendingHistory}.
 */
public interface MessageSendingHistoryService {

  /**
   * Save a messageSendingHistory from rabbit queue.
   *
   * @param data the dto to save.
   */
  void save(MailResultData data);
}
