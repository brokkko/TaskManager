package com.brokkko.taskmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserTeamProjectRepository extends JpaRepository<UserTeamProjectRepository, UUID> {

}
