package com.brokkko.taskmanager.controllers;

import com.brokkko.taskmanager.domain.boards.BoardService;
import com.brokkko.taskmanager.services.mapping.board.MappingBoardDTOService;
import com.brokkko.taskmanager.web.dto.BoardDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class BoardController {
    private final BoardService boardService;
    private final MappingBoardDTOService mappingBoardDTOService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
        this.mappingBoardDTOService = new MappingBoardDTOService();
    }

    @PostMapping(value = "/users/{userId}/boards")
    public ResponseEntity<BoardDTO> create(@PathVariable(value = "userId") UUID userId,
                                           @RequestBody BoardDTO boardDTO) {
        return new ResponseEntity<>(
                mappingBoardDTOService.mapToBoardDTO(
                        boardService.create(
                                mappingBoardDTOService.mapFromBoardDTO(boardDTO), userId)), HttpStatus.CREATED
        );
    }

    @PutMapping(value = "/boards")
    public ResponseEntity<BoardDTO> update(@RequestBody BoardDTO boardDTO) {
        return new ResponseEntity<>(
                mappingBoardDTOService.mapToBoardDTO(
                        boardService.update(
                                mappingBoardDTOService.mapFromBoardDTO(boardDTO))), HttpStatus.OK
        );
    }

    @GetMapping(value = "/boards/{id}")
    public ResponseEntity<BoardDTO> get(@PathVariable(name = "id") UUID id) {
        return new ResponseEntity<>(mappingBoardDTOService.mapToBoardDTO(boardService.get(id)), HttpStatus.OK);
    }

    @GetMapping(value = "/users/{userId}/boards")
    public ResponseEntity<List<BoardDTO>> getAllByUserId(@PathVariable(value = "userId") UUID userId,
                                                         @PageableDefault(page = 1, size = 100) Pageable pageableObj) {
        return new ResponseEntity<>(
                mappingBoardDTOService.mapToBoardDTOList(boardService.getAllByUserId(pageableObj, userId)),
                HttpStatus.OK
        );
    }

    @DeleteMapping(value = "/boards/{boardId}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name = "boardId") UUID id) {
        boardService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/users/{userId}/boards")
    public ResponseEntity<HttpStatus> deleteAllByUserId(@PathVariable(name = "userId") UUID id) {
        boardService.deleteAllByUserId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

