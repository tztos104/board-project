package com.boardproject.boardproject.repository;

import com.boardproject.boardproject.domain.Board;
import com.boardproject.boardproject.domain.QBoard;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BoardRepository extends
        JpaRepository<Board, Long>,
        QuerydslPredicateExecutor<Board>,
        QuerydslBinderCustomizer<QBoard>
{

    @Override
    default void customize(QuerydslBindings bindings, QBoard root){
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.title, root.content, root.hashtag, root.createDate, root.createBy);
        bindings.bind(root.title).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.hashtag).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.createDate).first(DateTimeExpression::eq);
        bindings.bind(root.createBy).first(StringExpression::containsIgnoreCase);

    };
}