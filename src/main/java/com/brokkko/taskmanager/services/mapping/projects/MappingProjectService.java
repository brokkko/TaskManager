package com.brokkko.taskmanager.services.mapping.projects;

import com.brokkko.taskmanager.domain.projects.Project;
import com.brokkko.taskmanager.models.ProjectEntity;
import org.modelmapper.ModelMapper;

public class MappingProjectService extends ModelMapper {
    public Project mapToProject(ProjectEntity projectEntity) {
        return map(projectEntity, Project.class);
    }
    public ProjectEntity mapFromProject(Project project) {
        return map(project, ProjectEntity.class);
    }
}
