package com.mail.sender.core.service.mapper;

import com.mail.sender.core.domain.Message;
import com.mail.sender.core.service.dto.MessageDTO;
import com.mail.sender.core.service.dto.MessageRequestDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link Message} and its DTO {@link MessageDTO}.
 */
@Mapper(componentModel = "spring", uses = {TagMapper.class})
public interface MessageMapper extends EntityMapper<MessageRequestDTO, Message> {

  Message toEntity(MessageRequestDTO messageRequestDTO);
}
