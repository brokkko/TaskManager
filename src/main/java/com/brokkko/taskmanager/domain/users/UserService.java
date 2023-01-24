package com.brokkko.taskmanager.domain.users;

import java.util.UUID;

public interface UserService {
    User create(User user);
    User getUserByEmail(String email);
    User getUserByEmailAndPassword(String email, String password);
    User getUserById(UUID id);
    void delete(UUID id);
}
