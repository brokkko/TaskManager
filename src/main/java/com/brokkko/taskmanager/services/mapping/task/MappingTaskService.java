package com.brokkko.taskmanager.services.mapping.task;

import com.brokkko.taskmanager.domain.tasks.Task;
import com.brokkko.taskmanager.models.TaskEntity;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class MappingTaskService extends ModelMapper {

    public Task mapToTask(TaskEntity taskEntity) {
        return map(taskEntity, Task.class);
    }

    public List<Task> mapToTaskList(List<TaskEntity> taskEntityList) {
        return taskEntityList.stream()
                .map((taskEntity) -> map(taskEntity, Task.class))
                .collect(Collectors.toList());
    }

    public TaskEntity mapFromTask(Task task) {
        return map(task, TaskEntity.class);
    }

}
