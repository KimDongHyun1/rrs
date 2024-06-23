package com.dong.review.stock.service;

import com.dong.review.stock.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class UsStockService {

    @Value("${stock.appkey}")
    private String appKey;

    @Value("${stock.appsecret}")
    private String appSecret;

    private final TokenService tokenService;

    /**
     * 미국 주식 차트 조회
     */
    public UsStockChartResVO chart(UsStockChartReqVO reqVO) throws Exception {
        String reqUrl = "https://openapi.koreainvestment.com:9443/uapi/overseas-price/v1/quotations/dailyprice";
        String trId = "HHDFS76240000";

        String data = new StringBuilder()
                .append("?AUTH=").append(reqVO.getAuth())
                .append("&EXCD=").append(reqVO.getExcd())
                .append("&SYMB=").append(reqVO.getSymb())
                .append("&GUBN=").append(reqVO.getGubn())
                .append("&BYMD=").append(reqVO.getBymd())
                .append("&MODP=").append(reqVO.getModp())
                .toString();

        String authToken = tokenService.createToken();
        UsStockChartResVO resVO;

        try {
            URL url = new URL(reqUrl + data);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            conn.setRequestProperty("authorization", authToken);
            conn.setRequestProperty("appKey", appKey);
            conn.setRequestProperty("appSecret", appSecret);
            conn.setRequestProperty("tr_id", trId);
            conn.setDoOutput(true);
            conn.connect();


            StringBuilder response = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
                String responseData;
                while ((responseData = br.readLine()) != null) {
                    response.append(responseData);
                }
            }

            // JSON 응답을 Response 객체로 매핑
            ObjectMapper objectMapper = new ObjectMapper();
            resVO = objectMapper.readValue(response.toString(), UsStockChartResVO.class);

        } catch (Exception e) {
            throw new Exception("조회 실패", e);
        }

        return resVO;
    }

    /**
     * 미국 주식 시세 조회
     */
    public UsStockInfoResVO info(UsStockInfoReqVO reqVO) throws Exception {
        String reqUrl = "https://openapi.koreainvestment.com:9443/uapi/overseas-price/v1/quotations/price-detail";
        String trId = "HHDFS76200200";

        String data = new StringBuilder()
                .append("?AUTH=").append(reqVO.getAuth())
                .append("&EXCD=").append(reqVO.getExcd())
                .append("&SYMB=").append(reqVO.getSymb())
                .toString();

        String authToken = tokenService.createToken();
        UsStockInfoResVO resVO;

        try {
            URL url = new URL(reqUrl + data);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            conn.setRequestProperty("authorization", authToken);
            conn.setRequestProperty("appKey", appKey);
            conn.setRequestProperty("appSecret", appSecret);
            conn.setRequestProperty("tr_id", trId);
            conn.setDoOutput(true);
            conn.connect();


            StringBuilder response = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
                String responseData;
                while ((responseData = br.readLine()) != null) {
                    response.append(responseData);
                }
            }

            // JSON 응답을 Response 객체로 매핑
            ObjectMapper objectMapper = new ObjectMapper();
            resVO = objectMapper.readValue(response.toString(), UsStockInfoResVO.class);


        } catch (Exception e) {
            throw new Exception("조회 실패", e);
        }

        return resVO;
    }


}
