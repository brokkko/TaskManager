package com.brokkko.taskmanager.repositories;

import com.brokkko.taskmanager.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByUsernameAndPassword(String username, String password);
    UserEntity findByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
