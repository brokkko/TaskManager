package com.brokkko.taskmanager.services.mapping.task;

import com.brokkko.taskmanager.domain.tasks.Task;
import com.brokkko.taskmanager.web.dto.TaskDTO;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class MappingTaskDTOService extends ModelMapper {
    public TaskDTO mapToTaskDTO(Task task) {
        return map(task, TaskDTO.class);
    }

    public List<TaskDTO> mapToTaskDTOList(List<Task> taskList) {
        return taskList.stream()
                .map((task) -> map(task, TaskDTO.class))
                .collect(Collectors.toList());
    }

    public Task mapFromTaskDTO(TaskDTO taskDTO) {
        return map(taskDTO, Task.class);
    }

}
