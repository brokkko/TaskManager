package com.brokkko.taskmanager.controllers;

import com.brokkko.taskmanager.domain.users.UserService;
import com.brokkko.taskmanager.services.mapping.users.MappingUserDTOService;
import com.brokkko.taskmanager.web.dto.AuthenticationDTO;
import com.brokkko.taskmanager.web.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Create user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created a user"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Authorization denied"),
            @ApiResponse(responseCode = "500", description = "Unexpected system exception"),
            @ApiResponse(responseCode = "502", description = "An error has occurred with an upstream service")
    })
    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable(name = "userId") UUID id) {
        return userService
                .getUserById(id)
                .map(mappingUserDTOService::mapToUserDTO)
                .map(userDTO -> new ResponseEntity<>(userDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @Operation(summary = "Gets user by email and password")
    @GetMapping()
    public ResponseEntity<UserDTO> getUserByEmailAndPassword(@RequestBody AuthenticationDTO userData) {
        return userService
                .getUserByEmailAndPassword(userData.getEmail(), userData.getPassword())
                .map(mappingUserDTOService::mapToUserDTO)
                .map(userDTO -> new ResponseEntity<>(userDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping()
    public ResponseEntity<UserDTO> updateUserById(@RequestBody UserDTO updatedUser) {
        return userService
                .update(mappingUserDTOService.mapFromUserDTO(updatedUser))
                .map(mappingUserDTOService::mapToUserDTO)
                .map(userDTO -> new ResponseEntity<>(userDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @Operation(summary = "Deletes user by id")
    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name = "userId") UUID id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
