package com.mail.sender.core.service.impl;

import com.mail.sender.core.domain.Message;
import com.mail.sender.core.domain.Tag;
import com.mail.sender.core.domain.Template;
import com.mail.sender.core.domain.User;
import com.mail.sender.core.domain.enumeration.MessageStatus;
import com.mail.sender.core.repository.MessageRepository;
import com.mail.sender.core.service.MessageService;
import com.mail.sender.core.service.TagService;
import com.mail.sender.core.service.TemplateService;
import com.mail.sender.core.service.UserService;
import com.mail.sender.core.service.dto.MailSendingData;
import com.mail.sender.core.service.dto.MessageRequestDTO;
import com.mail.sender.core.service.dto.TagRequestDTO;
import com.mail.sender.core.service.exception.MessageServiceException;
import com.mail.sender.core.service.mapper.MessageMapper;
import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

  private final TemplateService templateService;
  private final UserService userService;
  private final TagService tagService;
  private final MessageMapper messageMapper;
  private final MessageRepository messageRepository;
  private final ProducerCoreService producerCoreService;

  public MessageServiceImpl(TemplateService templateService, UserService userService, TagService tagService,
      MessageMapper messageMapper,
      MessageRepository messageRepository, ProducerCoreService producerCoreService) {
    this.templateService = templateService;
    this.userService = userService;
    this.tagService = tagService;
    this.messageMapper = messageMapper;
    this.messageRepository = messageRepository;
    this.producerCoreService = producerCoreService;
  }

  /**
   * Preparing data for saving and setting message status
   */
  @Override
  public void save(MessageRequestDTO messageRequestDto) {
    Message message = messageMapper.toEntity(messageRequestDto);
    List<User> users = userService.findAllByGroupUsers(messageRequestDto.getGroupUsers());
    String template = templateService.findOne(messageRequestDto.getTemplateId())
        .map(Template::getBody)
        .orElseThrow(() -> new MessageServiceException("Template not found"));
    String textMessage = textMessageGeneration(messageRequestDto.getTags(), template);
    Set<Tag> tags = tagService.findAllByNames(
        messageRequestDto.getTags().stream().map(TagRequestDTO::getName).collect(Collectors.toSet()));
    message.setMessageText(textMessage);
    message.setDate(Instant.now());
    message.setTags(tags);
    if (!StringUtils.isEmpty(template) && !users.isEmpty()) {
      MailSendingData mailSendingData = new MailSendingData(users.stream().map(User::getEmail).collect(
          Collectors.toList()), textMessage, message.getUniqueMessage());
      producerCoreService.sendMessage(mailSendingData);
      message.setStatus(MessageStatus.DELIVERED);
    } else {
      message.setStatus(MessageStatus.ERROR);
      message.setErrors("Empty users or template");
      message.setDateStatus(Instant.now());
    }
    messageRepository.save(message);
  }

  /**
   * Formation of result text according to the template and tags
   */
  private String textMessageGeneration(Set<TagRequestDTO> tags, String template) {
    for (TagRequestDTO tag : tags) {
      template = template.replace(tag.getName(), tag.getReplaceText());
    }
    return template;
  }
}
