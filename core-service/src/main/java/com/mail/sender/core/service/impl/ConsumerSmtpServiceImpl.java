package com.mail.sender.core.service.impl;

import com.mail.sender.core.service.MessageSendingHistoryService;
import com.mail.sender.core.service.dto.MailResultData;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerSmtpServiceImpl {

  private final MessageSendingHistoryService messageSendingHistoryService;

  public ConsumerSmtpServiceImpl(MessageSendingHistoryService messageSendingHistoryService) {
    this.messageSendingHistoryService = messageSendingHistoryService;
  }

  //todo pattern:Transactional Outbox and Inbox
  @RabbitListener(queues = "${spring.rabbitmq.queue.smtp}")
  public void receivedMessage(MailResultData data) {
    messageSendingHistoryService.save(data);
  }
}
