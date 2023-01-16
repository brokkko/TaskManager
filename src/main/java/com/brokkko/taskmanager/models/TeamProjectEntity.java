package com.brokkko.taskmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "team_projects")
public class TeamProjectEntity implements Serializable {
    @Id
    @Column(name="project_id")
    private UUID team_project_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ProjectEntity project;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private Set<UserEntity> user;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable
//    private Set<UserEntity> users;

}
