package com.boardproject.boardproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createDate"),
        @Index(columnList = "createBy")
})
@Entity
public class Board {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Setter @Column(nullable = false)
   private String title;
   @Setter @Column(nullable = false, length = 10000)
   private String content;
   @Setter
   private String hashtag;


   @CreatedDate @Column(nullable = false)
   private LocalDateTime createDate;

   @CreatedBy @Column(nullable = false, length = 100)
   private String createBy;

   @LastModifiedDate @Column(nullable = false)
   private LocalDateTime modifyDate;

   @LastModifiedBy @Column(nullable = false, length = 100)
   private String modifyBy;

   protected Board() {
   }

   private Board(String title, String content, String hashtag) {
      this.title = title;
      this.content = content;
      this.hashtag = hashtag;
   }

   public static Board of(String title, String content, String hashtag){
      return new Board(title, content, hashtag);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Board board)) return false;
      return Objects.equals(id, board.id);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id);
   }
}
