package com.brokkko.taskmanager.domain.boards;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface BoardService {
    Board create(Board board);
    Board update(Board board);
    Board get(UUID id);
    List<Board> getAll(Pageable pageableObj);
    Boolean delete(UUID id);
}
