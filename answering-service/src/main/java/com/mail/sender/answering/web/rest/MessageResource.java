package com.mail.sender.answering.web.rest;

import static com.mail.sender.answering.web.rest.util.MessageValidation.checkUniqMessage;

import com.mail.sender.answering.service.MessageService;
import com.mail.sender.answering.service.dto.MessageDTO;
import com.mail.sender.answering.service.dto.MessageRequestDTO;
import com.mail.sender.answering.web.rest.exception.BadRequestAlertException;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing {@link com.mail.sender.answering.domain.Message}.
 */
@RestController
@RequestMapping("/api")
public class MessageResource {

  private final Logger log = LoggerFactory.getLogger(MessageResource.class);

  private final String ENTITY_NAME = "message";

  private final MessageService messageService;

  public MessageResource(MessageService messageService) {
    this.messageService = messageService;
  }

  /**
   * {@code POST  /messages} : Create a new message.
   *
   * @param message the messageDTO to create.
   * @return the {@link ResponseEntity} with status {@code 200 (Ok)} and with body the new messageRequestDTO, or with
   * status {@code 400 (Bad Request)} if the message hasn't had an uniqueMessage or TemplateId or GroupUsers.
   */
  @PostMapping("/messages")
  public ResponseEntity<MessageRequestDTO> createMessage(@RequestBody MessageRequestDTO message) {
    log.debug("REST request to save Message : {}", message);
    if (!checkUniqMessage(message.getUniqueMessage())) {
      throw new BadRequestAlertException("Uniq message can't be null", ENTITY_NAME, "uniqueMessageIsNull");
    }
    if (message.getTemplateId() == null && message.getGroupUsers() == null) {
      throw new BadRequestAlertException("templateId or groupId can't be null", ENTITY_NAME,
          "templateIdOrGroupIdIsNull");
    }
    messageService.save(message);
    return ResponseEntity.ok().body(message);
  }

  /**
   * {@code GET  /messages/:uniqueMessage} : get the "uniqueMessage" message.
   *
   * @param uniqueMessage the uniqueMessage of the messageDTO to retrieve.
   * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the messageDTO, or with status
   * {@code 404 (Not Found)}.
   */
  @GetMapping("/messages/{uniqueMessage}")
  public ResponseEntity<Optional<MessageDTO>> getMessage(@PathVariable String uniqueMessage) {
    log.debug("REST request to get Message : {}", uniqueMessage);
    return ResponseEntity.ok().body(messageService.findByUniqueMessage(uniqueMessage));
  }
}
