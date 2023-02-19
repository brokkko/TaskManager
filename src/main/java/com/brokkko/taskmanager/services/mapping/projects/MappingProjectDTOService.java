package com.brokkko.taskmanager.services.mapping.projects;

import com.brokkko.taskmanager.domain.projects.Project;
import com.brokkko.taskmanager.web.dto.ProjectDTO;
import org.modelmapper.ModelMapper;

public class MappingProjectDTOService extends ModelMapper {
    public ProjectDTO mapToProjectDTO(Project project) {
        return map(project, ProjectDTO.class);
    }
    public Project mapFromProjectDTO(ProjectDTO projectDTO) {
        return map(projectDTO, Project.class);
    }
}
