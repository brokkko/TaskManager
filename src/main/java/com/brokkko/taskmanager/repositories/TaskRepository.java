package com.brokkko.taskmanager.repositories;

import com.brokkko.taskmanager.models.TaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {
    Page<TaskEntity> findAllByBoardId(UUID board_id, Pageable pageable);
    List<TaskEntity> getAllByStatusAndBoardId(String status, UUID boardId);
    @Transactional
    void deleteAllByBoardId(UUID boardId);
}
