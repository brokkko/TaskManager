package com.brokkko.taskmanager.models;

import com.brokkko.taskmanager.enumerations.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String userAppName;
    @Enumerated(EnumType.STRING)
    private Role role;

//    @ManyToMany(mappedBy = "users")
//    private Set<TeamProjectEntity> teamProjects;

}
