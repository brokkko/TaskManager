package com.brokkko.taskmanager.repositories;

import com.brokkko.taskmanager.models.TeamProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeamProjectRepository extends JpaRepository<TeamProjectEntity, UUID> {

}
