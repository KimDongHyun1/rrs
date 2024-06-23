package com.dong.review.stock.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsStockChartReqVO {
    private String auth;
    private String excd;
    private String symb;
    private String gubn;
    private String bymd;
    private String modp;
}
