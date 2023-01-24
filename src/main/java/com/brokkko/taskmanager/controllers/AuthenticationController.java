package com.brokkko.taskmanager.controllers;

import com.brokkko.taskmanager.config.JwtUtils;
import com.brokkko.taskmanager.domain.users.UserServiceImpl;
import com.brokkko.taskmanager.exceptions.UserNotAuthenticatedException;
import com.brokkko.taskmanager.services.mapping.users.MappingUserDTOService;
import com.brokkko.taskmanager.web.dto.AuthenticationDTO;
import com.brokkko.taskmanager.web.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

import static com.brokkko.taskmanager.config.ConstantsConfiguration.AUTHENTICATION;

@RestController
@RequestMapping(value = AUTHENTICATION)
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserServiceImpl userService;
    private final MappingUserDTOService mappingUserDTOService = new MappingUserDTOService();
    private final JwtUtils jwtUtils;

    @GetMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        UserDTO existedUser = mappingUserDTOService.mapToUserDTO(
                userService.getUserByEmail(request.getEmail()));
        if (existedUser == null) {
            throw new UserNotAuthenticatedException("User not authenticated");
        }
        final UserDetails userDetails = new User(
                existedUser.getEmail(),
                existedUser.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(existedUser.getRole().toString()))
        );
        return ResponseEntity.ok(jwtUtils.generateToken(userDetails));

    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUpUser(@RequestBody UserDTO newUserRequest) {
        return new ResponseEntity<>(
                mappingUserDTOService.mapToUserDTO(
                        userService.create(
                                mappingUserDTOService.mapFromUserDTO(newUserRequest))), HttpStatus.CREATED
        );
    }
}
