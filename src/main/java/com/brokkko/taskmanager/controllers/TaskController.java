package com.brokkko.taskmanager.controllers;

import com.brokkko.taskmanager.domain.tasks.TaskService;
import com.brokkko.taskmanager.services.mapping.task.MappingTaskDTOService;
import com.brokkko.taskmanager.web.dto.TaskDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class TaskController {
    private final TaskService taskService;
    private final MappingTaskDTOService mappingTaskDTOService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
        this.mappingTaskDTOService = new MappingTaskDTOService();
    }

    @PostMapping(value = "/boards/{boardId}/tasks")
    public ResponseEntity<TaskDTO> create(@PathVariable(value = "boardId") UUID boardId,
                                          @RequestBody TaskDTO taskDTO) {
        return new ResponseEntity<>(
                mappingTaskDTOService.mapToTaskDTO(
                        taskService.create(
                                mappingTaskDTOService.mapFromTaskDTO(taskDTO), boardId)), HttpStatus.CREATED
        );
    }

    @PutMapping(value = "/tasks/{taskId}")
    public ResponseEntity<TaskDTO> update(@PathVariable(value = "taskId") UUID taskId,
                                          @RequestBody TaskDTO taskDTO) {
        return new ResponseEntity<>(
                mappingTaskDTOService.mapToTaskDTO(
                        taskService.update(
                                mappingTaskDTOService.mapFromTaskDTO(taskDTO), taskId)), HttpStatus.OK
        );
    }

    @GetMapping(value = "/boards/{boardId}/tasks")
    public ResponseEntity<List<TaskDTO>> getAllByBoardId(@PathVariable(value = "boardId") UUID boardId,
                                                @PageableDefault(page = 0, size = 100) Pageable pageableObj) {
        return new ResponseEntity<>(
                mappingTaskDTOService.mapToTaskDTOList(taskService.getAllByBoardId(pageableObj, boardId)),
                HttpStatus.OK
        );
    }

    @GetMapping(value = "/boards/{boardId}/{status}/tasks")
    public ResponseEntity<List<TaskDTO>> getAllByBoardIdAndStatus(@PathVariable(name = "boardId") UUID boardId,
                                             @PathVariable(name = "status") String status) {
        return new ResponseEntity<>(
                mappingTaskDTOService.mapToTaskDTOList(taskService.getAllByBoardIdAndStatus(status, boardId)),
                HttpStatus.OK
        );
    }

    @GetMapping(value = "/tasks/{id}")
    public ResponseEntity<TaskDTO> get(@PathVariable(name = "id") UUID id) {
        return new ResponseEntity<>(mappingTaskDTOService.mapToTaskDTO(taskService.get(id)), HttpStatus.OK);
    }

    @DeleteMapping(value = "/tasks/{taskId}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name = "taskId") UUID id) {
        taskService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/boards/{boardId}/tasks")
    public ResponseEntity<HttpStatus> deleteAllByBoardId(@PathVariable(name = "boardId") UUID id) {
        taskService.deleteByBoardId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
