package com.wesley.stock.web;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TradeForm {

    private Long memberId;

    private Long stockId;

    private int count;

}
