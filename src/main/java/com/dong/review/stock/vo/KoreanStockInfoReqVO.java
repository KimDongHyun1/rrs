package com.dong.review.stock.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KoreanStockInfoReqVO {
    private String fidCondMrktDivCode;  //FID 조건 시장 분류 코드
    private String fidInputIscd;        //FID 입력 종목코드
}
