package com.boardproject.boardproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.GenerationType;
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
