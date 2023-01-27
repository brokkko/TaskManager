package com.brokkko.taskmanager.domain.userteamprojects;

import com.brokkko.taskmanager.domain.teamprojects.TeamProject;
import com.brokkko.taskmanager.domain.users.User;
import com.brokkko.taskmanager.enumerations.UserPosition;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class UserTeamProject {
    private UUID id;
    private UserPosition position;

    @JsonProperty("user")
    User user;

    @JsonProperty("team_project")
    TeamProject teamProject;
}
