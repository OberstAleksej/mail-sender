package com.mail.sender.core.repository;

import com.mail.sender.core.domain.MessageSendingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the MessageSendingHistory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MessageSendingHistoryRepository extends JpaRepository<MessageSendingHistory, Long> {

}
