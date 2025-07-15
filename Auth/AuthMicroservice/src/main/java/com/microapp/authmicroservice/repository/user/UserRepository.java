package com.microapp.authmicroservice.repository.user;

import com.microapp.authmicroservice.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Override
    Optional<User> findById(Long id);
}
