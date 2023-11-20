package com.boardproject.boardproject.domain;

import java.time.LocalDateTime;

public class BoardComment {
    private Long id;
    private Board board;
    private String content;


    private LocalDateTime createDate;
    private String createBy;
    private LocalDateTime modifyDate;
    private String modifyBy;
}
