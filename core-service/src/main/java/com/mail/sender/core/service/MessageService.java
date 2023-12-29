package com.mail.sender.core.service;

import com.mail.sender.core.service.dto.MessageRequestDTO;

public interface MessageService {

  void save(MessageRequestDTO message);
}
