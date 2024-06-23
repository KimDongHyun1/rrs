package com.dong.review.stock.controller;

import com.dong.review.stock.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stock")
@RequiredArgsConstructor
public class TokenController {
    private final TokenService tokenService;

    /**
     * 접근토큰발급
     */
    @GetMapping("/createToken")
    @ResponseBody
    public String createToken() throws Exception {
        return tokenService.createToken();
    }
}