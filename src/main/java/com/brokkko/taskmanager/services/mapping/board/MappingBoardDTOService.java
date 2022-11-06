package com.brokkko.taskmanager.services.mapping.board;

import com.brokkko.taskmanager.domain.boards.Board;
import com.brokkko.taskmanager.web.dto.BoardDTO;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class MappingBoardDTOService extends ModelMapper {
    public BoardDTO mapToBoardDTO(Board board) {
        return map(board, BoardDTO.class);
    }

    public List<BoardDTO> mapToBoardDTOList(List<Board> boardList) {
        return boardList.stream()
                .map((board) -> map(board, BoardDTO.class))
                .collect(Collectors.toList());
    }

    public Board mapFromBoardDTO(BoardDTO boardDTO) {
        return map(boardDTO, Board.class);
    }
}
