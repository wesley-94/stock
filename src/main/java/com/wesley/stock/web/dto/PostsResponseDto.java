package com.wesley.stock.web.dto;

import com.wesley.stock.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private Long id;
    private String stockName;
    private String sector;
    private int currentPrice;
    private int allTimeHighPrice;
    private int allTimeLowPrice;
    private double priceEarningRatio;
    private double estimatePER;
    private double priceBookValueRatio;
    private double dividendRate;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.stockName = entity.getStockName();
        this.sector = entity.getSector();
        this.currentPrice = entity.getCurrentPrice();
        this.allTimeHighPrice = entity.getAllTimeHighPrice();
        this.allTimeLowPrice = entity.getAllTimeLowPrice();
        this.priceEarningRatio = entity.getPriceEarningRatio();
        this.estimatePER = entity.getEstimatePER();
        this.priceBookValueRatio = entity.getPriceBookValueRatio();
        this.dividendRate = entity.getDividendRate();
    }
}
