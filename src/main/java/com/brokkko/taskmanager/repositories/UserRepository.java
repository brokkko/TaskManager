package com.brokkko.taskmanager.repositories;

import com.brokkko.taskmanager.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    UserEntity findByEmail(String email);
    UserEntity findAllByEmailAndPassword(String email, String password);
    Boolean existsByEmail(String email);
}
