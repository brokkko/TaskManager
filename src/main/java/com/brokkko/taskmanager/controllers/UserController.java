package com.brokkko.taskmanager.controllers;

import com.brokkko.taskmanager.domain.users.UserService;
import com.brokkko.taskmanager.services.mapping.user.MappingUserDTOService;
import com.brokkko.taskmanager.web.dto.AuthenticationDTO;
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
//    private final UserService userService;
//    private final MappingUserDTOService mappingUserDTOService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//        this.mappingUserDTOService = new MappingUserDTOService();
//    }
//
//    @PostMapping
//    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
//        return new ResponseEntity<>(
//                mappingUserDTOService.mapToUserDTO(
//                        userService.create(
//                                mappingUserDTOService.mapFromUserDTO(userDTO))), HttpStatus.CREATED
//        );
//    }

//    @GetMapping(value = "/authentication") // POST sso
//    public ResponseEntity<UUID> authenticate(@RequestBody AuthenticationDTO authenticationDTO) {
//        return new ResponseEntity<>(
//                userService.authenticate(authenticationDTO.getUsername(), authenticationDTO.getPassword()),
//                HttpStatus.FOUND
//        );
//    }


//    @DeleteMapping(value = "/{userId}")
//    public ResponseEntity<HttpStatus> delete(@PathVariable(name = "userId") UUID id) {
//        userService.delete(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
