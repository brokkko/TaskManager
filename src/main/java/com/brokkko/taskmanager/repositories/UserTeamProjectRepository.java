package com.brokkko.taskmanager.repositories;

import com.brokkko.taskmanager.models.UserTeamProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserTeamProjectRepository extends JpaRepository<UserTeamProjectEntity, UUID> {

}
