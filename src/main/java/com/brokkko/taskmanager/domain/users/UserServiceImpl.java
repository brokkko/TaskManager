package com.brokkko.taskmanager.domain.users;

import com.brokkko.taskmanager.exceptions.IdNotFoundException;
import com.brokkko.taskmanager.exceptions.UserNotAuthenticatedException;
import com.brokkko.taskmanager.repositories.UserRepository;
import com.brokkko.taskmanager.services.utils.GenerateAppNameService;
import com.brokkko.taskmanager.services.mapping.users.MappingUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MappingUserService mappingUserService;
    private final GenerateAppNameService generateAppNameService;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.mappingUserService = new MappingUserService();
        this.generateAppNameService = new GenerateAppNameService();
    }

    @Override
    public User create(User user) {
        user.setUserAppName(generateAppNameService.generateAppName(user.getFirstname(), user.getLastname()));
        return mappingUserService.mapToUser(userRepository.save(mappingUserService.mapFromUser(user)));
    }

    @Override
    public User getUserByEmail(String email) {
        if(userRepository.existsByEmail(email)) {
            return mappingUserService.mapToUser(userRepository.findByEmail(email));
        } else return null;

    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        if(userRepository.existsByEmail(email)){
            return mappingUserService.mapToUser(userRepository.findAllByEmailAndPassword(email, password));
        } else throw new UserNotAuthenticatedException("User with that email doesn't exist: " + email);
    }

    @Override
    public User getUserById(UUID id) {
        return mappingUserService.mapToUser(
                userRepository
                        .findById(id)
                        .orElseThrow(() ->
                                new IdNotFoundException("User " + id + " not found.")
                        ));

    }

    @Override
    public void delete(UUID id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else throw new IdNotFoundException("User " + id + " not found.");
    }
}
