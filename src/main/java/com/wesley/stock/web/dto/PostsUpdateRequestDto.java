package com.wesley.stock.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {

    private String stockName;
    private String sector;
    private int currentPrice;
    private int allTimeHighPrice;
    private int allTimeLowPrice;
    private double priceEarningRatio;
    private double estimatePER;
    private double priceBookValueRatio;
    private double dividendRate;

    @Builder
    public PostsUpdateRequestDto(String stockName, String sector, int currentPrice, int allTimeHighPrice, int allTimeLowPrice, double priceEarningRatio, double estimatePER, double priceBookValueRatio, double dividendRate) {
        this.stockName = stockName;
        this.sector = sector;
        this.currentPrice = currentPrice;
        this.allTimeHighPrice = allTimeHighPrice;
        this.allTimeLowPrice = allTimeLowPrice;
        this.priceEarningRatio = priceEarningRatio;
        this.estimatePER = estimatePER;
        this.priceBookValueRatio = priceBookValueRatio;
        this.dividendRate = dividendRate;
    }

}
