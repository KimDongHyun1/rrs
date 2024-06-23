package com.dong.review.stock.service;

import com.dong.review.stock.vo.TokenResVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class TokenService {
    @Value("${stock.grant_type}")
    private String grantType;

    @Value("${stock.appkey}")
    private String appKey;

    @Value("${stock.appsecret}")
    private String appSecret;

    public String createToken() throws Exception {
        URL url = new URL("https://openapi.koreainvestment.com:9443/oauth2/tokenP");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        try {
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            //JSON 형식으로 요청 본문 작성
            StringBuilder jsonInputString = new StringBuilder();
            jsonInputString.append("{")
                    .append("\"grant_type\": \"").append(grantType).append("\",")
                    .append("\"appkey\": \"").append(appKey).append("\",")
                    .append("\"appsecret\": \"").append(appSecret).append("\"")
                    .append("}");

            //request
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.toString().getBytes("utf-8");
                os.write(input, 0, input.length); //request
            }

            //response
            StringBuilder response = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
            }

            // JSON 응답을 Response 객체로 매핑
            ObjectMapper objectMapper = new ObjectMapper();
            TokenResVO tokenResVO = objectMapper.readValue(response.toString(), TokenResVO.class);

            return "Bearer " + tokenResVO.getAccessToken();

        } catch (IOException e) {
            throw new Exception("토큰 생성 실패", e);
        } finally {
            conn.disconnect();
        }
    }


}
