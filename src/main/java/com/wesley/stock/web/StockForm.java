package com.wesley.stock.web;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StockForm {

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
    private int quantity;

}
