package com.brokkko.taskmanager.controllers;

import com.brokkko.taskmanager.domain.projects.ProjectService;
import com.brokkko.taskmanager.domain.users.UserService;
import com.brokkko.taskmanager.services.mapping.projects.MappingProjectDTOService;
import com.brokkko.taskmanager.services.mapping.users.MappingUserDTOService;
import com.brokkko.taskmanager.web.dto.ProjectDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Create project")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created a project"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Authorization denied"),
            @ApiResponse(responseCode = "500", description = "Unexpected system exception"),
            @ApiResponse(responseCode = "502", description = "An error has occurred with an upstream service")
    })
    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@RequestHeader("user-id") UUID userId,
                                                    @RequestBody ProjectDTO projectDTO) {
        return userService.getUserById(userId)
                .map(mappingUserDTOService::mapToUserDTO)
                .map(userDTO -> {
                    projectDTO.setOwner(userDTO);
                    return projectService.createProject(mappingProjectDTOService.mapFromProjectDTO(projectDTO));
                })
                .map(mappingProjectDTOService::mapToProjectDTO)
                .map(projectDTOResponse -> new ResponseEntity<>(projectDTOResponse, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @Operation(summary = "Gets project by id")
    @GetMapping(value = "/{projectId}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable(name = "projectId") UUID id) {
        return projectService
                .getProjectById(id)
                .map(mappingProjectDTOService::mapToProjectDTO)
                .map(projectDTO -> new ResponseEntity<>(projectDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}
