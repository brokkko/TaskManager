package com.brokkko.taskmanager.web.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
public class AuthenticationDTO {
    private String email;
    private String password;
}
