package com.brokkko.taskmanager.domain;

import com.brokkko.taskmanager.domain.boards.Board;
import com.brokkko.taskmanager.domain.boards.BoardService;
import com.brokkko.taskmanager.domain.users.User;
import com.brokkko.taskmanager.domain.users.UserService;
import com.brokkko.taskmanager.services.mapping.board.MappingBoardService;
import com.brokkko.taskmanager.services.mapping.user.MappingUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardServiceTests {
    @Autowired
    private BoardService boardService;
    @Autowired
    private UserService userService;
    @MockBean
    private MappingBoardService mappingBoardService;
    @MockBean
    private MappingUserService mappingUserService;

    @Test
    public void saveBoard(){
        User user = userService.create(
                User.builder()
                .username("test username")
                .password("password")
                .build()
        );
        Board board = Board.builder()
                .name("test board")
                .build();
        Board savedBoard = boardService.create(board, user.getId());
        Assert.assertEquals(board.getName(), savedBoard.getName());
        Assert.assertEquals(user, savedBoard.getUser());
        Assert.assertNotNull(savedBoard.getId());
    }

    @Test
    public void updateBoard() {
//        User user = userService.create(
//                User.builder()
//                        .username("test username")
//                        .password("password")
//                        .build()
//        );
//        Board board = Board.builder()
//                .id(UUID.randomUUID())
//                .name("test board")
//                .build();
//        Board savedBoard = boardService.create(board, user.getId());
//        savedBoard.setName("updated board name");
//        Board updatedBoard = boardService.update(board);
//        Assert.assertNotEquals(savedBoard.getName(), updatedBoard.getName());
//        Assert.assertEquals("updated board name", updatedBoard.getName());
    }

    @Test
    public void getBoard(){
        // UUID id
//        User user = userService.create(
//                User.builder()
//                        .username("test username")
//                        .password("password")
//                        .build()
//        );
//        Board board = Board.builder()
//                .name("test board")
//                .build();
//        Board savedBoard = boardService.create(board, user.getId());
//        Board returnedBoard = boardService.get(savedBoard.getId());
//        Assert.assertEquals(savedBoard, returnedBoard);
    }
}
