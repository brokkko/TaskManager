package com.brokkko.taskmanager.services.mapping.user;

import com.brokkko.taskmanager.domain.users.User;
import com.brokkko.taskmanager.models.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;

public class MappingUserService extends ModelMapper {
    public User mapToUser(UserEntity userEntity) {
        return map(userEntity, User.class);
    }
    public UserEntity mapFromUser(User user) {
        return map(user, UserEntity.class);
    }
}
