package com.brokkko.taskmanager.controllers;

import com.brokkko.taskmanager.domain.projects.ProjectService;
import com.brokkko.taskmanager.domain.users.UserService;
import com.brokkko.taskmanager.services.mapping.projects.MappingProjectDTOService;
import com.brokkko.taskmanager.services.mapping.users.MappingUserDTOService;
import com.brokkko.taskmanager.web.dto.ProjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.brokkko.taskmanager.config.ConstantsConfiguration.PROJECTS;

@RestController
@RequestMapping(value = PROJECTS)
@Slf4j
public class ProjectController {
    private final ProjectService projectService;
    private final UserService userService;
    private final MappingProjectDTOService mappingProjectDTOService;
    private final MappingUserDTOService mappingUserDTOService;

    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
        mappingProjectDTOService = new MappingProjectDTOService();
        mappingUserDTOService = new MappingUserDTOService();
    }

    @PostMapping("/{userId}") // TODO: send it in header
    public ResponseEntity<ProjectDTO> createProject(@PathVariable(name = "userId") UUID userId,
                                                    @RequestBody ProjectDTO projectDTO) {
        projectDTO.setUser(mappingUserDTOService.mapToUserDTO(userService.getUserById(userId)));
        return new ResponseEntity<>(
                mappingProjectDTOService.mapToProjectDTO(
                        projectService.createProject(mappingProjectDTOService.mapFromProjectDTO(projectDTO))),
                HttpStatus.CREATED);
    }

    @GetMapping(value = "/{projectId}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable(name = "projectId") UUID id) {
        return new ResponseEntity<>(
                mappingProjectDTOService.mapToProjectDTO(
                        projectService.getProjectById(id)),
                HttpStatus.OK
        );
    }

}
