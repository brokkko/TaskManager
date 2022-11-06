package com.brokkko.taskmanager.domain.tasks;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    Task create(Task task, UUID boardId);
    Task update(Task task, UUID taskId);
    Task get(UUID id);
    List<Task> getAllByBoardIdAndStatus(String status, UUID boardId);
    List<Task> getAllByBoardId(Pageable pageableObj, UUID boardId);
    void delete(UUID id);
    void deleteByBoardId(UUID boardId);
}
