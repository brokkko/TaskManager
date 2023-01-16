package com.brokkko.taskmanager.domain.users;

import com.brokkko.taskmanager.enumerations.Role;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class User {
    private UUID id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String userAppName;
    private Role role;

}
