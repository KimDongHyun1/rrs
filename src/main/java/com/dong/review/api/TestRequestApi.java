package com.dong.review.api;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @RequestParam
 * @PathVariable
 * @RequestBody
 * @RequestBody
 * @ResponseBody : type이 string인 경우 String으로 return, object인 경우 json으로 return
 */
@RestController
public class TestRequestApi {


    @GetMapping("/test/param")
    public String requestParam(
            @RequestParam(value = "name", defaultValue = "default-name") String name,
            @RequestParam(value = "age", defaultValue = "40") String age
     ) {
        return "name ::: " + name + ", age ::: " + age;
    }

    @GetMapping("/test/path/{name}/{age}")
    public String requestPathVar(
            @PathVariable("name") String name,
            @PathVariable("age") String age
    ) {
        return "requestPathVar ::: " + name + age;
    }

    @PostMapping("/test/body")
    public @ResponseBody String requestPathVar(@RequestBody Map paramMap) {
        String name = (String) paramMap.get("name");
        int age = (int) paramMap.get("age");


        return "RequestBody ::: " + name + age;
    }


}
