package com.wesley.stock.domain;

public class TradeSearch {

    private String memberName; // 회원 이름
    private TradeStatus tradeStatus; // 거래 상태 [TRADE, CANCEL]

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public TradeStatus getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(TradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus;
    }
}
