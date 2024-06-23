package com.dong.review.stock.service;

import com.dong.review.stock.vo.KoreanStockInfoReqVO;
import com.dong.review.stock.vo.KoreanStockInfoResVO;
import com.dong.review.stock.vo.TokenResVO;
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
public class KoreanStockService {

    @Value("${stock.appkey}")
    private String appKey;

    @Value("${stock.appsecret}")
    private String appSecret;

    private final TokenService tokenService;

    /**
     * 국내 주식 시세 조회
     */
    public KoreanStockInfoResVO info(KoreanStockInfoReqVO reqVO) throws Exception {
        String reqUrl = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/inquire-price";
        String trId = "FHKST01010100";

        String data = new StringBuilder()
                .append("?fid_cond_mrkt_div_code=").append(reqVO.getFidCondMrktDivCode())
                .append("&fid_input_iscd=").append(reqVO.getFidInputIscd())
                .toString();

        String authToken = tokenService.createToken();
        KoreanStockInfoResVO resVO;

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
            resVO = objectMapper.readValue(response.toString(), KoreanStockInfoResVO.class);


        } catch (Exception e) {
            throw new Exception("조회 실패", e);
        }

        return resVO;
    }


}
