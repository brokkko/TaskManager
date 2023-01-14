package com.brokkko.taskmanager.domain.users;

import com.brokkko.taskmanager.exceptions.IdNotFoundException;
import com.brokkko.taskmanager.models.UserEntity;
import com.brokkko.taskmanager.repositories.UserRepository;
import com.brokkko.taskmanager.services.mapping.user.MappingUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MappingUserService mappingUserService;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.mappingUserService = new MappingUserService();
    }

    @Override
    public User create(User user) {
        return mappingUserService.mapToUser(userRepository.save(mappingUserService.mapFromUser(user)));
    }

    @Override
    public User getUserByEmail(String email) {
        if(userRepository.existsByEmail(email)) {
            return mappingUserService.mapToUser(userRepository.findByEmail(email));
        } else return null;

    }

    @Override
    public void delete(UUID id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else throw new IdNotFoundException("User " + id + " not found.");
    }
}
