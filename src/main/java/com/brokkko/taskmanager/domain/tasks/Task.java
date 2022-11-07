package com.brokkko.taskmanager.domain.tasks;

import com.brokkko.taskmanager.domain.boards.Board;
import com.brokkko.taskmanager.enumerations.TaskStatus;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class Task {
    private UUID id;
    private String name;
    private TaskStatus status;
    private String description;
    private Date startDate;
    private Date endDate;
    private Board board;

}
