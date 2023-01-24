package com.brokkko.taskmanager.web.dto;

import com.brokkko.taskmanager.enumerations.Role;
import lombok.*;

import java.util.UUID;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private UUID id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String userAppName;
    private Role role;
}
