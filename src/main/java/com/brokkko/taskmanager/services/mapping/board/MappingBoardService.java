package com.brokkko.taskmanager.services.mapping.board;

import com.brokkko.taskmanager.domain.boards.Board;
import com.brokkko.taskmanager.models.BoardEntity;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class MappingBoardService extends ModelMapper {
    public Board mapToBoard(BoardEntity boardEntity) {
        return map(boardEntity, Board.class);
    }

    public List<Board> mapToBoardList(List<BoardEntity> boardEntityList) {
        return boardEntityList.stream()
                .map((boardEntity) -> map(boardEntity, Board.class))
                .collect(Collectors.toList());
    }

    public BoardEntity mapFromBoard(Board board) {
        return map(board, BoardEntity.class);
    }
}
