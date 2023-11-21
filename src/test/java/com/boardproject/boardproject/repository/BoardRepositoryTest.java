package com.boardproject.boardproject.repository;

import com.boardproject.boardproject.config.JpaConfig;
import com.boardproject.boardproject.domain.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("JPA 연결테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest  {

        private final BoardRepository boardRepository;
        private final BoardCommentRepository boardCommentRepository;

    public JpaRepositoryTest(
           @Autowired BoardRepository boardRepository,
           @Autowired BoardCommentRepository boardCommentRepository) {
        this.boardRepository = boardRepository;
        this.boardCommentRepository = boardCommentRepository;
    }
    @DisplayName("select 테스트")
    @Test
    void givenTestData_whenSelecting_thenWorksFine() {
        //given

        //when

        List<Board> board = boardRepository.findAll();

        //then
        assertThat(board)
                .isNotNull()
                .hasSize(0);

    }

}