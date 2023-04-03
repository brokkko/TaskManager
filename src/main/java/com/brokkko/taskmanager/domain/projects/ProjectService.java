package com.brokkko.taskmanager.domain.projects;

import com.brokkko.taskmanager.domain.tasks.Task;
import com.brokkko.taskmanager.domain.users.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProjectService {
    Project createProject(Project project);
    Optional<Project> getProjectById(UUID projectId);
    Optional<User> getOwnerByProjectId(UUID projectId);
    List<User> getParticipantsByProjectId(UUID id);
    List<Task> getTasksByProjectId(UUID id);
    Optional<Project> updateProject(Project project);
    void deleteProjectById(UUID projectId);

}
