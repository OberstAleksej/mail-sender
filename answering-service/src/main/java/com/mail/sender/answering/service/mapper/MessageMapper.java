package com.mail.sender.answering.service.mapper;

import com.mail.sender.answering.domain.Message;
import com.mail.sender.answering.service.dto.MessageDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link Message} and its DTO {@link MessageDTO}.
 */
@Mapper(componentModel = "spring")
public interface MessageMapper extends EntityMapper<MessageDTO, Message> {

  MessageDTO toDto(Message s);

  Message toEntity(MessageDTO messageDTO);
}
