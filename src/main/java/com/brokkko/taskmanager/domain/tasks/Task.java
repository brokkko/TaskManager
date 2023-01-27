package com.brokkko.taskmanager.domain.tasks;

import com.brokkko.taskmanager.domain.projects.Project;
import com.brokkko.taskmanager.domain.users.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class Task {
    private UUID id;
    private String name;
    private String description;
    private Date dateOfCreation;
    private String status;
    private Date deadline;
    private Time timeEstimate;
    private Time timeSpent;

    @JsonProperty("user")
    User user;

    @JsonProperty("project")
    Project project;
}
