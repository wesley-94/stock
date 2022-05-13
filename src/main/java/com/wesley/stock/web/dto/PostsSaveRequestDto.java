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
    private double PER;
    private double estimatePER;
    private double PBR;
    private double dividendRate;

    @Builder
    public PostsSaveRequestDto(String stockName, String sector, int currentPrice, int allTimeHighPrice, int allTimeLowPrice, double PER, double estimatePER, double PBR, double dividendRate) {
        this.stockName = stockName;
        this.sector = sector;
        this.currentPrice = currentPrice;
        this.allTimeHighPrice = allTimeHighPrice;
        this.allTimeLowPrice = allTimeLowPrice;
        this.PER = PER;
        this.estimatePER = estimatePER;
        this.PBR = PBR;
        this.dividendRate = dividendRate;
    }

    public Posts toEntity() {
        return Posts.builder()
                .stockName(stockName)
                .sector(sector)
                .currentPrice(currentPrice)
                .allTimeHighPrice(allTimeHighPrice)
                .allTimeLowPrice(allTimeLowPrice)
                .PER(PER)
                .estimatePER(estimatePER)
                .PBR(PBR)
                .dividendRate(dividendRate)
                .build();
    }

}
