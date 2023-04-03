package com.brokkko.taskmanager.repositories;

import com.brokkko.taskmanager.models.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

public interface ProjectRepository extends JpaRepository<ProjectEntity, UUID> {
    @Transactional
    void deleteAllByOwnerId(UUID ownerId);

    Optional<ProjectEntity> update(ProjectEntity updatedProject);
}
