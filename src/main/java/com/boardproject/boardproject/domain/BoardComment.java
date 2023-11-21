package com.boardproject.boardproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Objects;


@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createDate"),
        @Index(columnList = "createBy")
})
@EntityListeners(AuditingEntityListener.class)
@Entity
public class BoardComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @ManyToOne(optional = false)
    private Board board;
    @Setter @Column(nullable = false, length = 1000)
    private String content;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createDate;

    @CreatedBy
    @Column(nullable = false, length = 100)
    private String createBy;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modifyDate;

    @LastModifiedBy
    @Column(nullable = false, length = 100)
    private String modifyBy;

    protected BoardComment() {
    }

    private BoardComment(Board board, String content) {
        this.board = board;
        this.content = content;
    }

    public static BoardComment of(Board board, String content) {
        return new BoardComment(board, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoardComment that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
