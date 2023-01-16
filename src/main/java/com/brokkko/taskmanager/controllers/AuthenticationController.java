package com.brokkko.taskmanager.controllers;

import com.brokkko.taskmanager.config.JwtUtils;
import com.brokkko.taskmanager.domain.users.UserServiceImpl;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        UserDTO existedUser = mappingUserDTOService.mapToUserDTO(
                userService.getUserByEmail(request.getEmail()));
        if (existedUser == null) {
            // TODO handle error
            return ResponseEntity.status(400).body("Some error");
        }
        final UserDetails userDetails = new User(
                existedUser.getEmail(),
                existedUser.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(existedUser.getRole().toString()))
        );
        // TODO return existed user
        return ResponseEntity.ok(jwtUtils.generateToken(userDetails));

    }

    @PostMapping("/signin")
    public ResponseEntity<UserDTO> signInUser(@RequestBody UserDTO newUserRequest) {
        return new ResponseEntity<>(
                mappingUserDTOService.mapToUserDTO(
                        userService.create(
                                mappingUserDTOService.mapFromUserDTO(newUserRequest))), HttpStatus.CREATED
        );
    }
}
