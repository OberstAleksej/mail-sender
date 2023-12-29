package com.mail.sender.smtpmail.service.impl;

import com.mail.sender.smtpmail.service.dto.MailResultData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerSmtpServiceImpl {

  private final RabbitTemplate rabbitTemplate;

  public ProducerSmtpServiceImpl(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @Value("${spring.rabbitmq.exchange.smtp}")
  private String exchange;

  @Value("${spring.rabbitmq.routingkey.smtp}")
  private String routingkey;

  //todo pattern:Transactional Outbox and Inbox
  public void sendMessage(MailResultData data) {
    rabbitTemplate.convertAndSend(exchange, routingkey, data);
  }
}
