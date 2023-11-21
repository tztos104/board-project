package com.boardproject.boardproject.repository;

import com.boardproject.boardproject.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}