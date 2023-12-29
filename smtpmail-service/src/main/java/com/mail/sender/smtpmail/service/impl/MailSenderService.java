package com.mail.sender.smtpmail.service.impl;

import jakarta.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Service for sending emails.
 * <p>
 */
@Service
public class MailSenderService {

  private final Logger log = LoggerFactory.getLogger(MailSenderService.class);

  private final JavaMailSender javaMailSender;

  public MailSenderService(JavaMailSender javaMailSender) {
    this.javaMailSender = javaMailSender;
  }

  @Async
  public void sendEmail(String to, String subject, String content, boolean isMultipart, boolean isHtml) {
    log.debug("Send email[multipart '{}' and html '{}'] to '{}' with subject '{}' and content={}",
        isMultipart, isHtml, to, subject, content);
    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    try {
      MimeMessageHelper message = new MimeMessageHelper(mimeMessage, isMultipart, StandardCharsets.UTF_8.name());
      message.setTo(to);
      message.setSubject(subject);
      message.setText(content, isHtml);
      javaMailSender.send(mimeMessage);
      log.debug("Sent email to User '{}'", to);
    } catch (Exception e) {
      log.warn("Email could not be sent to user '{}': {}", to, e.getMessage());
    }
  }

  //todo test affect
  public boolean isSendEmail(String to, String content) {
    return new Random().nextBoolean();
  }
}
