package com.mail.sender.answering.repository;

import com.mail.sender.answering.domain.Message;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Message entity.
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

  @Query("select message from Message message left join fetch message.tags where message.uniqueMessage =:uniqueMessage")
  Optional<Message> findByUniqueMessage(@Param("uniqueMessage") String uniqueMessage);
}
