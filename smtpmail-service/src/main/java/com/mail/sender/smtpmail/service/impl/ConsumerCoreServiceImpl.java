package com.mail.sender.smtpmail.service.impl;

import com.mail.sender.smtpmail.service.MessageSendingService;
import com.mail.sender.smtpmail.service.dto.MailSendingData;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerCoreServiceImpl {

  private final MessageSendingService messageSendingService;

  public ConsumerCoreServiceImpl(MessageSendingService messageSendingService) {
    this.messageSendingService = messageSendingService;
  }

  //todo pattern:Transactional Outbox and Inbox
  @RabbitListener(queues = "${spring.rabbitmq.queue.core}")
  public void receivedMessage(MailSendingData data) {
    messageSendingService.processMessages(data);
  }
}
