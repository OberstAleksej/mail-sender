package com.mail.sender.core.service.mapper;

import com.mail.sender.core.service.dto.MailResultData;

/**
 * Contract for a generic dto to entity mapper.
 *
 * @param <D> - DTO type parameter.
 * @param <E> - Entity type parameter.
 */

public interface EntityMapper<D, E> {

  E toEntity(MailResultData dto);

  D toDto(E entity);
}
