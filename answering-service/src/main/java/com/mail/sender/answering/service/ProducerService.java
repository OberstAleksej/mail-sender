package com.mail.sender.answering.service;

import com.mail.sender.answering.service.dto.MessageRequestDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

  private RabbitTemplate rabbitTemplate;

  @Autowired
  public ProducerService(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @Value("${spring.rabbitmq.exchange.answering}")
  private String exchange;

  @Value("${spring.rabbitmq.routingkey.answering}")
  private String routingkey;

  //todo pattern:Transactional Outbox and Inbox
  public void sendMessage(MessageRequestDTO message) {
    rabbitTemplate.convertAndSend(exchange, routingkey, message);
  }
}
