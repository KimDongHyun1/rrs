package com.dong.review.stock.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsStockInfoResVO {
    private Output output;
    private String rt_cd;
    private String msg_cd;
    private String msg1;

    @Setter
    @Getter
    @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Output {
        private String last; //현재가
        private String tomv; //시가총액
        private String h52p; //52주 최고가
        private String l52p; //52주 최저가
        private String perx; //per
    }

}


