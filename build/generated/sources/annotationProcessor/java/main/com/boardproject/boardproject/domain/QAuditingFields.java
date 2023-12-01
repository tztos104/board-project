package com.boardproject.boardproject.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuditingFields is a Querydsl query type for AuditingFields
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QAuditingFields extends EntityPathBase<AuditingFields> {

    private static final long serialVersionUID = -800881667L;

    public static final QAuditingFields auditingFields = new QAuditingFields("auditingFields");

    public final StringPath createBy = createString("createBy");

    public final DateTimePath<java.time.LocalDateTime> createDate = createDateTime("createDate", java.time.LocalDateTime.class);

    public final StringPath modifyBy = createString("modifyBy");

    public final DateTimePath<java.time.LocalDateTime> modifyDate = createDateTime("modifyDate", java.time.LocalDateTime.class);

    public QAuditingFields(String variable) {
        super(AuditingFields.class, forVariable(variable));
    }

    public QAuditingFields(Path<? extends AuditingFields> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuditingFields(PathMetadata metadata) {
        super(AuditingFields.class, metadata);
    }

}

