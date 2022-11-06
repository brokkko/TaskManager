package com.brokkko.taskmanager;

import com.brokkko.taskmanager.enumerations.TaskStatus;
import com.brokkko.taskmanager.models.BoardEntity;
import com.brokkko.taskmanager.models.TaskEntity;
import com.brokkko.taskmanager.models.UserEntity;
import com.brokkko.taskmanager.repositories.BoardRepository;
import com.brokkko.taskmanager.repositories.TaskRepository;
import com.brokkko.taskmanager.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class EntitiesStructureTest {
//    @Autowired
//    private BoardRepository boardRepository;
//    @Autowired
//    private TaskRepository taskRepository;
//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    public void saveBoardTasksToTaskRepository() {
//        Date date = new Date();
//        BoardEntity board = new BoardEntity("board_name_1");
//        board.addTaskEntity(new TaskEntity(
//                "task_name_1",
//                "description_1",
//                date,
//                date,
//                "DONE"
//        ));
//        board.addTaskEntity(new TaskEntity(
//                "task_name_2",
//                "description_2",
//                date,
//                date,
//                "TODO"
//        ));
//        board.addTaskEntity(new TaskEntity(
//                "task_name_3",
//                "description_3",
//                date,
//                date,
//                "IN_PROGRESS"
//        ));
//        board = boardRepository.save(board);
//        Assertions.assertEquals(3, taskRepository.count());
//    }
//
//    @Test
//    public void saveUsersBoardsToBoardRepository() {
//        Date date = new Date();
//        UserEntity user = new UserEntity("password", "username");
//        user.addBoardEntity(new BoardEntity("board_1"));
//        user.addBoardEntity(new BoardEntity("board_2"));
//        user = userRepository.save(user);
//        Assertions.assertEquals(2, boardRepository.count());
//    }


}
