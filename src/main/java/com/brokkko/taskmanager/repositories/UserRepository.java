package com.brokkko.taskmanager.repositories;

import com.brokkko.taskmanager.models.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findAllByEmailAndPassword(String email, String password);

    Boolean existsByEmail(String email);

    Optional<UserEntity> update(UserEntity user);
}
