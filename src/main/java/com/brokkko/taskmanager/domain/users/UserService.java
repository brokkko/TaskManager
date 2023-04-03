package com.brokkko.taskmanager.domain.users;

import java.util.Optional;
import java.util.UUID;

public interface UserService {

    User create(User user);

    Optional<User> getUserByEmail(String email);

    Optional<User> getUserByEmailAndPassword(String email, String password);

    Optional<User> getUserById(UUID id);

    Optional<User> update(User user);

    void delete(UUID id);
}
