package com.dong.review.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {

    @GetMapping("/hello/world")
    public @ResponseBody String helloWorld() {
        return "Hello, World!";
    }

}
