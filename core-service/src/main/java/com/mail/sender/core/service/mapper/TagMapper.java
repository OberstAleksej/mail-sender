package com.mail.sender.core.service.mapper;

import com.mail.sender.core.domain.Tag;
import com.mail.sender.core.service.dto.TagDTO;
import java.util.Set;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

/**
 * Mapper for the entity {@link Tag} and its DTO {@link TagDTO}.
 */
@Mapper(componentModel = "spring")
public interface TagMapper extends EntityMapper<TagDTO, Tag> {

  @Named("nameSet")
  @BeanMapping(ignoreByDefault = true)
  @Mapping(target = "id", ignore = true)
  Set<TagDTO> toDtoNameSet(Set<Tag> tag);
}
