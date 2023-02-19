package com.brokkko.taskmanager.domain.projects;

import com.brokkko.taskmanager.domain.tasks.Task;
import com.brokkko.taskmanager.domain.users.User;

import java.util.List;
import java.util.UUID;

public interface ProjectService {
    Project createProject(Project project);
    Project getProjectById(UUID projectId);
    User getOwnerByProjectId(UUID projectId);
    List<User> getParticipantsByProjectId(UUID id);
    List<Task> getTasksByProjectId(UUID id);
    Project updateProject(Project project);
    void deleteProjectById(UUID projectId);

}
