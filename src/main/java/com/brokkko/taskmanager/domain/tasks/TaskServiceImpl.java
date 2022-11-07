package com.brokkko.taskmanager.domain.tasks;

import com.brokkko.taskmanager.exceptions.IdNotFoundException;
import com.brokkko.taskmanager.models.TaskEntity;
import com.brokkko.taskmanager.repositories.BoardRepository;
import com.brokkko.taskmanager.repositories.TaskRepository;
import com.brokkko.taskmanager.services.mapping.board.MappingBoardService;
import com.brokkko.taskmanager.services.mapping.task.MappingTaskService;
import com.brokkko.taskmanager.services.utils.ComparisonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final BoardRepository boardRepository;
    private final MappingTaskService mappingTaskService;
    private final MappingBoardService mappingBoardService;

    public TaskServiceImpl(TaskRepository taskRepository, BoardRepository boardRepository) {
        this.taskRepository = taskRepository;
        this.boardRepository = boardRepository;
        this.mappingTaskService = new MappingTaskService();
        this.mappingBoardService = new MappingBoardService();
    }

    @Override
    public Task create(Task task, UUID boardId) {
        return mappingTaskService.mapToTask(boardRepository.findById(boardId).map((boardEntity) -> {
            task.setBoard(mappingBoardService.mapToBoard(boardEntity));
            return taskRepository.save(mappingTaskService.mapFromTask(task));
        }).orElseThrow(() -> new IdNotFoundException("Board " + boardId + " not found.")));
    }

    @Override
    public Task update(Task updatedTask) {
        Task task = this.get(updatedTask.getId());
        updatedTask = (Task) ComparisonService.partialUpdate(task, updatedTask);
        return mappingTaskService.mapToTask(taskRepository.save(mappingTaskService.mapFromTask(updatedTask)));
    }

    @Override
    public Task get(UUID id) {
        return mappingTaskService.mapToTask(taskRepository
                .findById(id)
                .orElseThrow(() ->
                        new IdNotFoundException("Task " + id + " not found."))
        );
    }

    @Override
    public List<Task> getAllByBoardIdAndStatus(String status, UUID boardId) {
        if(boardRepository.existsById(boardId)) {
            List<Task> taskList = mappingTaskService.mapToTaskList(taskRepository.getAllByStatusAndBoardId(status, boardId));
            if (taskList.size() != 0) {
                return taskList;
            }
            return Collections.emptyList();
        } else
            throw new IdNotFoundException("Board " + boardId + " not found.");
    }

    @Override
    public List<Task> getAllByBoardId(Pageable pageableObj, UUID boardId) {
        if(boardRepository.existsById(boardId)) {
            Page<TaskEntity> pageResult = taskRepository.findAllByBoardId(boardId, pageableObj);
            if (pageResult.hasContent()) {
                return mappingTaskService.mapToTaskList(pageResult.getContent());
            }
            return Collections.emptyList();
        } else
            throw new IdNotFoundException("Board " + boardId + " not found.");

    }

    @Override
    public void delete(UUID id) {
        if(taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        } else
            throw new IdNotFoundException("Task " + id + " not found.");
    }

    @Override
    public void deleteByBoardId(UUID boardId) {
        if(boardRepository.existsById(boardId)) {
            taskRepository.deleteAllByBoardId(boardId);
        } else
            throw new IdNotFoundException("Board " + boardId + " not found.");
    }
}
