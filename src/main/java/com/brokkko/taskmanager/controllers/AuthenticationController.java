package com.brokkko.taskmanager.controllers;

import com.brokkko.taskmanager.config.JwtUtils;
import com.brokkko.taskmanager.domain.users.User;
import com.brokkko.taskmanager.domain.users.UserServiceImpl;
import com.brokkko.taskmanager.web.dto.AuthenticationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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
    private final JwtUtils jwtUtils;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(
            @RequestBody AuthenticationDTO request
    ) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        User userDB = userService.getUserByEmail(request.getEmail());
        if (userDB == null) {
            return ResponseEntity.status(400).body("Some error happend");
        }
        final UserDetails user = new org.springframework.security.core.userdetails.User(
                userDB.getEmail(),
                userDB.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority("ROLE ADMIN"))
        );
        return ResponseEntity.ok(jwtUtils.generateToken(user));

    }
}
