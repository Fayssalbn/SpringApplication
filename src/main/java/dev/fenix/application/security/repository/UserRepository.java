package dev.fenix.application.security.repository;


import dev.fenix.application.resume.model.Icon;
import dev.fenix.application.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>  {
    Optional<User> findByUserName(String userName);

    User getUserById(Integer id);
}
