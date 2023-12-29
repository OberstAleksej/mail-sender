package com.mail.sender.smtpmail.service.impl;

import com.mail.sender.smtpmail.service.MessageSendingService;
import com.mail.sender.smtpmail.service.dto.MailResultData;
import com.mail.sender.smtpmail.service.dto.MailSendingData;
import com.mail.sender.smtpmail.service.dto.SendingStatus;
import org.springframework.stereotype.Service;

@Service
public class MessageSendingServiceImpl implements MessageSendingService {

  private final MailSenderService mailSenderService;
  private final ProducerSmtpServiceImpl producerSmtpService;

  public MessageSendingServiceImpl(MailSenderService mailSenderService, ProducerSmtpServiceImpl producerSmtpService) {
    this.mailSenderService = mailSenderService;
    this.producerSmtpService = producerSmtpService;
  }

  @Override
  public void processMessages(MailSendingData messages) {
    for (String email : messages.getEmails()) {
      SendingStatus sendingStatus = mailSenderService.isSendEmail(email,
          messages.getBody()) ? SendingStatus.DELIVERED : SendingStatus.ERROR;
      producerSmtpService.sendMessage(new MailResultData(email, sendingStatus, messages.getUniqueMessage()));
    }
  }
}
