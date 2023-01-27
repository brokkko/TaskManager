package com.brokkko.taskmanager.models;

import com.brokkko.taskmanager.enumerations.UserPosition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_team_projects")
public class UserTeamProjectEntity {
    @Id
    private UUID id;

    @Enumerated(EnumType.STRING)
    private UserPosition position;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private UserEntity user;

    @OneToOne(fetch = FetchType.LAZY)
    private TeamProjectEntity teamProject;
}
