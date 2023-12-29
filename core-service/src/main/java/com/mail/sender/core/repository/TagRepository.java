package com.mail.sender.core.repository;

import com.mail.sender.core.domain.Tag;
import java.util.Set;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Tag entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

  @Cacheable(cacheNames = "tags")
  @Query(value = "SELECT tag FROM Tag tag WHERE tag.name in :names ")
  Set<Tag> findAllByNames(@Param("names") Set<String> names);
}
