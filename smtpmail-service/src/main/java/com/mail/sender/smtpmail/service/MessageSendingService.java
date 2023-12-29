package com.mail.sender.smtpmail.service;

import com.mail.sender.smtpmail.service.dto.MailSendingData;

public interface MessageSendingService {

  void processMessages(MailSendingData messages);

}
