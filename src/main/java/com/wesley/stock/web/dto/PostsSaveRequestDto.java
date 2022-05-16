package com.wesley.stock.web.dto;

import com.wesley.stock.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

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
    public PostsSaveRequestDto(String stockName, String sector, int currentPrice, int allTimeHighPrice, int allTimeLowPrice, double priceEarningRatio, double estimatePER, double priceBookValueRatio, double dividendRate) {
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

    public Posts toEntity() {
        return Posts.builder()
                .stockName(stockName)
                .sector(sector)
                .currentPrice(currentPrice)
                .allTimeHighPrice(allTimeHighPrice)
                .allTimeLowPrice(allTimeLowPrice)
                .priceEarningRatio(priceEarningRatio)
                .estimatePER(estimatePER)
                .priceBookValueRatio(priceBookValueRatio)
                .dividendRate(dividendRate)
                .build();
    }

}
