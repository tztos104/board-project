package com.boardproject.boardproject.repository;

import com.boardproject.boardproject.domain.BoardComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardCommentRepository extends JpaRepository<BoardComment, Long> {
}