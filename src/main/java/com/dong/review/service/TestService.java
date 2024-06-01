package com.dong.review.service;


import com.dong.review.model.TestEntity;
import com.dong.review.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public void create(String name, int age) {
        TestEntity testEntity = TestEntity.builder()
                .name(name)
                .age(age)
                .build();

        testRepository.save(testEntity);
    }

}
