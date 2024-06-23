package com.dong.review.stock.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
        private BigDecimal last; //현재가
        private BigDecimal tomv; //시가총액
        private BigDecimal h52p; //52주 최고가
        private BigDecimal l52p; //52주 최저가
        private BigDecimal perx; //per
        private String rsym; //name

        public void setLast(BigDecimal last) {
            this.last = setScaleToTwo(last);
        }

        public void setTomv(BigDecimal tomv) {
            this.tomv = setScaleToTwo(tomv);
        }

        public void setH52p(BigDecimal h52p) {
            this.h52p = setScaleToTwo(h52p);
        }

        public void setL52p(BigDecimal l52p) {
            this.l52p = setScaleToTwo(l52p);
        }

        public void setPerx(BigDecimal perx) {
            this.perx = setScaleToTwo(perx);
        }

        public void setRsym(String rsym) {
            if (rsym != null && rsym.length() > 4) {
                this.rsym = rsym.substring(4);
            } else {
                this.rsym = rsym;
            }
        }

        private BigDecimal setScaleToTwo(BigDecimal value) {
            if (value != null) {
                return value.setScale(2, RoundingMode.HALF_UP);
            } else {
                return null;
            }
        }
    }

}


