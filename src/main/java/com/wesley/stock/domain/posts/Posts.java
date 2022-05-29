package com.wesley.stock.domain.posts;

import com.wesley.stock.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String stockName;

    @Column(nullable = false)
    private String sector;

    @NumberFormat(pattern = "###,###")
    private int currentPrice;
    @NumberFormat(pattern = "###,###")
    private int allTimeHighPrice;
    @NumberFormat(pattern = "###,###")
    private int allTimeLowPrice;
    private double priceEarningRatio;
    private double estimatePER;
    private double priceBookValueRatio;
    private double dividendRate;

    @Builder
    public Posts(String stockName, String sector, int currentPrice, int allTimeHighPrice, int allTimeLowPrice, double priceEarningRatio, double estimatePER, double priceBookValueRatio, double dividendRate) {
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

    public void update(String stockName, String sector, int currentPrice, int allTimeHighPrice, int allTimeLowPrice, double priceEarningRatio, double estimatePER, double priceBookValueRatio, double dividendRate) {
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
