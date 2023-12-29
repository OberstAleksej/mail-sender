package com.mail.sender.core.service.impl;

import com.mail.sender.core.service.dto.MailSendingData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerCoreService {

  private final RabbitTemplate rabbitTemplate;

  @Autowired
  public ProducerCoreService(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @Value("${spring.rabbitmq.exchange.core}")
  private String exchange;

  @Value("${spring.rabbitmq.routingkey.core}")
  private String routingkey;

  //todo pattern:Transactional Outbox and Inbox
  public void sendMessage(MailSendingData data) {
    rabbitTemplate.convertAndSend(exchange, routingkey, data);
  }
}
