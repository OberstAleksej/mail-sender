package com.mail.sender.core.service.mapper;

import com.mail.sender.core.domain.MessageSendingHistory;
import com.mail.sender.core.service.dto.MailResultData;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link MessageSendingHistory} and its DTO {@link MailResultData}.
 */
@Mapper(componentModel = "spring")
public interface MessageSendingHistoryMapper extends EntityMapper<MailResultData, MessageSendingHistory> {

}
