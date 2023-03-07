package com.wesley.stock.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "trade_stock")
@Getter @Setter
public class TradeStock {

    @Id @GeneratedValue
    @Column(name = "trade_stock_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id")
    @JsonIgnore
    private Stock stock; // 거래 주식

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trade_id")
    @JsonIgnore
    private Trade trade; // 거래

    private int tradePrice; // 거래 가격
    private int count; // 거래 수량

    // == 생성 메서드 == //
    public static TradeStock createTradeStock(Stock stock, int tradePrice, int count) {
        TradeStock tradeStock = new TradeStock();
        tradeStock.setStock(stock);
        tradeStock.setTradePrice(tradePrice);
        tradeStock.setCount(count);

        stock.removeStock(count);
        return tradeStock;
    }

    // == 비즈니스 로직 == //
    /**
     * 거래 취소
     */
    public void cancel() {
        getStock().addStock(count);
    }

    // == 조회 로직 == //
    /**
     * 거래 주식 전체 가격 조회
     */
    public int getTotalPrice() {
        return getTradePrice() * getCount();
    }

}
