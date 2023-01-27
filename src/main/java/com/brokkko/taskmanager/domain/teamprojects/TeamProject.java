package com.brokkko.taskmanager.domain.teamprojects;

import com.brokkko.taskmanager.domain.projects.Project;
import com.brokkko.taskmanager.domain.users.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class TeamProject {
    private UUID id;
    private String name;
    private String description;

    @JsonProperty("project")
    Project project;
}
