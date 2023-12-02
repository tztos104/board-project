package com.boardproject.boardproject.repository;

import com.boardproject.boardproject.domain.Board;
import com.boardproject.boardproject.domain.BoardComment;
import com.boardproject.boardproject.domain.QBoardComment;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface BoardCommentRepository extends
        JpaRepository<BoardComment, Long>,
        QuerydslPredicateExecutor<BoardComment>,
        QuerydslBinderCustomizer<QBoardComment>
{
    @Override
    default void customize(QuerydslBindings bindings, QBoardComment root){
        bindings.excludeUnlistedProperties(true);
        bindings.including( root.content,  root.createDate, root.createBy);
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.createDate).first(DateTimeExpression::eq);
        bindings.bind(root.createBy).first(StringExpression::containsIgnoreCase);

    };
}