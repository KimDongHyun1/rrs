package com.dong.review.stock.controller;

import com.dong.review.stock.service.KoreanStockService;
import com.dong.review.stock.vo.KoreanStockInfoReqVO;
import com.dong.review.stock.vo.KoreanStockInfoResVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("koreanStock")
@RequiredArgsConstructor
public class KoreanStockController {
    private final KoreanStockService koreanStockService;

    @GetMapping("info")
    @ResponseBody
    public KoreanStockInfoResVO info(KoreanStockInfoReqVO reqVO) throws Exception {
        return koreanStockService.info(reqVO);
    }

}
