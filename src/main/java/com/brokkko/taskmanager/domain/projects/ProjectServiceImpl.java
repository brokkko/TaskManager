package com.brokkko.taskmanager.domain.projects;

import com.brokkko.taskmanager.domain.tasks.Task;
import com.brokkko.taskmanager.domain.users.User;
import com.brokkko.taskmanager.exceptions.IdNotFoundException;
import com.brokkko.taskmanager.repositories.ProjectRepository;
import com.brokkko.taskmanager.services.mapping.projects.MappingProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final MappingProjectService mappingProjectService;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
        mappingProjectService = new MappingProjectService();
    }

    @Override
    public Project createProject(Project project) {
        return mappingProjectService.mapToProject(projectRepository.save(mappingProjectService.mapFromProject(project)));
    }

    @Override
    public Optional<Project> getProjectById(UUID projectId) {
        return Optional.ofNullable(mappingProjectService.mapToProject(
                projectRepository
                        .findById(projectId)
                        .orElseThrow(() ->
                                new IdNotFoundException("Project " + projectId + " not found.")
                        )));
    }

    @Override
    public Optional<User> getOwnerByProjectId(UUID projectId) {
        return getProjectById(projectId)
                .map(Project::getOwner);
    }

    @Override
    public List<User> getParticipantsByProjectId(UUID id) {
        return null;
    }

    @Override
    public List<Task> getTasksByProjectId(UUID id) {
        return null;
    }

    @Override
    public Optional<Project> updateProject(Project project) {
        return Optional.ofNullable(mappingProjectService.mapToProject(
                projectRepository
                        .update(mappingProjectService.mapFromProject(project))
                        .orElseThrow(() -> new IdNotFoundException("Project " + project.getId() + " not found."))
        ));
    }

    @Override
    public void deleteProjectById(UUID projectId) {
        if(projectRepository.existsById(projectId)) {
            projectRepository.deleteById(projectId);
        } else throw new IdNotFoundException("Project " + projectId + " not found.");
    }
}
