package com.brokkko.taskmanager.services.mapping.users;

import com.brokkko.taskmanager.domain.users.User;
import com.brokkko.taskmanager.web.dto.UserDTO;
import org.modelmapper.ModelMapper;

public class MappingUserDTOService extends ModelMapper {
    public UserDTO mapToUserDTO(User user) {
        return map(user, UserDTO.class);
    }
    public User mapFromUserDTO(UserDTO userDTO) {
        return map(userDTO, User.class);
    }
}
