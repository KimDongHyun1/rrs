package com.dong.review.stock.controller;

import com.dong.review.stock.service.UsStockService;
import com.dong.review.stock.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<Object, Object> chart(@RequestBody UsStockChartReqVO reqVO) throws Exception {
        UsStockChartResVO chart = usStockService.chart(reqVO);

        Map<Object, Object> resultMap = new HashMap<>();
        List<String> header = new ArrayList<>();
        List<String> value = new ArrayList<>();

//        List<UsStockChartResVO.Output2> output2 = chart.getOutput2();
        for(UsStockChartResVO.Output2 output2 :  chart.getOutput2()) {
            header.add(output2.getXymd());
            value.add(output2.getClos());
        }

        resultMap.put("header", header);
        resultMap.put("data", value);


        return resultMap;
    }

    /**
     * 미국 주식 개별 종목을 상세 조회한다.
     */
    @PostMapping("info")
    @ResponseBody
    public UsStockInfoResVO info(@RequestBody UsStockInfoReqVO reqVO) throws Exception {
        return usStockService.info(reqVO);
    }

    /**
     * 미국 주식 개별 종목 목록을 조회한다.
     */
    @PostMapping("infoList")
    @ResponseBody
    public List<UsStockInfoResVO> infoList(@RequestBody UsStockInfoReqVO reqVO) throws Exception {
        List<UsStockInfoResVO> resultList = usStockService.infoList(reqVO);
        return resultList;
    }



}
