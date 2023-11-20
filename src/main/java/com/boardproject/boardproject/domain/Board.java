package com.boardproject.boardproject.domain;

import java.time.LocalDateTime;

public class Board {
   private Long id;
   private String title;
   private String content;
   private String hashtag;

   private LocalDateTime createDate;
   private String createBy;
   private LocalDateTime modifyDate;
   private String modifyBy;
}
