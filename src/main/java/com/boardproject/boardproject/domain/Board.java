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

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createDate"),
        @Index(columnList = "createBy")
})
@Entity
public class Board extends AuditingFields {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Setter @Column(nullable = false)
   private String title;
   @Setter @Column(nullable = false, length = 10000)
   private String content;
   @Setter
   private String hashtag;

   @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
   @ToString.Exclude
   private  final Set<BoardComment> boardComments = new LinkedHashSet<>();






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
