package com.brokkko.taskmanager.domain.projects;

import com.brokkko.taskmanager.domain.users.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class Project {
    private UUID id;
    private String name;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    private User owner;
}
