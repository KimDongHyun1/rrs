package com.dong.review.api;

import com.dong.review.service.TestService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestEntityApi {

    private final TestService testService;

    @PostMapping("/test/entity/create")
    public void createTestEntity(@RequestBody CreateTestEntityRequest req) {
        testService.create(req.getName(), req.getAge());

    }

    @Getter
    @Setter
    public static class CreateTestEntityRequest {
        private String name;
        private int age;

    }

}
