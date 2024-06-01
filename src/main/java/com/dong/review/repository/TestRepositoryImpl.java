package com.dong.review.repository;


import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TestRepositoryImpl {
    private final JPAQueryFactory queryFactory;


}

