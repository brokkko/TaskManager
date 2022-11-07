package com.brokkko.taskmanager.domain.boards;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface BoardService {
    Board create(Board board, UUID userId);
    Board update(Board board);
    Board get(UUID id);
    List<Board> getAllByUserId(Pageable pageableObj, UUID userId);
    void delete(UUID id);
    void deleteAllByUserId(UUID userId);
}
