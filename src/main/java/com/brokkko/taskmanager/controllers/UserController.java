package com.brokkko.taskmanager.controllers;

import com.brokkko.taskmanager.domain.users.UserService;
import com.brokkko.taskmanager.services.mapping.users.MappingUserDTOService;
import com.brokkko.taskmanager.web.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.brokkko.taskmanager.config.ConstantsConfiguration.USERS;

@RestController
@RequestMapping(value = USERS)
@Slf4j
public class UserController {
    private final UserService userService;
    private final MappingUserDTOService mappingUserDTOService;

    public UserController(UserService userService) {
        this.userService = userService;
        this.mappingUserDTOService = new MappingUserDTOService();
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable(name = "userId") UUID id) {
        return new ResponseEntity<>(mappingUserDTOService.mapToUserDTO(userService.getUserById(id)), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name = "userId") UUID id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
