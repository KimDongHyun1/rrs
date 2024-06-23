package com.dong.review.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(Model model) {

        List<String> resultList = new ArrayList<>();
        resultList.add("AAA");
        resultList.add("BBB");

        model.addAttribute("list", resultList);

        return "main";
    }

    @GetMapping("/api/data")
    @ResponseBody
    public Map<String, String> fetchData() {
        // 예시 데이터를 맵 형태로 생성하여 반환합니다.
        Map<String, String> data = new HashMap<>();
        data.put("message", "Hello from server!");
        return data;
    }



}
