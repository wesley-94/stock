package com.wesley.stock.domain;

import com.wesley.stock.exception.NotEnoughStockException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
//@NoArgsConstructor
public class Stock {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
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
    private int quantity;

    @ManyToMany(mappedBy = "stocks")
    private List<Category> categories = new ArrayList<Category>();

//    @Builder
//    public Stock(String stockName, String sector, int currentPrice, int allTimeHighPrice, int allTimeLowPrice, double priceEarningRatio, double estimatePER, double priceBookValueRatio, double dividendRate) {
//        this.stockName = stockName;
//        this.sector = sector;
//        this.currentPrice = currentPrice;
//        this.allTimeHighPrice = allTimeHighPrice;
//        this.allTimeLowPrice = allTimeLowPrice;
//        this.priceEarningRatio = priceEarningRatio;
//        this.estimatePER = estimatePER;
//        this.priceBookValueRatio = priceBookValueRatio;
//        this.dividendRate = dividendRate;
//    }

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

    // == 비즈니스 로직 == //
    public void addStock(int addQuantity) {
        this.quantity += addQuantity;
    }

    public void removeStock(int removeQuantity) {
        int restQuantity = this.quantity - removeQuantity;
        if (restQuantity < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.quantity = restQuantity;
    }

}
