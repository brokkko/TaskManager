package com.brokkko.taskmanager.domain.users;

import java.util.UUID;

public interface UserService {
    User create(User user);
    void delete(UUID id);
}
