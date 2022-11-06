package com.brokkko.taskmanager.domain.boards;

import com.brokkko.taskmanager.repositories.BoardRepository;
import com.brokkko.taskmanager.repositories.TaskRepository;
import com.brokkko.taskmanager.services.expansion.DTOExpansionService;
import com.brokkko.taskmanager.services.mapping.board.MappingBoardService;
import com.brokkko.taskmanager.services.mapping.task.MappingTaskService;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;
    private final MappingBoardService mappingBoardService;
    private final DTOExpansionService expansionService;

    public BoardServiceImpl(TaskRepository taskRepository, BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
        this.mappingBoardService = new MappingBoardService();
        this.expansionService = new DTOExpansionService(taskRepository, boardRepository);
    }

    @Override
    public Board create(Board board) {
//        board = expansionService.addBoardObject(task, task.getBoardId());
//        return mappingTaskService.mapToTask(
//                taskRepository.save(mappingTaskService.mapFromTask(task)));
        return null;
    }

    @Override
    public Board update(Board board) {
        return null;
    }

    @Override
    public Board get(UUID id) {
        return null;
    }

    @Override
    public List<Board> getAll(Pageable pageableObj) {
        return null;
    }

    @Override
    public Boolean delete(UUID id) {
        return null;
    }
}
