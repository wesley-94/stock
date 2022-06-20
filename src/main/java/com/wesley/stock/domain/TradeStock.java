package com.wesley.stock.domain;

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
    private Stock stock; // 거래 주식

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trade_id")
    private Trade trade; // 거래

    private int tradePrice; // 거래 가격
    private int count; // 거래 가격

}
