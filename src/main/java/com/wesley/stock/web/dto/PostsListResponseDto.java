package com.wesley.stock.web.dto;

import com.wesley.stock.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String stockName;
    private String sector;
    private int currentPrice;
    private int allTimeHighPrice;
    private int allTimeLowPrice;
    private double PER;
    private double estimatePER;
    private double PBR;
    private double dividendRate;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.stockName = entity.getStockName();
        this.sector = entity.getSector();
        this.currentPrice = entity.getCurrentPrice();
        this.allTimeHighPrice = entity.getAllTimeHighPrice();
        this.allTimeLowPrice = entity.getAllTimeLowPrice();
        this.PER = entity.getPER();
        this.estimatePER = entity.getEstimatePER();
        this.PBR = entity.getPBR();
        this.dividendRate = entity.getDividendRate();
        this.modifiedDate = entity.getModifiedDate();
    }
}
