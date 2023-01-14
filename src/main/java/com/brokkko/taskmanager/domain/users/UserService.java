package com.brokkko.taskmanager.domain.users;

import com.brokkko.taskmanager.models.UserEntity;

import java.util.UUID;

public interface UserService {
    User create(User user);
    User getUserByEmail(String email);
    void delete(UUID id);
}
