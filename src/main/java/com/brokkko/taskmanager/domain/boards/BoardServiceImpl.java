package com.brokkko.taskmanager.domain.boards;

import com.brokkko.taskmanager.exceptions.IdNotFoundException;
import com.brokkko.taskmanager.models.BoardEntity;
import com.brokkko.taskmanager.repositories.BoardRepository;
import com.brokkko.taskmanager.repositories.UserRepository;
import com.brokkko.taskmanager.services.mapping.board.MappingBoardService;
import com.brokkko.taskmanager.services.mapping.user.MappingUserService;
import com.brokkko.taskmanager.services.utils.ComparisonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final MappingBoardService mappingBoardService;
    private final MappingUserService mappingUserService;

    public BoardServiceImpl(BoardRepository boardRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
        this.mappingBoardService = new MappingBoardService();
        this.mappingUserService = new MappingUserService();
    }

    @Override
    public Board create(Board board, UUID userId) {
        return mappingBoardService.mapToBoard(userRepository.findById(userId).map((userEntity) -> {
            board.setUser(mappingUserService.mapToUser(userEntity));
            return boardRepository.save(mappingBoardService.mapFromBoard(board));
        }).orElseThrow(() -> new IdNotFoundException("User " + userId + " not found.")));
    }

    @Override
    public Board update(Board updatedBoard) {
        Board board = this.get(updatedBoard.getId());
        updatedBoard = (Board) ComparisonService.partialUpdate(board, updatedBoard);
        return mappingBoardService.mapToBoard(boardRepository.save(mappingBoardService.mapFromBoard(updatedBoard)));
    }

    @Override
    public Board get(UUID id) {
        return mappingBoardService.mapToBoard(boardRepository
                .findById(id)
                .orElseThrow(() ->
                        new IdNotFoundException("Board " + id + " not found."))
        );
    }

    @Override
    public List<Board> getAllByUserId(Pageable pageableObj, UUID userId) {
        if(userRepository.existsById(userId)) {
            Page<BoardEntity> pageResult = boardRepository.findAllByUserId(userId, pageableObj);
            if (pageResult.hasContent()) {
                return mappingBoardService.mapToBoardList(pageResult.getContent());
            }
            return Collections.emptyList();
        } else
            throw new IdNotFoundException("User " + userId + " not found.");
    }

    @Override
    public void delete(UUID id) {
        if(boardRepository.existsById(id)) {
            boardRepository.deleteById(id);
        } else
            throw new IdNotFoundException("Board " + id + " not found.");
    }

    @Override
    public void deleteAllByUserId(UUID userId) {
        if(userRepository.existsById(userId)) {
            boardRepository.deleteAllByUserId(userId);
        } else
            throw new IdNotFoundException("User " + userId + " not found.");
    }
}
