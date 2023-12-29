package com.mail.sender.core.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

  @Value("${spring.rabbitmq.queue.answering}")
  private String queue;

  @Value("${spring.rabbitmq.queue.smtp}")
  private String smtpQueue;

  @Value("${spring.rabbitmq.exchange.answering}")
  private String exchange;

  @Value("${spring.rabbitmq.exchange.smtp}")
  private String smtpExchange;

  @Value("${spring.rabbitmq.routingkey.answering}")
  private String routingKey;

  @Value("${spring.rabbitmq.routingkey.smtp}")
  private String smtpRoutingKey;

  @Value("${spring.rabbitmq.username}")
  private String username;

  @Value("${spring.rabbitmq.password}")
  private String password;

  @Value("${spring.rabbitmq.host}")
  private String host;

  @Bean
  public Queue queue() {
    return new Queue(queue, true);
  }

  @Bean
  public Queue smtpQueue() {
    return new Queue(smtpQueue, true);
  }

  @Bean
  public Exchange myExchange() {
    return ExchangeBuilder.directExchange(exchange).durable(true).build();
  }

  @Bean
  public Exchange mySmtpExchange() {
    return ExchangeBuilder.directExchange(smtpExchange).durable(true).build();
  }

  @Bean
  public Binding binding() {
    return BindingBuilder
        .bind(queue())
        .to(myExchange())
        .with(routingKey)
        .noargs();
  }

  @Bean
  public Binding smtpBinding() {
    return BindingBuilder
        .bind(smtpQueue())
        .to(mySmtpExchange())
        .with(smtpRoutingKey)
        .noargs();
  }

  @Bean
  public ConnectionFactory connectionFactory() {
    CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(host);
    cachingConnectionFactory.setUsername(username);
    cachingConnectionFactory.setPassword(password);
    return cachingConnectionFactory;
  }

  @Bean
  public MessageConverter jsonMessageConverter() {
    return new Jackson2JsonMessageConverter();
  }

  @Bean
  public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
    final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(jsonMessageConverter());
    return rabbitTemplate;
  }
}