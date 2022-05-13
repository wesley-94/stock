package com.wesley.stock.domain.posts;

import com.wesley.stock.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    private int currentPrice;
    private int allTimeHighPrice;
    private int allTimeLowPrice;
    private double PER;
    private double estimatePER;
    private double PBR;
    private double dividendRate;

    @Builder
    public Posts(String stockName, String sector, int currentPrice, int allTimeHighPrice, int allTimeLowPrice, double PER, double estimatePER, double PBR, double dividendRate) {
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

    public void update(String stockName, String sector, int currentPrice, int allTimeHighPrice, int allTimeLowPrice, double PER, double estimatePER, double PBR, double dividendRate) {
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

}
