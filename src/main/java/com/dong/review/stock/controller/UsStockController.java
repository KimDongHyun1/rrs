package com.dong.review.stock.controller;

import com.dong.review.stock.service.UsStockService;
import com.dong.review.stock.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usStock")
@RequiredArgsConstructor
public class UsStockController {
    private final UsStockService usStockService;

    /**
     * 미국 주식 개별 종목의 차트를 조회한다.
     */
    @PostMapping("chart")
    @ResponseBody
    public UsStockChartResVO chart(@RequestBody UsStockChartReqVO reqVO) throws Exception {
        return usStockService.chart(reqVO);
    }

    /**
     * 미국 주식 개별 종목을 상세 조회한다.
     */
    @PostMapping("info")
    @ResponseBody
    public UsStockInfoResVO info(@RequestBody UsStockInfoReqVO reqVO) throws Exception {
        return usStockService.info(reqVO);
    }



}
