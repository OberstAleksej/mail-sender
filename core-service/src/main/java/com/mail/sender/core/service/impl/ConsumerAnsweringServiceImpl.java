package com.mail.sender.core.service.impl;

import com.mail.sender.core.service.MessageService;
import com.mail.sender.core.service.dto.MessageRequestDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerAnsweringServiceImpl {

  private final MessageService messageService;

  public ConsumerAnsweringServiceImpl(MessageService messageService) {
    this.messageService = messageService;
  }

  //todo pattern:Transactional Outbox and Inbox
  @RabbitListener(queues = "${spring.rabbitmq.queue.answering}")
  public void receivedMessage(MessageRequestDTO message) {
    messageService.save(message);
  }
}
