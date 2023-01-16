package com.brokkko.taskmanager.services.mapping.users;

import com.brokkko.taskmanager.domain.users.User;
import com.brokkko.taskmanager.models.UserEntity;
import org.modelmapper.ModelMapper;

public class MappingUserService extends ModelMapper {
    public User mapToUser(UserEntity userEntity) {
        return map(userEntity, User.class);
    }
    public UserEntity mapFromUser(User user) {
        return map(user, UserEntity.class);
    }
}
