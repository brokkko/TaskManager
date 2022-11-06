package com.brokkko.taskmanager.repositories;

import com.brokkko.taskmanager.models.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BoardRepository extends JpaRepository<BoardEntity, UUID> {
}
