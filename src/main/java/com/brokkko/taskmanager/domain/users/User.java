package com.brokkko.taskmanager.domain.users;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class User {
    public UUID id;
    public String username;
    public String email;
    public String password;

}
