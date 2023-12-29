package com.mail.sender.core.repository;

import com.mail.sender.core.domain.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Uer entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  @Query(value = "SELECT user FROM User user WHERE user.groupUsers=:groupUsers")
  List<User> findAllByGroupUsers(@Param("groupUsers")Long groupUsers);
}
