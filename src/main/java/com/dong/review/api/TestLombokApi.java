package com.dong.review.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestLombokApi {

    @PostMapping("/test/lombok")
    public @ResponseBody String testLombok(@RequestBody TestLombokRes testLombokRes) {
        String name = testLombokRes.getName();
        Integer age = testLombokRes.getAge();

        return "testLombok ::: " + name + ", " + age;
    }



    @Setter @Getter
    public static class TestLombokRes {
        String name;
        Integer age;
    }

}
