package com.dong.review.stock.vo;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsStockInfoReqVO {
    private String auth;
    private String excd;
    private String symb;
}
