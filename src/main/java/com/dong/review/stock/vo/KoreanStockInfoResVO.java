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
public class KoreanStockInfoResVO {
    private Output output;
    private String rt_cd;
    private String msg_cd;
    private String msg1;

    @Setter
    @Getter
    @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Output {
        private String iscdStatClsCode;
        private String margRate;
        private String rprsMrktKorName;
        private String bstpKorIsnm;
        private String tempStopYn;
        private String oprcRangContYn;
        private String clprRangContYn;
        private String crdtAbleYn;
        private String grmnRateClsCode;
        private String elwPblcYn;
        private String stckPrpr;
        private String prdyVrss;
        private String prdyVrssSign;
        private String prdyCtrt;
        private String acmlTrPbmn;
        private String acmlVol;
        private String prdyVrssVolRate;
        private String stckOprc;
        private String stckHgpr;
        private String stckLwpr;
        private String stckMxpr;
        private String stckLlam;
        private String stckSdpr;
        private String wghnAvrgStckPrc;
        private String htsFrgnEhrt;
        private String frgnNtbyQty;
        private String pgtrNtbyQty;
        private String pvtScndDmrsPrc;
        private String pvtFrstDmrsPrc;
        private String pvtPontVal;
        private String pvtFrstDmspPrc;
        private String pvtScndDmspPrc;
        private String dmrsVal;
        private String dmspVal;
        private String cpfn;
        private String rstcWdthPrc;
        private String stckFcam;
        private String stckSspr;
        private String asprUnit;
        private String htsDealQtyUnitVal;
        private String lstnStcn;
        private String htsAvls;
        private String per;
        private String pbr;
        private String stacMonth;
        private String volTnrt;
        private String eps;
        private String bps;
        private String d250Hgpr;
        private String d250HgprDate;
        private String d250HgprVrssPrprRate;
        private String d250Lwpr;
        private String d250LwprDate;
        private String d250LwprVrssPrprRate;
        private String stckDryyHgpr;
        private String dryyHgprVrssPrprRate;
        private String dryyHgprDate;
        private String stckDryyLwpr;
        private String dryyLwprVrssPrprRate;
        private String dryyLwprDate;
        private String w52Hgpr;
        private String w52HgprVrssPrprCtrt;
        private String w52HgprDate;
        private String w52Lwpr;
        private String w52LwprVrssPrprCtrt;
        private String w52LwprDate;
        private String wholLoanRmndRate;
        private String sstsYn;
        private String stckShrnIscd;
        private String fcamCnnm;
        private String cpfnCnnm;
        private String frgnHldnQty;
        private String viClsCode;
        private String ovtmViClsCode;
        private String lastSstsCntgQty;
        private String invtCafulYn;
        private String mrktWarnClsCode;
        private String shortOverYn;
        private String sltrYn;
    }

}


