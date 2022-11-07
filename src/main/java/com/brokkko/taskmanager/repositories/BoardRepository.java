package com.brokkko.taskmanager.repositories;

import com.brokkko.taskmanager.models.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface BoardRepository extends JpaRepository<BoardEntity, UUID> {
    Page<BoardEntity> findAllByUserId(UUID user_id, Pageable pageable);
    @Transactional
    void deleteAllByUserId(UUID userId);
}
