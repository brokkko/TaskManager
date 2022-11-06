package com.brokkko.taskmanager.services.expansion;

import com.brokkko.taskmanager.domain.boards.Board;
import com.brokkko.taskmanager.domain.tasks.Task;
import com.brokkko.taskmanager.exceptions.IdNotFoundException;
import com.brokkko.taskmanager.repositories.BoardRepository;
import com.brokkko.taskmanager.repositories.TaskRepository;
import com.brokkko.taskmanager.services.mapping.board.MappingBoardService;
import com.brokkko.taskmanager.services.mapping.task.MappingTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class DTOExpansionService {
    private final TaskRepository taskRepository;
    private final BoardRepository boardRepository;
    private final MappingTaskService mappingTaskService;
    private final MappingBoardService mappingBoardService;

    public DTOExpansionService(TaskRepository taskRepository, BoardRepository boardRepository) {
        this.taskRepository = taskRepository;
        this.boardRepository = boardRepository;
        this.mappingTaskService = new MappingTaskService();
        this.mappingBoardService = new MappingBoardService();
    }

//    public Task addBoardObject(Task task, UUID board_id) {
//        Board board = mappingBoardService.mapToBoard(
//                boardRepository.findById(board_id)
//                        .orElseThrow(() -> new IdNotFoundException("Board " + board_id + " not found.")));
//        log.warn(board.getId() + " " + board.getName());
//        task.setBoard(mappingBoardService.mapFromBoard(board));
//        return task;
//    }

//    public Board addUserObject(Board board, UUID user_id) {
//
//    }
}
