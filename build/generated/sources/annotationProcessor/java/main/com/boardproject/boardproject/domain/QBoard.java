package com.boardproject.boardproject.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = 227565065L;

    public static final QBoard board = new QBoard("board");

    public final QAuditingFields _super = new QAuditingFields(this);

    public final SetPath<BoardComment, QBoardComment> boardComments = this.<BoardComment, QBoardComment>createSet("boardComments", BoardComment.class, QBoardComment.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    //inherited
    public final StringPath createBy = _super.createBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    public final StringPath hashtag = createString("hashtag");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath modifyBy = _super.modifyBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifyDate = _super.modifyDate;

    public final StringPath title = createString("title");

    public QBoard(String variable) {
        super(Board.class, forVariable(variable));
    }

    public QBoard(Path<? extends Board> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoard(PathMetadata metadata) {
        super(Board.class, metadata);
    }

}

